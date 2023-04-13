package ms.main.controller;

import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DBCPInitServlet extends HttpServlet {

	Logger log = LoggerFactory.getLogger(DBCPInitServlet.class);
	
	@Override
    public void init() throws ServletException {
		loadJDBCDriver();
    	initConnectionPool();
    }
	
	/**
	 *	JDBC Driver load
	 */
	private void loadJDBCDriver() {
		String driver = getInitParameter("jdbcdriver");
		try {
			Class.forName(driver);
			System.out.println("Success to Load JDBC Driver");
		} catch (Exception e) {
			throw new RuntimeException("Fail to load JDBC Driver",e);
		}
	}
	
	/**
	 * Initialize DB Connection Pool
	 */
	private void initConnectionPool() {
		try {
			String jdbcUrl = getInitParameter("jdbcUrl");
			String user = getInitParameter("dbUser");
			String pw = getInitParameter("dbPass");
			String poolName = getInitParameter("poolName");
			
			ConnectionFactory connFactory = new DriverManagerConnectionFactory(jdbcUrl, user, pw);
			PoolableConnectionFactory poolableConnFactory = new PoolableConnectionFactory(connFactory, null);
			poolableConnFactory.setValidationQuery("select 1 from dual"); 		// oracle 용 Connection 테스트 쿼리
			
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
            poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L);		// pool connection검사 주기
            poolConfig.setTestWhileIdle(true);									// Connection 유효한지 검사
            poolConfig.setMinIdle(4);											// Connection 최소 갯수 설정
            poolConfig.setMaxTotal(50);											// Connection 최대 갯수 설정
            
            GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnFactory, poolConfig);
            poolableConnFactory.setPool(connectionPool);
            
            Class.forName("org.apache.commons.dbcp2.PoolingDriver");
            PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
            driver.registerPool(poolName, connectionPool);
            System.out.println("Success to Initilize Connection Pool");
		} catch (Exception e) {
			throw new RuntimeException("Fail to Initilize Connection Pool",e);
		}
	}
}

package ms.main.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import ms.main.vo.Main;

public class MainDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public MainDAO() {
		
		try {
			
			prop = new Properties();
			
			String filePath = MainDAO.class.getResource("ms/main/sql/main-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));

			
		}catch(Exception e) {
			
		}
		
		
	}
	
	
	public List<Main> selectDB(Connection conn) {
		
		return null;
	}
	
	
	
}


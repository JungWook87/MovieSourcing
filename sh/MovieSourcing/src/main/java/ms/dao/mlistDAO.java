package ms.dao;

import static ms.common.Template.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import ms.vo.movie;

public class mlistDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public mlistDAO() {
		try {
			prop = new Properties();
			
			String filePath = mlistDAO.class.getResource("/ms/sq/mlist=sql.xml").getPath();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

	
	public movie selectAll(Connection conn) throws Exception{
		
		movie m = null;
		
		
		try {
			
			String sql = prop.getProperty("selectAll");
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				m = new movie();
				
				m.setMovieNo(rs.getInt(0));
				m.setMovieTitle(rs.getString(0));
				m.setMovieJanr(rs.getString(0));
				m.setGrade(rs.getString(0));
				m.setNation(rs.getString(0));
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return m;
	}
	
	
	
}

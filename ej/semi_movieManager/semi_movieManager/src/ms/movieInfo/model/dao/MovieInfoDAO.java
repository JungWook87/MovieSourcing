package ms.movieInfo.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import ms.movieInfo.model.vo.MovieInfo;

public class MovieInfoDAO {
		
		private Connection conn; 	 
		private Statement stmt;
		private ResultSet rs;
		private PreparedStatement pstmt;
		
		private String driver = "oracle.jdbc.driver.OracleDriver";
		private String url = "jdbc:oracle:thin:@localhost:1521:XE";
		private String user = "semi_ej";
		private String pw = "semi1234";

	public int insertMovieInfo(MovieInfo movie) {
		
		int result = 0;
		
		try {
	
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
			conn.setAutoCommit(false); 
			

			String sql 
				= "INSERT INTO MOVIE_INFORMATION_TABLE VALUES(SEQ_MOVIE_NO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, movie.getMovieTitle());
			pstmt.setString(2, movie.getMovieEngTitle());
			pstmt.setString(3, movie.getMovieTime());
			pstmt.setString(4, movie.getMovieOpenDate());
			pstmt.setDouble(5, movie.getMovieScore());
			pstmt.setString(6, movie.getMovieNational());
			pstmt.setString(7, movie.getMovieGrade());
			pstmt.setString(8, movie.getMoviePoster());
			pstmt.setString(9, movie.getMoviePreview());
			
			 result = pstmt.executeUpdate(); 
						
			if(result > 0) conn.commit(); 
			else          conn.rollback();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int deleteMovieInfo(String movieTitle) {
		
		int result = 0;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
			conn.setAutoCommit(false);
			
			String sql = "DELETE FROM MOVIE_INFORMATION_TABLE WHERE MOVIE_TITLE = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, movieTitle);

			result = pstmt.executeUpdate();
			
			if(result == 0) conn.rollback();
			else            conn.commit();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public int modifyMovieInfo(MovieInfo movie) {
		
		int result = 0;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
			conn.setAutoCommit(false); // AutoCommit 비활성화
			
			String sql = "UPDATE MOVIE_INFORMATION_TABLE SET "
					+ "MOVIE_TITLE = ?, MOVIE_ENG_TITLE = ?, MOVIE_TIME = ? "
					+ "MOVIE_OPEN_DATE = ?, MOVIE_SCORE = ?, MOVIE_NATIONAL = ? "
					+ "MOVIE_GRADE = ?, MOVIE_POSTER = ?, MOVIE_PREVIEW = ? ";
					
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, movie.getMovieTitle());
			pstmt.setString(2, movie.getMovieEngTitle());
			pstmt.setString(3, movie.getMovieTime());
			pstmt.setString(4, movie.getMovieOpenDate());
			pstmt.setDouble(5, movie.getMovieScore());
			pstmt.setString(6, movie.getMovieNational());
			pstmt.setString(7, movie.getMovieGrade());
			pstmt.setString(8, movie.getMoviePoster());
			pstmt.setString(9, movie.getMoviePreview());
			
			
			result = pstmt.executeUpdate(); 
			
		
			if(result == 0) conn.rollback();
			else            conn.commit();
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}


package ms.simulation.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import ms.common.JDBCTemplate;
import ms.member.model.dao.MemberDAO;
import ms.movie.model.vo.MovieInfo;

import static ms.common.JDBCTemplate.*;


public class SimulationDao {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	


	public SimulationDao() {
		try {
			prop = new Properties();
			
			String filePath = MemberDAO.class.getResource("/ms/sql/simulation-sql.xml").getPath();  
			
			prop.loadFromXML(new FileInputStream(filePath));
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public  List<String> getAllGenres(Connection conn) throws Exception{
		 List<String> genres = new ArrayList<String>();
		
		  
		 
		 try {
		       
		    	String sql = prop.getProperty("genre");
		        stmt = conn.createStatement();
		        rs = stmt.executeQuery(sql);
		        
		        while (rs.next()) {
		            genres.add(rs.getString("GENRE_NO"));
		        }
		 
		    } finally {
		    	close(rs);
				close(stmt);
				
		    }

		    return genres;
		}



	public MovieInfo getRandomMovieByGenre(Connection conn, int selectedGenre) throws SQLException {
	    MovieInfo movie = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        String sql = prop.getProperty("randommovie");
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, selectedGenre);
	        rs = pstmt.executeQuery();
	        if (rs.next()) {
	            movie = new MovieInfo();
	            movie.setMovieNo(rs.getInt("MOVIE_NO"));
	            movie.setMovieTitle(rs.getString("MOVIE_TITLE"));
	            movie.setMovieEngTitle(rs.getString("MOVIE_ENG_TITLE"));
	           // movie.setMovieTime(rs.getString("MOVIE_TIME"));
	            movie.setMovieOpenDate(rs.getString("MOVIE_OPEN_DATE"));
	            //movie.setMovieScore(rs.getDouble("MOVIE_SCORE"));
	            movie.setMovieNational(rs.getString("MOVIE_NATIONAL"));
	            movie.setMovieGrade(rs.getString("MOVIE_GRADE"));
	            movie.setMoviePoster(rs.getString("MOVIE_POSTER"));
	            movie.setMoviePreview(rs.getString("MOVIE_PREVIEW"));
	        }
	    } finally {
	        close(rs);
	        close(pstmt);
	    }

	    return movie;
	}



	public MovieInfo movieInfo(Connection conn, int selectedGenre) throws Exception{
	MovieInfo movieInfo = new MovieInfo();
		
		try {
			
			String sql = prop.getProperty("randommovie");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,selectedGenre );
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				movieInfo.setMovieNo(rs.getInt(1));
				movieInfo.setMovieTitle(rs.getString(2));
				movieInfo.setMovieEngTitle(rs.getString(3));
				movieInfo.setMovieTime(rs.getInt(4));
				movieInfo.setMovieOpenDate(rs.getString(5));
				movieInfo.setMovieScore(rs.getInt(6));
				movieInfo.setMovieNational(rs.getString(7));
				movieInfo.setMovieGrade(rs.getString(8));
				movieInfo.setMoviePoster(rs.getString(9));
				movieInfo.setMoviePreview(rs.getString(10));
		     }
			    } finally {
			        close(rs);
			        close(pstmt);
			    }

			    return movieInfo;
			}
	
	
}
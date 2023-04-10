package ms.movie.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static ms.common.JDBCTemplate.*;

import ms.board.model.dao.BoardDAO;
import static ms.common.JDBCTemplate.*;
import ms.movie.model.vo.MovieInfo;
import ms.movie.model.vo.MoviePeople;

public class MovieInfoDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	
	
	public MovieInfoDAO() {

		try {

			prop = new Properties();
			
			String filePath = BoardDAO.class.getResource("/ms/sql/movie-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/** movieInfo DAO
	 * @param conn
	 * @param movieNo
	 * @return movieInfo
	 */
	public MovieInfo movieInfo(Connection conn, int movieNo) throws Exception{
		
		MovieInfo movieInfo = new MovieInfo();
		
		try {
			
			String sql = prop.getProperty("movieInfo");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, movieNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				movieInfo.setMovieNo(movieNo);
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
			
			sql = prop.getProperty("genreSelect");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, movieNo);
			
			
			List<String> genre = new ArrayList<>();
			while(rs.next()) {
				String genreTemp = rs.getString(1);
				
				genre.add(genreTemp);
			}
			
			movieInfo.setMovieGenre(genre);
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return movieInfo;
	}

	public MoviePeople moviePeople(Connection conn, int movieNo) throws Exception {
		
		MoviePeople moviePeople = new MoviePeople();
		
		try {
			
			String sql = prop.getProperty("pdSelect");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, movieNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				moviePeople.setPdName(rs.getString(1));
				moviePeople.setPdPicture(rs.getString(2));
			}
			
			sql = prop.getProperty("actSelect");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, movieNo);
			
			rs = pstmt.executeQuery();
			
			List<String> act = new ArrayList<>();
			List<String> actPicture = new ArrayList<>();
			
			while(rs.next()) {
				String actor = rs.getString(1);
				String actorPicture = rs.getString(2);
				
				System.out.println("actor : " + actor); 
				
				act.add(actor);
				actPicture.add(actorPicture);
			}
			
			
			moviePeople.setAct1(act.get(0));
			moviePeople.setAct2(act.get(1));
			moviePeople.setAct3(act.get(2));
			moviePeople.setAct4(act.get(3));
			
			moviePeople.setAct1Picture(actPicture.get(0));
			moviePeople.setAct2Picture(actPicture.get(1));
			moviePeople.setAct3Picture(actPicture.get(2));
			moviePeople.setAct4Picture(actPicture.get(3));
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return moviePeople;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

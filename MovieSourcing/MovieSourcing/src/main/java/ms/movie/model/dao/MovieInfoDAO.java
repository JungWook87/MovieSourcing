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
import ms.movie.model.vo.MovieRecommend;
import ms.movie.model.vo.MovieReview;

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
			
			rs = pstmt.executeQuery();
			
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

	/** 리뷰
	 * @param conn
	 * @param movieNo
	 * @return
	 */
	public List<MovieReview> movieReview(Connection conn, int movieNo) throws Exception {
		
		List<MovieReview> movieReview = new ArrayList<>();
		
		MovieReview temp = null;
		
		try {
			
			String sql = prop.getProperty("movieReview");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, movieNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				temp = new MovieReview(movieNo, rs.getInt(2), rs.getString(3), rs.getString(4), 
						rs.getInt(5), rs.getString(6), rs.getString(7));
				
				movieReview.add(temp);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return movieReview;
	}

	public List<MovieRecommend> movieRecommend(Connection conn, List<String> movieRecommendList) throws Exception {
		
		List<MovieRecommend> tempList = new ArrayList<>();
		List<MovieRecommend> movieRecommend = new ArrayList<>();
		
		try {
			
			String sql = "";
			
			int num = movieRecommendList.size();
			
			switch(num) {
				case 1 :  
					sql = prop.getProperty("movieRecommend1");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, movieRecommendList.get(0));
					break;
					
				case 2 :
					sql = prop.getProperty("movieRecommend2");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, movieRecommendList.get(0));
					pstmt.setString(2, movieRecommendList.get(1));
					break;
			
				case 3 : 
					sql = prop.getProperty("movieRecommend3");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, movieRecommendList.get(0));
					pstmt.setString(2, movieRecommendList.get(1));
					pstmt.setString(3, movieRecommendList.get(2));
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MovieRecommend temp = new MovieRecommend();
				
				temp.setMovieNo(rs.getInt(1));
				temp.setMoviePoster(rs.getString(2));
				
				tempList.add(temp);
			}

			
			int[] randomNum = new int[4];
			for(int i = 0; i < 4; i++) {
				int tempNum = (int)(Math.random() * tempList.size());
				
				randomNum[i] = tempNum;
				
				for(int j = 0; j < i; j++) {
					if(randomNum[i] == randomNum[j]) {
						i--;
					}
				}
				
			}
			
			movieRecommend.add(tempList.get(randomNum[0]));
			movieRecommend.add(tempList.get(randomNum[1]));
			movieRecommend.add(tempList.get(randomNum[2]));
			movieRecommend.add(tempList.get(randomNum[3]));
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return movieRecommend;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

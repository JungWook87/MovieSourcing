package ms.movie.model.service;

import static ms.common.JDBCTemplate.*;

import java.sql.Connection;

import ms.movie.model.dao.MovieInfoDAO;
import ms.movie.model.vo.MovieInfo;
import ms.movie.model.vo.MoviePeople;

public class MovieInfoService {

	public MovieInfo movieInfo(int movieNo) {
		
		Connection conn = getConnection();
		
		MovieInfoDAO dao = new MovieInfoDAO();
		
		MovieInfo movieInfo = null;
		
		try {
			
			movieInfo = dao.movieInfo(conn, movieNo);
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(conn);
		}
		
		return movieInfo;
	}

	public MoviePeople MoviePeople(int movieNo) {
		
		Connection conn = getConnection();
		
		MovieInfoDAO dao = new MovieInfoDAO();

		MoviePeople moviePeople = null;
		
		try {
			
			moviePeople = dao.moviePeople(conn, movieNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return moviePeople;
	}

}

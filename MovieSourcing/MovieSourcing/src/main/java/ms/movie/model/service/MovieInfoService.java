package ms.movie.model.service;

import static ms.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import ms.movie.model.dao.MovieInfoDAO;
import ms.movie.model.vo.MovieInfo;
import ms.movie.model.vo.MovieInfoCheck;
import ms.movie.model.vo.MoviePeople;
import ms.movie.model.vo.MovieRecommend;
import ms.movie.model.vo.MovieReview;

/**
 * @author kjo63
 *
 */
public class MovieInfoService {
	
	private MovieInfoDAO dao = new MovieInfoDAO();

	/** 영화정보
	 * @param movieNo
	 * @return
	 */
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

	
	
	/** 감독, 배우
	 * @param movieNo
	 * @return
	 */
	public MoviePeople moviePeople(int movieNo) {
		
		Connection conn = getConnection();
		
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

	
	
	/** 리뷰
	 * @param movieNo
	 * @return
	 */
	public List<MovieReview> movieReview(int movieNo) {
		
		Connection conn = getConnection();
		
		List<MovieReview> movieReview = null;
		
		try {
			
			movieReview = dao.movieReview(conn, movieNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return movieReview;
	}



	public List<MovieRecommend> movieRecommend(List<String> movieRecommendList) {
		
		Connection conn = getConnection();
		
		List<MovieRecommend> movieRecommend = null;
		
		try {
			
			movieRecommend = dao.movieRecommend(conn, movieRecommendList);
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return movieRecommend;
	}



	/** 영화 정보창 회원 셋팅
	 * @param memNo
	 * @param movieNo
	 * @return
	 */
	public MovieInfoCheck movieInfoCheck(int memNo, int movieNo) {
		
		MovieInfoCheck movieInfoCheck = null;
		
		Connection conn = getConnection();
		
		try {
			
			movieInfoCheck = dao.movieInfoCheck(conn, memNo, movieNo);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		return movieInfoCheck;
	}



}

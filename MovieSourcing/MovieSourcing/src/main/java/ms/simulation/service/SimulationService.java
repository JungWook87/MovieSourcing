package ms.simulation.service;

import static ms.common.JDBCTemplate.close;
import static ms.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;
import java.util.Random;

import ms.movie.model.dao.MovieInfoDAO;
import ms.movie.model.vo.MovieInfo;
import ms.movie.model.vo.MovieRecommend;
import ms.simulation.dao.SimulationDao;


public class SimulationService {
	


	
	private SimulationDao dao = new SimulationDao();

	
	

	public List<String> getAllGenres() throws Exception{
		Connection conn = getConnection();
	
		
		List<String> getAllGenres =  dao.getAllGenres(conn);
					
		
			close(conn);
		
		
		return getAllGenres;
	}


//
//
//	public MovieInfo getRandomMovieByGenre(int selectedGenre) throws Exception{
//		Connection conn = getConnection();
//		MovieInfo movies = dao.getRandomMovieByGenre(conn, selectedGenre);
//		  
//		    return movies;
//		    
//	
//	}


//	
//	
//	
//	public List<MovieInfo> getRandomMoviesByGenre(int selectedGenre) throws Exception {
//		Connection conn = getConnection();
//		List<MovieInfo> movieList = dao.getRandomMoviesByGenre(conn,selectedGenre);
//		Collections.shuffle(movieList);
//		return movieList;
//	}
//	
//	
//	
//	
	
	
	
	


	public MovieInfo movieInfo(int selectedGenre) {
	Connection conn = getConnection();
		
	SimulationDao dao = new SimulationDao();
		
		MovieInfo movie = null;
		
		try {
			
			movie = dao.movieInfo(conn, selectedGenre);
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(conn);
		}
		
		return movie;
	}


	
	
	
	
	
	public String getRandomMoviePosterByGenre(int selectedGenre) {
		Connection conn = getConnection();
		String getRandomMoviePosterByGenre = null ;
		SimulationDao dao = new SimulationDao();
		try {
			
			getRandomMoviePosterByGenre  = dao.getRandomMoviePosterByGenre (conn, selectedGenre);
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(conn);
		}
		
		return getRandomMoviePosterByGenre;
	}

}



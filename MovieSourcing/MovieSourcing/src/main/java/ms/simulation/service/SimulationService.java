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




	public MovieInfo getRandomMovieByGenre(int selectedGenre) throws Exception{
		Connection conn = getConnection();
		MovieInfo movies = dao.getRandomMovieByGenre(conn, selectedGenre);
		  
		    return movies;
		    
	
	}




	public MovieInfo movieInfo(int selectedGenre) {
	Connection conn = getConnection();
		
	SimulationDao dao = new SimulationDao();
		
		MovieInfo movieInfo = null;
		
		try {
			
			movieInfo = dao.movieInfo(conn, selectedGenre);
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally{
			close(conn);
		}
		
		return movieInfo;
	}

}



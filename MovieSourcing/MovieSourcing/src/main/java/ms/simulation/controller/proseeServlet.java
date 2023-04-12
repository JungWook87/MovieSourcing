package ms.simulation.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ms.movie.model.vo.MovieInfo;
import ms.simulation.service.SimulationService;

/**
 * Servlet implementation class proseeServlet
 */
@WebServlet("/simulation/proseeServlet")
public class proseeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		   String value = request.getParameter("value");
		   String indexStr = request.getParameter("index");
		    int index = Integer.parseInt(indexStr); 
		   System.out.println("value: " + value + ", index: " + index);

		    
		    SimulationService service = new SimulationService();
			List<String> genres = null;
			List<Integer> genreNumInt = new ArrayList<>();

			try {
				
				
				
			    genres = service.getAllGenres();
			    
			    
			    for (String num : genres) {
			        int intNum = Integer.parseInt(num);
			        genreNumInt.add(intNum);
			    }

			   int selectedGenre = genreNumInt.get(index);
			  System.out.println(selectedGenre);
			   
			   
			   
			   
			   MovieInfo movie = service.movieInfo(selectedGenre);
				Map<String, Object> map = new HashMap<String, Object>();
				
				map.put("movie", movie);
				request.setAttribute("map", map);
				
				
				
				
				
				
			   System.out.println(movie.getMoviePoster());
			   
			   
			   
			
			   
			  
			   
		
		
		
		
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
		
	}
	
	
	





  

}



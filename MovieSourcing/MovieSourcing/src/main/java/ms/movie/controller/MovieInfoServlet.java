package ms.movie.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ms.movie.model.service.MovieInfoService;
import ms.movie.model.vo.MovieInfo;
import ms.movie.model.vo.MoviePeople;

@WebServlet("/MovieSourcing/movieInfo")
public class MovieInfoServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {

			int movieNo = Integer.parseInt(req.getParameter("movieNo"));
			
			MovieInfoService service = new MovieInfoService();
			
			MovieInfo movieInfo = service.movieInfo(movieNo);
			
			MoviePeople moviePeople  = service.MoviePeople(movieNo);
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("movieInfo", movieInfo);
			map.put("moviePeople", moviePeople);
			
			req.setAttribute("map", map);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/movie/movieInfo.jsp");
			
			dispatcher.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}

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

import com.google.gson.Gson;

import ms.movie.model.vo.MovieInfo;
import ms.simulation.service.SimulationService;

/**
 * Servlet implementation class proseeServlet
 */
@WebServlet("/simulation/proseeServlet")
public class proseeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("value");
		   //시뮬레이션 값 
		   
		   int index = Integer.parseInt(request.getParameter("index"));
		   //String indexStr = request.getParameter("index");
		   //시뮬레이션 인덱스 
		   // int index = Integer.parseInt(indexStr); 
		    //인덱스를 스트링으로 가져왔기때문에 인트로 바꿈 
//		   System.out.println("value: " + value + ", index: " + index);
//		   //
		    
		    SimulationService service = new SimulationService();
		    
			List<String> genres = null;
			//장르번호랑 인덱스랑 매칭할거라 리스트로 변수선언해주고 
			List<Integer> genreNumInt = new ArrayList<>();
				//장르번호가 스트링이기때문에 인티져로 바꿀 새로운 리스트 선언 
			try {
//				
//				
//				
			    genres = service.getAllGenres();
			    //장르번호를 가져와서 넣고 
			    
			    
			    for (String num : genres) {
			        int intNum = Integer.parseInt(num);
			        genreNumInt.add(intNum);
			        //인트로 바꿔서 인트로 선언된 리스트에 다시 넣음 
			    }

			   int selectedGenre = genreNumInt.get(index);
//			  System.out.println(selectedGenre);
//			  //jsp에서 가져온 top3순위중의 한가지 index를 받아서 장르번호와 매칭해서 해당되는 장르번호를 출력해줌 
//			  //ex ) jsp에서 가져온 인덱스는 1, db에 있는 장르는 2 와 매칭. 왜냐면 인덱스는 0부터 시작하니까. 
//			   
//			   
//			   
			   
			   MovieInfo movie = service.movieInfo(selectedGenre);
			  
//			
//				Map<String, Object> map = new HashMap<String, Object>();
//		//맵으로 넣어서 jsp 에 전달 		
//				//map.put("movie", movie);
				request.setAttribute("movie", movie);
//				System.out.println(movie.getMoviePoster());
//				
//			
//				
//				 String posterUrl =movie.getMoviePoster();
//			 
//			    // JSP로 forward
//			    RequestDispatcher dispatcher = request.getRequestDispatcher("simulEnter");
//			    dispatcher.forward(request, response);
//			    
//			    
//			    response.setContentType("text/plain");
//		        response.setCharacterEncoding("UTF-8");
//		        PrintWriter out = response.getWriter();
//		        out.write("testMsg");
//		        out.close();
				response.setContentType("application/x-json; charset=utf-8");
				String gson = new Gson().toJson(movie);
				response.getWriter().print(gson);
				System.out.println(gson);
//				
				
//		
//		
		   
		 
			   String posterUrl = service.getRandomMoviePosterByGenre(selectedGenre);
			   
			 
			   // 영화 포스터 URL을 request의 attribute에 저장해서 jsp 파일에서 사용할 수 있도록 함
			

			    // jsp 파일로 forward
			   // RequestDispatcher rd = request.getRequestDispatcher("/simulIndex.jsp");
			   // rd.forward(request, response);
			    
			    //request.getRequestDispatcher("/WEB-INF/views/simulation/simulIndex.jsp").forward(request, response);
			   
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
	
	}

	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		   String value = request.getParameter("value");
		   //시뮬레이션 값 
		   
		   int index = Integer.parseInt(request.getParameter("index"));
		   //String indexStr = request.getParameter("index");
		   //시뮬레이션 인덱스 
		   // int index = Integer.parseInt(indexStr); 
		    //인덱스를 스트링으로 가져왔기때문에 인트로 바꿈 
//		   System.out.println("value: " + value + ", index: " + index);
//		   //
		    
		    SimulationService service = new SimulationService();
		    
			List<String> genres = null;
			//장르번호랑 인덱스랑 매칭할거라 리스트로 변수선언해주고 
			List<Integer> genreNumInt = new ArrayList<>();
				//장르번호가 스트링이기때문에 인티져로 바꿀 새로운 리스트 선언 
			try {
//				
//				
//				
			    genres = service.getAllGenres();
			    //장르번호를 가져와서 넣고 
			    
			    
			    for (String num : genres) {
			        int intNum = Integer.parseInt(num);
			        genreNumInt.add(intNum);
			        //인트로 바꿔서 인트로 선언된 리스트에 다시 넣음 
			    }

			   int selectedGenre = genreNumInt.get(index);
//			  System.out.println(selectedGenre);
//			  //jsp에서 가져온 top3순위중의 한가지 index를 받아서 장르번호와 매칭해서 해당되는 장르번호를 출력해줌 
//			  //ex ) jsp에서 가져온 인덱스는 1, db에 있는 장르는 2 와 매칭. 왜냐면 인덱스는 0부터 시작하니까. 
//			   
//			   
//			   
			   
			   MovieInfo movie = service.movieInfo(selectedGenre);
			  
//			
//				Map<String, Object> map = new HashMap<String, Object>();
//		//맵으로 넣어서 jsp 에 전달 		
//				//map.put("movie", movie);
				request.setAttribute("movie", movie);
//				System.out.println(movie.getMoviePoster());
//				
//			
//				
//				 String posterUrl =movie.getMoviePoster();
//			 
//			    // JSP로 forward
			   // RequestDispatcher dispatcher = request.getRequestDispatcher("simulEnter");
			   // dispatcher.forward(request, response);
			    
			    
			    response.setContentType("text/plain");
		        response.setCharacterEncoding("UTF-8");
		        PrintWriter out = response.getWriter();
		        out.println("testMsg");
		        out.close();
		System.out.println("out -------");
//		
//		
//		
		   
		 
			   String posterUrl = service.getRandomMoviePosterByGenre(selectedGenre);
			   
			 
			   // 영화 포스터 URL을 request의 attribute에 저장해서 jsp 파일에서 사용할 수 있도록 함
			

			    // jsp 파일로 forward
			   // RequestDispatcher rd = request.getRequestDispatcher("/simulIndex.jsp");
			   // rd.forward(request, response);
			    
			    //request.getRequestDispatcher("/WEB-INF/views/simulation/simulIndex.jsp").forward(request, response);
			   
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
		
	}
	
	
	





  

}



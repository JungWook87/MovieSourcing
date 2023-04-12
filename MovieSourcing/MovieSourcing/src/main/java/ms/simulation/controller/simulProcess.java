package ms.simulation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ms.list.model.vo.movie;
import ms.movie.model.vo.MovieInfo;

import ms.simulation.service.SimulationService;

/**
 * Servlet implementation class simulProcess
 */
@WebServlet("/simulation/simulProcess")
public class simulProcess extends HttpServlet {

       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] selectArrays = request.getParameterValues("select[]");
		System.out.println("배열에 들어있는값 : " + Arrays.toString(selectArrays));

		SimulationService service = new SimulationService();
		List<String> genres = null;

		try {
		    genres = service.getAllGenres();
		    int[] intSelectArr = new int[selectArrays.length];
		    for (int i = 0; i < selectArrays.length; i++) {
		        intSelectArr[i] = Integer.parseInt(selectArrays[i]);
		    }

		    int[] selectArr = new int[intSelectArr.length];
		    for (int i = 1; i <= selectArrays.length; i++) { // selectArrays.length로 변경
		        String genre = genres.get(i-1);
		        int index = i;
		        selectArr[index-1] = intSelectArr[i-1];
		        System.out.println("Genre: " + genre + ", Index: " + index + ", Select: " + selectArr[index-1]);
		    }

		    Map<String, Integer> indexMap = new HashMap<>();
		    for (int i = 0; i < genres.size(); i++) {
		        indexMap.put(genres.get(i), i+1);
		    }

		    // selectArr 배열을 내림차순으로 정렬
		    int[] sortedArr = Arrays.stream(selectArr)
		                             .boxed()
		                             .sorted(Collections.reverseOrder())
		                             .mapToInt(Integer::intValue)
		                             .toArray();

		    // 상위 3개의 인덱스를 찾아 장르 출력
		    for (int i = 0; i < 3; i++) {
		        int index = Arrays.binarySearch(selectArr, sortedArr[i]);
		        System.out.println("Genre: " + indexMap.get(index) + ", Select: " + sortedArr[i]);
		    }
		    
		    
		 // 1. AJAX로 전달된 select 배열 값을 서블릿에서 받아옴
	 
//	  
//		String[] selectArrays = request.getParameterValues("select[]");
//		   System.out.println("배열에 들어있는값 : " + Arrays.toString(selectArrays));
//		   
//		  
//		   SimulationService service = new SimulationService();
//		   List<String> genres = null;
//		 
//		   
//		   
//	        try {
//	        	  genres = service.getAllGenres();
//	        	int[] intSelectArr = new int[selectArrays.length];
//	        	for (int i = 0; i < selectArrays.length; i++) {
//	        		intSelectArr[i] = Integer.parseInt(selectArrays[i]);
//	        	}
//	        	
//	        	
//	        	
//       	  
//	        	  int[] selectArr = new int[intSelectArr.length];
//	        	  for (int i = 1; i <= genres.size(); i++) {
//	        	      String genre = genres.get(i-1);
//	        	      int index = i;
//	        	      selectArr[index-1] = intSelectArr[i-1];
//	        	      System.out.println("Genre: " + genre + ", Index: " + index + ", Select: " + selectArr[index-1]);
//	        	  }
//	        	  
//	        	 
//	        	  
//	        	  Map<String, Integer> indexMap = new HashMap<>();
//	        	  for (int i = 0; i < genres.size(); i++) {
//	        		  indexMap.put(genres.get(i), i+1);
//	        	  }
//	        	  
//	        	  // selectArr 배열을 내림차순으로 정렬
//	        	  int[] sortedArr = Arrays.stream(selectArr)
//	        	                           .boxed()
//	        	                           .sorted(Collections.reverseOrder())
//	        	                           .mapToInt(Integer::intValue)
//	        	                           .toArray();
//
//	        	  // 상위 3개의 인덱스를 찾아 장르 출력
//	        	  for (int i = 0; i < 3; i++) {
//	        	      int index = Arrays.binarySearch(selectArr, sortedArr[i]);
//	        	      System.out.println("Genre: " + indexMap.get(index) + ", Select: " + sortedArr[i]);
//	        	  }
//	              
	              
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
			
		
	}


}
		
}


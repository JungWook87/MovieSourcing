package ms.community.board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ms.community.board.model.service.BoardService;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet{
	
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// 기본 페이지 값
			int cp = 1;
			
			// 페이지 클릭하여 페이지 값이 있을 때
			if(req.getParameter("cp") != null) {
				cp = Integer.parseInt(req.getParameter("cp"));
			}
			
			// 서비스 호출
			BoardService service = new BoardService();
			
			// boardList.jsp에 보낼 Map 객체 생성
			// 키는 String 값은 객체형태(여기에 게시번호, 게시글, 작성자 등등)
			Map<String, Object> map = null;
			
			if(req.getParameter("key") == null) { // key는 검색창에서 제목, 내용, 제목+내용, 작성자의 카테고리에 관련된 값
				map = service.searchBoadList(cp);
			} else { // 검색 값이 있으면 
				String key = req.getParameter("key");	//	검색 카테고리(제목, 내용, 등등)
				String query = req.getParameter("query"); // 검색 내용, 검색 값
				
				map = service.searchBoadList(cp, key, query);
			}
			
			req.setAttribute("map", map);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/boardList.jsp");
			
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

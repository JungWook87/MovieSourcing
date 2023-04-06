package ms.community.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ms.community.board.model.service.BoardService;
import ms.community.board.model.vo.BoardDetail;


@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet {
	
	// 나중에 필터 걸어서 로그인이 안되어 있으면 메인으로 이동하게 설정해야 함(로그인필터)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String mode = req.getParameter("mode");
		if(mode.equals("update")) {
			try {
				int comNo = Integer.parseInt(req.getParameter("comNo"));
				
				BoardService service = new BoardService();
				
				BoardDetail boardDetail;
				
				boardDetail = service.selectBoardDetail(comNo);

				req.setAttribute("boardDetail", boardDetail);
				
				String path = "/WEB-INF/views/board/boardWrite.jsp";
				
				RequestDispatcher dispatcher = req.getRequestDispatcher(path);
				
				dispatcher.forward(req, resp);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
	
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("포스트로 들어오니??");
		
		int comNo = Integer.parseInt(req.getParameter("comNo"));
		String comTitle = req.getParameter("comTitle");
		String comContent = req.getParameter("comContent");
		
		System.out.println(comNo);
		System.out.println(comTitle);
		System.out.println(comContent);
	}
}

package ms.community.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ms.community.board.model.service.BoardService;
import ms.community.board.model.service.ReplyService;
import ms.community.board.model.vo.BoardDetail;
import ms.community.board.model.vo.Reply;

@WebServlet("/board/reply")
public class ReplyController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int comNo = Integer.parseInt(req.getParameter("comNo"));
		String replyContent = req.getParameter("replyInput");
		String memNic = "tester";
		int memNo = 1;
		
		Reply reply = new Reply();
		
		System.out.println("replyContent : " + replyContent);
		System.out.println("comNo : " + comNo);
		
		reply.setComNo(comNo);
		reply.setMemNic(memNic);
		reply.setMemNo(memNo);
		reply.setReplyContent(replyContent);
		
		ReplyService replyService = new ReplyService();
		
		String msg = replyService.insertReply(reply);
		
//		BoardService service = new BoardService();
//		
//		BoardDetail boardDetail = service.selectBoardDetail(comNo);
//		
//		req.setAttribute("boardDetail", boardDetail);
//		
//		String path = "/WEB-INF/views/board/boardDetail.jsp";
//		
//		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
//		
//		dispatcher.forward(req, resp);
		
		
	}
}

package ms.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ms.member.model.service.MemberService;
import ms.member.model.vo.Member;

@WebServlet("/member/signUp2")
public class SignUp2Servlet extends HttpServlet{

	// GET 방식 요청 시 JSP로 바로 응답할 수 있도록 요청 위임
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String path = "/WEB-INF/member/signUp2.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	

	// POST 방식 요청 시 회원가입 서비스 수행
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 파라미터를 모두 변수에 저장
		String memberId = req.getParameter("id");
		String memberPw = req.getParameter("pw1");
		String memberNick = req.getParameter("nickname");
		String memberGender = req.getParameter("gender");
		
		
		String year =  req.getParameter("yy");
		String month =  req.getParameter("mm");
		
		String memberBirth = year + "-" + month;
		 
		
		
		HttpSession session = req.getSession();
		
	
		session.setAttribute("memberId",memberId);
		session.setAttribute("memberPw",memberPw);
		session.setAttribute("memberNick",memberNick);
		session.setAttribute("memberGender",memberGender);
		session.setAttribute("memberBirth",memberBirth);
	
		String path = "/WEB-INF/member/signUp3.jsp";
		req.getRequestDispatcher(path).forward(req, resp);

	}
}
	

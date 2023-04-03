package edu.kh.community.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.community.member.model.service.MemberService;
import edu.kh.community.member.model.vo.Member;

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
		 
		
		
		
		
		
		
			
			// String.join("구분자", 배열)
			// -> 배열 요소를 하나의 문자열로 반환
			//    요소 사이에 "구분자" 추가
		
		
		
		// 파라미터를 하나의 Member 객체에 저장
//		Member mem = new Member();
//	
//		
//		mem.setMemberId(memberId);
//		mem.setMemberPw(memberPw);
//		mem.setMemberNick(memberNick);
//		mem.setMemberGender(memberGender);
//		mem.setMemberBirth(memberBirth);

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
	


package edu.kh.community.member.controller;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginPageEnterServlet
 */
@WebServlet("/member/loginPgEnter")
public class LoginPageEnterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();

		// 3. 로그인 되어있는지 확인
		if(  session.getAttribute("loginMember") != null ) { // 로그인이 되어있는 경우
			
			String path = "/WEB-INF/member/mypage.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		
		} else { // 로그인이 되어있지 않은 경우
			
			String path = "/member/login";
			req.getRequestDispatcher(path).forward(req, resp);
		
		}
		
		
	}
	
	

}

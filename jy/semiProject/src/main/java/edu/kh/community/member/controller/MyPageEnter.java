package edu.kh.community.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 마이페이지 들어가는 서블렛
 */
@WebServlet("/member/MyPageEnter")
public class MyPageEnter extends HttpServlet {

       


	@Override
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  this.doPost(request, response);
		
		
		}
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
	
			request.getRequestDispatcher("/WEB-INF/member/mypage.jsp").forward(request, response);
}
}
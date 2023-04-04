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
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  this.doPost(request, response);
		
		
		}
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
			
			
			
			request.getRequestDispatcher("/WEB-INF/member/login.jsp").forward(request, response);
}
}
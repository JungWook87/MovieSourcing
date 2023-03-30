package edu.kh.community.member.controller;

import java.io.IOException;

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
public class loginPageEnterServlet extends HttpServlet {

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			
			String path = "/WEB-INF/member/마이페이지.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
	}
}

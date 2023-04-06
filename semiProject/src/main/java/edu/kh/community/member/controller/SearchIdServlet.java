package edu.kh.community.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.community.member.model.vo.Member;

/**
 * Servlet implementation class SerachIdServlet
 */
@WebServlet("/member/searchId")
public class SearchIdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			
			request.getRequestDispatcher("/WEB-INF/member/searchId.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
				HttpSession session = request.getSession();
				String memberEmail = request.getParameter("email");
				
				
				// ** 로그인 회원 번호 얻어오기 **
				Member loginMember = (Member)( session.getAttribute("loginMember") ) ;
				
				int memberNo = loginMember.getMemberNo(); // 로그인 회원 번호
				
				
		
	}

}

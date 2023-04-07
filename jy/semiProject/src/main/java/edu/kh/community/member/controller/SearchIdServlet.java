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

/**
 * Servlet implementation class SerachIdServlet
 */
@WebServlet("/member/searchId")
public class SearchIdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			
			request.getRequestDispatcher("/WEB-INF/member/searchId.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberEmail = request.getParameter("eamil");
		HttpSession session = request.getSession();
		
		
		try {
			MemberService service = new MemberService();
	
		
			Member member = service.searchId(memberEmail);
			
			if(member == null) {
				System.out.println("없음");
			
			}else {
				System.out.println("있음");
				
				
			}
	
	
	
	
	}catch(Exception e) {
		e.printStackTrace();
	}
		
	}
}
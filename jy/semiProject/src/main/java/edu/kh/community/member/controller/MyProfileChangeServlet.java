package edu.kh.community.member.controller;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.community.member.model.service.MemberService;
import edu.kh.community.member.model.vo.Member;
import oracle.net.aso.c;

/**
 * 패스워드 변경 서블렛
 *
 */
@WebServlet("/member/myPagechangeEnter")
public class MyProfileChangeServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/member/myProfileChangePg.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	
	
	
	
	
	// post방식 요청 : 프로필 수정 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		HttpSession session = req.getSession();
	
		String memberImg = req.getParameter("profileimg");		
		String memberNick = req.getParameter("nicknameArea");
		String memberIntro = req.getParameter("introduceArea");
	
		// ** 로그인 회원 번호 얻어오기 **
		Member loginMember = (Member)( session.getAttribute("loginMember") ) ;
		
		int memberNo = loginMember.getMemberNo(); // 로그인 회원 번호
		
	
		MemberService service = new MemberService();
		Member mem = new Member();
		req.setAttribute("loginMember", mem); 
		
		
		
		
			try {
			
				mem.setMemberNo(memberNo);
				mem.setMemberImg(memberImg);
				mem.setMemberNick(memberNick);
				mem.setMemberIntro(memberIntro);
			
				
				session.setAttribute("loginMember", mem);

				int result = service.changeElse(mem);
				System.out.println();
				
				String path = null; 
				
				if(result > 0) { 
				
					session.setAttribute("message", "변경 성공!" );
					
				
					path = "MyPageEnter";
					
					session.getAttribute("loginMember");
				
					
					
					
				} else {
					session.setAttribute("message", "변경 실패 " );
					
					
					path ="myPagechangeEnter";
					
					
					
				}
				
				resp.sendRedirect(path);
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			
			
			
			
			
	
	}
	
	
	
	
	
	
	
}

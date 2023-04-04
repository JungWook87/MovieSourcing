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

@WebServlet("/member/myPagechangeEnter")
public class MyPageChangePwServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/member/myProfileChangePg.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	
	// post방식 요청 : 비밀번호 변경
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		HttpSession session = req.getSession();
	
	
		String memberPw = 	req.getParameter("currentPw");
		String newPw1 =  req.getParameter("newPw1");
		String memberImg = req.getParameter("profileimgg");		
		String memberNick = req.getParameter("nicknameArea");
		String memberIntro = req.getParameter("introduceArea");
	
		
		

		
		// ** 로그인 회원 번호 얻어오기 **
Member loginMember = (Member)( session.getAttribute("loginMember") ) ;
		
		int memberNo = loginMember.getMemberNo(); // 로그인 회원 번호
		String memberEmail = loginMember.getMemberEmail();
	
		
		// ** 세션에서 로그인한 회원 정보 얻어오기 **
	
		
		// 얕은 복사(세션에 있는 회원 정보 객체 주소)
		// -> loginMember를 수정하면 세션에 저장된 내용이 수정된다!
		MemberService service = new MemberService();
	Member mem = new Member();
		

		
		if(memberPw.equals("")&&newPw1.equals("")) {
		
			
		
			try {
			
				mem.setMemberNo(memberNo);
				mem.setMemberImg(memberImg);
				mem.setMemberNick(memberNick);
				mem.setMemberIntro(memberIntro);
				mem.setMemberEmail(memberNick);
				mem.setMemberEmail(memberEmail);
		

				
				session.setAttribute("loginMember", mem);

				int result = service.changeElse(mem);
				
				
				
				String path = null; // 리다이렉트 주소
				
				if(result > 0) { // 성공
					// session scope ->   key="message",  vlaue="비밀번호 변경 성공!"    세팅
					// path = "내 정보 페이지 주소"
					session.setAttribute("message", "변경 성공!" );
					
					//path = req.getContextPath() + "/member/mypage/info";
					path = "MyPageEnter";
					
					session.getAttribute("loginMember");
					System.out.println(loginMember.getMemberEmail());
					
				} else { // 실패
					// session scope ->   key="message",  vlaue="현재 비밀번호가 일치하지 않습니다"  세팅
					// path = "비밀번호 변경 페이지 주소"
					session.setAttribute("message", "변경 실패 " );
					
					//path = req.getContextPath() + "/member/mypage/changePw";
					path ="myPagechangeEnter";
					
					
					
				}
				
				resp.sendRedirect(path);
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			
			
			
			
			
			
			
		}else {
		
			
			
			
			
			try {
				mem.setMemberNo(memberNo);
				mem.setMemberImg(memberImg);
				mem.setMemberNick(memberNick);
				mem.setMemberIntro(memberIntro);
				mem.setMemberPw(memberPw);
				mem.setMemberEmail(memberEmail);
				
				
				
				session.setAttribute("loginMember", mem);
//
//				int result = service.changePwElse(memberPw,newPw1,memberImg, memberNick,memberIntro, memberNo);
				int result = service.changePwElse(newPw1,mem);
				
				
				String path = null; // 리다이렉트 주소
				
				if(result > 0) { // 성공
					
					session.setAttribute("message", "비밀번호 외 모두 변경 성공!" );
					
						path = "MyPageEnter";
					
					session.getAttribute("loginMember");
				
				} else { // 실패
					
					session.setAttribute("message", "현재 비밀번호가 일치하지 않습니다" );
					
					
					path ="myPagechangeEnter";
					session.getAttribute("loginMember");
					
				}
				
				resp.sendRedirect(path);
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			
			
			
			
		}
		
		

	
	}
	
	
	
	
	
	
	
}

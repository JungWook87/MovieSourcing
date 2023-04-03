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
import oracle.net.aso.c;

@WebServlet("/member/changePw")
public class MyPageChangePwServlet extends HttpServlet{

	
	// post방식 요청 : 비밀번호 변경
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		HttpSession session = req.getSession();
		String memberPw ;
	
		memberPw = 	req.getParameter("currentPw");
		String newPw1 =  req.getParameter("newPw1");
		String newPw2 = req.getParameter("newPw2");
		
		
		
		//  만약 현재비밀번호,변경한 비밀번호 1 2 가 비어있으면 
	//걍 변경된 애들만 가져와도됨
		if(memberPw==null&&newPw1==null&&newPw2==null) {
			String memberImg = req.getParameter("profileimgg");		
			String memberNick = req.getParameter("nicknameArea");
			String memberIntro = req.getParameter("introduceArea");
			
			
		}else {
			//  만약 현재비밀번호,변경한 비밀번호 1 2 가 비어있지않으면 
			//현재비밀번호와 변경할 비밀번호 12를 가져와야함. 
			String memberImg = req.getParameter("profileimgg");
			String memberNick = req.getParameter("nicknameArea");
			String memberIntro = req.getParameter("introduceArea");
			
			
			
		}
		
		
		// ** 로그인 회원 번호 얻어오기 **
		
		
		// 로그인 정보 얻어오기
		Member loginMember = (Member)( session.getAttribute("loginMember") ) ;
		
		int memberNo = loginMember.getMemberNo(); // 로그인 회원 번호
		
		System.out.println(memberPw);
		System.out.println(newPw1);
		System.out.println(memberNo);
		
		
		// ** Service로 전달할 값이 많은데 VO로 해결할 수 없는 경우 **
		// 1. 매개변수로 하나하나 따로 전달한다.
		//   -> 최대 4개를 넘지 않는 것을 권장
		
		// 2. Map 사용하기 (권장)
		
		// 3. VO 새로 만들기(1회성으로 사용하면 비효율적)
		
		try {
			MemberService service = new MemberService();
			
			int result = service.changePw(memberPw, newPw, memberNo);
			
			
			String path = null; // 리다이렉트 주소
			
			if(result > 0) { // 성공
				// session scope ->   key="message",  vlaue="비밀번호 변경 성공!"    세팅
				// path = "내 정보 페이지 주소"
				session.setAttribute("message", "비밀번호 변경 성공!" );
				
				//path = req.getContextPath() + "/member/mypage/info";
				path = "info";
				
			} else { // 실패
				// session scope ->   key="message",  vlaue="현재 비밀번호가 일치하지 않습니다"  세팅
				// path = "비밀번호 변경 페이지 주소"
				session.setAttribute("message", "현재 비밀번호가 일치하지 않습니다" );
				
				//path = req.getContextPath() + "/member/mypage/changePw";
				path ="changePw";
			}
			
			resp.sendRedirect(path);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
	
	
	
	
	
	
}

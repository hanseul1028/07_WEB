package com.kh.mfw.member.controller;

import java.io.IOException;
import java.lang.reflect.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mfw.member.model.dto.MemberDTO;
import com.kh.mfw.member.model.service.MemberService;

@WebServlet("/sign-up")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignUpController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) 인코딩 설정		
		request.setCharacterEncoding("UTF-8");
		
		// 컨트롤러가 하는 일 : 요청 처리
		// 요청 처리 -> 사용자가 입력한 값들을 멀리 있는 DB서버의 KH_MEMBER테이블에 한 행 INSERT
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		String email = request.getParameter("email");
		
		MemberDTO member = new MemberDTO(memberId, memberPw, memberName, email, null);
		// 여기까치가 요청처리를 위해서 필요한 값들을 처리하는 과정임
		
		int result = 0;
		// new MemberService().signUp(member);
		
		String path = request.getContextPath();
		/*if(result != 0) {
			// 실패했을 경우 -> 회원가입페이지로 이동
			// 포워딩 방식 -> 유지보수가 힘듦
			
			//response.sendRedirect(request.getContextPath() + "/join");
			// -> 유지보수가 용이해짐
			
			path = request.getContextPath() + "/join";
		}else {
			// 성공했을 경우 -> 웰컴페이지로 이동
			//response.sendRedirect(request.getContextPath());
			
			path = request.getContextPath();
		}
		
		response.sendRedirect(path);
		// 변수를 사용해서 중복을 제거한 것
		*/		
		
		response.sendRedirect(result != 0 ? path + "/join" : path);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

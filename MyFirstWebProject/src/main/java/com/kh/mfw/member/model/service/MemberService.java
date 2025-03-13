package com.kh.mfw.member.model.service;

import com.kh.mfw.member.model.dao.MemberDAO;
import com.kh.mfw.member.model.dto.MemberDTO;

public class MemberService {

	public MemberDTO login(MemberDTO member) {
		
		/*
		 * 로그인을 하는 건데 로그인은
		 * DB에 가서 SELECT절에다가 사용자가 입력항 아이디 값과 비밀번호값을 조건절에 사용해서 
		 * 조회를 하는 촐자를 
		 * 
		 * ID가 틀리거나 PW가 틀려서 로그인에 실패할 수 있는 가능성이 있음
		 * 
		 * => 서비스단에서 유효성검사하기 (Validation)
		 */
		MemberDTO loginMember = new MemberDAO().login(member);
		return loginMember;
		
	}
	
	public int signUp(MemberDTO member) {
		
		int result = new MemberDAO().checkId(member.getMemberId());
		
		if(result > 0 ) {
			return result;
		}
		
		new MemberDAO().signUp(member);
		return result;
	}
	
}

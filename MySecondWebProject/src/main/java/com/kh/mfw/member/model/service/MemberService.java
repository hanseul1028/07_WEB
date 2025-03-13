package com.kh.mfw.member.model.service;

import org.apache.ibatis.session.SqlSession;

import static com.kh.mfw.common.Template.getSqlSession;
// SqlSession sqlSession = Template.getSqlSession();
// 에 Template. 부분 안쓰는 방법
import com.kh.mfw.member.model.dto.MemberDTO;

public class MemberService {
	
	public MemberDTO login(MemberDTO member) {
		
		// JDBCUtill 클래스로부터 
		// static Method 로 구현해놓은
		// getConnection 메서드를 호출하여
		// Connection 객체를 반환받았었음
		
		// . : 참조연산자 / 직접접근연산자
		SqlSession sqlSession = getSqlSession();
		
		
		
		return null;
	}

}

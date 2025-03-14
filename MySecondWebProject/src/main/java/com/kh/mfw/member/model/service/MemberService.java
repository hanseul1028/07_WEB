package com.kh.mfw.member.model.service;

import org.apache.ibatis.session.SqlSession;

import static com.kh.mfw.common.Template.getSqlSession;

import com.kh.mfw.member.model.dao.MemberDAO;
// SqlSession sqlSession = Template.getSqlSession();
// 에 Template. 부분 안쓰는 방법
import com.kh.mfw.member.model.dto.MemberDTO;

public class MemberService {
	
	public MemberDTO login(MemberDTO member) {
		
		// JDBCUtill 클래스로부터 
		// static Method 로 구현해놓은
		// getConnection 메서드를 호출하여
		// Connection 객체를 반환받았었음
		
		// . : 참조연산자 / 직접 접근 연산자
		SqlSession sqlSession = getSqlSession();
		
		// 유효성 검증 => 패스 (원래 해야됨)
		MemberDTO loginMember = new MemberDAO().login(sqlSession, member);
		
		sqlSession.close();
		
		return loginMember;
	}
	
	public int signUp(MemberDTO member) {
		
		// 3차 유효성 검증 Java
		// 4차 데이터무결성을 위한 제약조건(DBMS)
		// 아이디 중복 검사
		SqlSession sqlSession = getSqlSession();
		
		// boolean result = new MemberDAO().checkId(sqlSession, member.getMemberId());
		if(new MemberDAO().checkId(sqlSession, member.getMemberId())) {
			sqlSession.close();
			return 0;
		}
		
		int result = new MemberDAO().signUp(sqlSession, member);
		
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

}










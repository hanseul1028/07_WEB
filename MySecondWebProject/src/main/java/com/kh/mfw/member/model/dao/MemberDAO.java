package com.kh.mfw.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mfw.member.model.dto.MemberDTO;

public class MemberDAO {

	public MemberDTO login(SqlSession sqlSession, MemberDTO member) {
		
		// 조회결과가 한 행 : selectOne
		// 조회결과가 여러 행 : selectList
		
		//SqlSession이 제공하는 메소드를 통해 SQL문을 찾아서 실행하고
		// 결과를 받을 수 있음
		// sqlSession.sql문 종류에 맞는 메소드("mapper파일의 namespace.SQL문의 id속성값")
		MemberDTO loginMember = sqlSession.selectOne("memberMapper.login", member);
		System.out.println(loginMember);
		
		return null;
		
	}
}
















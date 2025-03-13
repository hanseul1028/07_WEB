package com.kh.mfw.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {

	// MyBatis Framework Version 
	
	// MyBatis에서는 직접적으로 Connection 객체를 사용하지 않음
	// 대신 사용하는게 SqlSession 객체
	
	// SqlSession 를 만들기 위해서
	// SqlSessionFactory를 만들고 애를 만들기 위해서 
	// SqlSessionFactoryBuilder를 만들어야 함
	
	public static SqlSession getSqlSession() {
		
		SqlSession sqlSession = null;
		try {
			InputStream stream = Resources.getResourceAsStream("/mybatis-config.xml");
			
			// 1. SqlSessionFactoryBuilder 객체 생성
			// 	  그냥 생성자 호출하면 됨
			// 2. SqlSessionFactory 객체 생성
			// 	  build(입력스트림) 스트림으로부터 환경설정 파일의 값을 읽어오면서
			// 	  SqlSessionFactory 객체 생성
			// 3. SqlSession 객체 생성
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSession;
	}
	
	
	
	
}

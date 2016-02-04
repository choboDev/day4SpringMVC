package com.multicampus.biz.user;

import java.util.List;

public interface UserService {

	// CRUD 기능 메소드 구현
	// 회원 가입
	void insertUser(UserVO vo);

	// 회원 상세 조회
	UserVO getUser(UserVO vo);

	// 회원 목록 조회
	List<UserVO> getUserList();

}
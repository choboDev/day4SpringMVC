package com.multicampus.biz.user;

import java.util.List;

public interface UserService {

	// CRUD ��� �޼ҵ� ����
	// ȸ�� ����
	void insertUser(UserVO vo);

	// ȸ�� �� ��ȸ
	UserVO getUser(UserVO vo);

	// ȸ�� ��� ��ȸ
	List<UserVO> getUserList();

}
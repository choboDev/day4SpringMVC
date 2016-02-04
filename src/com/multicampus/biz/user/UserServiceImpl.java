package com.multicampus.biz.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("userService")
public class UserServiceImpl implements UserService {
	//@Autowired
	UserDAO userDAO;
	
	//생성자 인젝션
	//public UserServiceImpl(UserDAO userDAO) {
	//	this.userDAO = userDAO;
	//}

	//세터 인젝션
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void insertUser(UserVO vo) {
		userDAO.insertUser(vo);
	}

	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

	public List<UserVO> getUserList() {
		return userDAO.getUserList();
	}

}

package com.multicampus.biz.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO userDAO;
	
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

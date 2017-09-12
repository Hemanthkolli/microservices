package com.ecm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl {
	@Autowired
	 private UserRepository repository;
	public String validateUser(String userName, String password) {
		User res = repository.findByUserNameAndPassword(userName, password);

		if (res == null) {
			return "invalid";
		}
		return "success";
	}

}

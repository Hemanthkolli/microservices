package com.ecm.api;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {
	public String register(Customer cust);
	public String validateUser(String email, String password);
	
}

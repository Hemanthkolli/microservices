package com.ecm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private CustomerRepository customerRepository;
 @Autowired
 private UserRepository userRepository;
	@Override
	public String register(Customer cust) {
try{
		Customer customer = new Customer();
		customer.setAddress(cust.getAddress());
		customer.setCompany(cust.getCompany());
		customer.setEmail(cust.getEmail());
		customer.setFullName(cust.getFullName());
		customer.setPassword(cust.getPassword());
		customer.setConfirmPassword(cust.getConfirmPassword());
		customer.setRegion(cust.getRegion());
		customerRepository.save(cust);
		
		User user=new User();
		user.setUserName(cust.getEmail());
		user.setPassword(cust.getPassword());
		userRepository.save(user);

		return "success";
   }catch(Exception e){
	return "error";
}
	}

	@Override
	
	public String validateUser(String email, String password) {
		Customer res = customerRepository.findByEmailAndPasswordContaining(email, password);
		
		
		if (res == null) {
			return "invalid";
		}
		return "success";
	}

}

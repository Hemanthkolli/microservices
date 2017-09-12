package com.ecm.api;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface CustomerRepository extends CrudRepository<Customer, Long>,JpaSpecificationExecutor<Customer> {
	
	Customer findByEmailAndPasswordContaining(String email,String password);
	 
	

}

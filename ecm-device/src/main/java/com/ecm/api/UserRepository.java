package com.ecm.api;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
@Service
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUserNameAndPassword(String UserName, String password);
	User findByLicenseExpiryDate(Date licenseExpiryDate);

}

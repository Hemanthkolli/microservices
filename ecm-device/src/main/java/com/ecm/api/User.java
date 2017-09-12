package com.ecm.api;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
     @Id
     @GeneratedValue
	private int Id;
	private String userName;
	private String password;
	private String accountAdmin;
	private Date licenseExpiryDate;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccountAdmin() {
		return accountAdmin;
	}
	public void setAccountAdmin(String accountAdmin) {
		this.accountAdmin = accountAdmin;
	}
	public Date getLicenseExpiryDate() {
		return licenseExpiryDate;
	}
	public void setLicenseExpiryDate(Date licenseExpiryDate) {
		this.licenseExpiryDate = licenseExpiryDate;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	
	
}

package com.ecm.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class DevicesGroup {
	@Id
	@GeneratedValue
    private Long id;
	private  String groupName;
	private long noOfDevices;
	private int noOfActiveDevices;
	private int noOfClients;
	private double dataUsage;
	private String username;
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public long getNoOfDevices() {
		return noOfDevices;
	}
	public void setNoOfDevices(long noOfDevices) {
		this.noOfDevices = noOfDevices;
	}
	public int getNoOfActiveDevices() {
		return noOfActiveDevices;
	}
	public void setNoOfActiveDevices(int noOfActiveDevices) {
		this.noOfActiveDevices = noOfActiveDevices;
	}
	public int getNoOfClients() {
		return noOfClients;
	}
	public void setNoOfClients(int noOfClients) {
		this.noOfClients = noOfClients;
	}
	public double getDataUsage() {
		return dataUsage;
	}
	public void setDataUsage(double dataUsage) {
		this.dataUsage = dataUsage;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
}

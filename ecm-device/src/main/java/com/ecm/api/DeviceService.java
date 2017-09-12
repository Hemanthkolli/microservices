package com.ecm.api;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface DeviceService {
	
	
	String addDevice(List<Device> device);
	Map<String,List<Device>> getAllDevices();

}

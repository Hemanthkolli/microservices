package com.ecm.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DevicesGroupServiceImpl {
	@Autowired
	DeviceGroupRepository deviceGroup;
	@Autowired
	private DeviceRepository deviceRepository;
	public String addGroupDevices(DevicesGroup devicesGroup) {
		DevicesGroup device = new DevicesGroup();
		device.setDataUsage(devicesGroup.getDataUsage());
		device.setGroupName(devicesGroup.getGroupName());
		device.setNoOfActiveDevices(devicesGroup.getNoOfActiveDevices());
		device.setNoOfClients(devicesGroup.getNoOfClients());
		String userName=devicesGroup.getUsername();
		int numOfDevices=deviceRepository.countByUserName(userName);
		device.setNoOfDevices(numOfDevices);
		device.setUsername(devicesGroup.getUsername());
		deviceGroup.save(device);
		return "success";

	}

	public Map<String, List<DevicesGroup>> getAllGroupsDevices() {
		Map<String, List<DevicesGroup>> map = new HashMap<>();
		List<DevicesGroup> res = deviceGroup.findAll();
		map.put("groupDevices", res);
		return map;

	}

	
}

package com.ecm.api;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface DeviceRepository extends CrudRepository<Device, Long> {

	Device findBySerial(String serial);
     int countByUserName(String username);
	List<Device> findAll();
}

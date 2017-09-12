package com.ecm.api;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
@Service
public interface DeviceGroupRepository extends CrudRepository<DevicesGroup, Long>{

	List<DevicesGroup> findAll();
	List<DevicesGroup> findByGroupName(String groupName);
}

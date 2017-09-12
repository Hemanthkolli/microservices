package com.ecm.entity;

import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Long> {
	
	public Users findByUuid(String uuid);

}

package com.tutorial.springframework.repository;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.springframework.entity.EmpEntity;

@Repository
public interface EmpRepository extends ListCrudRepository<EmpEntity, Integer>{

	//Write abstract method to query for diff data or write query
	Optional<EmpEntity> findByName(String name);
}

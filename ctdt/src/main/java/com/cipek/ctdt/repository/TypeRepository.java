package com.cipek.ctdt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cipek.ctdt.model.type.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
	
	

}

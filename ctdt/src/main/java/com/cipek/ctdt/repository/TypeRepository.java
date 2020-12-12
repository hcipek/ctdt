package com.cipek.ctdt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cipek.ctdt.model.type.Type;

@Repository
public interface TypeRepository extends BaseRepository<Type, Long> {
	
	@Query("select t.name from ColorType t")
	List<String> getAllColorTypeNames();
	
	@Query("select t.id from Type t where t.name=:name")
	Long getIdByName(@Param(value = "name") String name);
}

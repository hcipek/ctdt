package com.cipek.ctdt.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.cipek.ctdt.model.base.BaseModel;

@NoRepositoryBean
public interface BaseRepository<T extends BaseModel, E extends Serializable> extends JpaRepository<T, E> {
	
	Boolean existsByName(String name);
	T findByName(String name);
	List<T> findByNameContainingIgnoreCase(String name);

}

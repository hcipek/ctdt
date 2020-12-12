package com.cipek.ctdt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cipek.ctdt.model.base.BaseModel;
import com.cipek.ctdt.repository.BaseRepository;

public class BaseService<T extends BaseModel, U extends BaseRepository<T, Long>> {
	
	@Autowired
	public U repo;
	
	public T save(T t) {
		return repo.save(t);
	}
	
	public T get(Long id) {
		Optional<T> optional = repo.findById(id);
		if(optional.isEmpty())
			return null;
		else
			return optional.get();
	}
	
	public T getByName(String name) {
		return repo.findByName(name);
	}
	
	public List<T> getByNameContainingIgnoreCase(String name) {
		return repo.findByNameContainingIgnoreCase(name);
	}
	
	public Boolean existsByName(String name) {
		return repo.existsByName(name);
	}
	
	public void deleteAll() {
		repo.deleteAll();
	}

}

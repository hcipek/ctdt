package com.cipek.ctdt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cipek.ctdt.model.request.TypeRequest;
import com.cipek.ctdt.model.request.dto.TypeRequestDto;
import com.cipek.ctdt.model.response.TypeResponse;
import com.cipek.ctdt.model.type.*;
import com.cipek.ctdt.repository.TypeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TypeService {
	
	@Autowired
    private TypeRepository typeRepo;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public TypeResponse create(TypeRequest request ) {
		for(TypeRequestDto dto : request.getTypeList()) {
			@SuppressWarnings("unused")
			CategoryType catType = insertCategoryType(dto.getNam_());
			@SuppressWarnings("unused")
			CompetitionType compType = insertCompetitionType(dto.getNam_());
		}
		return new TypeResponse("success");
		
	}
	
	private CategoryType insertCategoryType(String name) {
		log.info("inserting categoryType with name");
		CategoryType type = new CategoryType();
		type.setName(name);
		return typeRepo.save(type);
	}
	
	private CompetitionType insertCompetitionType(String name) {
		log.info("inserting categoryType with name");
		CompetitionType type = new CompetitionType();
		type.setName(name);
		return typeRepo.save(type);
	}

}

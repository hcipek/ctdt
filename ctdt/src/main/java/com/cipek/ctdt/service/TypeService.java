package com.cipek.ctdt.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cipek.ctdt.model.request.TypeRequest;
import com.cipek.ctdt.model.request.dto.TypeRequestDto;
import com.cipek.ctdt.model.response.TypeResponse;
import com.cipek.ctdt.model.type.*;
import com.cipek.ctdt.repository.TypeRepository;
import com.cipek.ctdt.util.TypeUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TypeService {
	
	@Autowired
    private TypeRepository typeRepo;
	
	@Autowired
    private CountryService countryService;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public TypeResponse create(TypeRequest request ) {
		for(TypeRequestDto dto : request.getTypeList()) {
			handleTypeInserting(dto);
		}
		return new TypeResponse("success");
		
	}
	
	private void handleTypeInserting(TypeRequestDto dto) {
		Class<?> clazz = TypeUtils.getTypeByCode(dto.getCod_());
		String name = dto.getNam_();
		try {
			if(TypeUtils.CATEGORY_TYPE.equals(clazz.getSimpleName()))
				insertCategoryType(name);
			else if (TypeUtils.COMPETITION_SUPER_TYPE.equals(clazz.getSimpleName())) 
				insertCompetitionSuperType(name);
			else if (TypeUtils.COMPETITION_TYPE.equals(clazz.getSimpleName())) 
				insertCompetitionType(name);
			else if (TypeUtils.NATION_TYPE.equals(clazz.getSimpleName())) 
				insertNationType(name);
			else if (TypeUtils.REGION_TYPE.equals(clazz.getSimpleName())) 
				insertRegionType(name);
			else if (TypeUtils.STRUCTURE_SUPER_TYPE.equals(clazz.getSimpleName())) 
				insertStructureSuperType(name);
			else if (TypeUtils.TEAM_SKILL_TYPE.equals(clazz.getSimpleName())) 
				insertTeamSkillType(name);
		} catch (DataIntegrityViolationException e) {
			
		}
	}
	
	private CategoryType insertCategoryType(String name) {
		log.info("inserting CategoryType with name :{}", name);
		CategoryType type = new CategoryType();
		type.setName(name);
		return typeRepo.save(type);
	}
	
	private CompetitionSuperType insertCompetitionSuperType(String name) {
		log.info("inserting CompetitionSuperType with name :{}", name);
		CompetitionSuperType type = new CompetitionSuperType();
		type.setName(name);
		return typeRepo.save(type);
	}
	
	private CompetitionType insertCompetitionType(String name) {
		log.info("inserting CompetitionType with name :{}", name);
		CompetitionType type = new CompetitionType();
		CompetitionSuperType superType = getCompatitionSuperTypeByName(name);
		type.setName(name);
		type.setCompetitionSuperType(superType);
		return typeRepo.save(type);
	}
	
	private CompetitionSuperType getCompatitionSuperTypeByName(String name) {
		List<String> wordList = Stream.of(name.split("\\s+")).collect(Collectors.toList());
		return (CompetitionSuperType)typeRepo.findByName(wordList.get(wordList.size()-1));
	}
	
	private NationType insertNationType(String name) {
		log.info("inserting NationType with name :{}", name);
		return countryService.getCountryDetailsByCountryName(name);
	}
	
	private RegionType insertRegionType(String name) {
		log.info("inserting RegionType with name :{}", name);
		RegionType type = new RegionType();
		type.setName(name);
		return typeRepo.save(type);
	}
	
	private StructureSuperType insertStructureSuperType(String name) {
		log.info("inserting StructureSuperType with name :{}", name);
		StructureSuperType type = new StructureSuperType();
		type.setName(name);
		return typeRepo.save(type);
	}
	
	private TeamSkillType insertTeamSkillType(String name) {
		log.info("inserting TeamSkillType with name :{}", name);
		TeamSkillType type = new TeamSkillType();
		type.setName(name);
		return typeRepo.save(type);
	}
	
//	public T
	
	@Transactional(propagation = Propagation.REQUIRED)
	public TypeResponse clear(TypeRequest request) {
		typeRepo.deleteAll();
		return new TypeResponse("success");
	}

}

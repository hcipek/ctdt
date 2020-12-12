package com.cipek.ctdt.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cipek.ctdt.exception.BaseException;
import com.cipek.ctdt.model.request.TypeRequest;
import com.cipek.ctdt.model.request.dto.TypeRequestDto;
import com.cipek.ctdt.model.response.TypeResponse;
import com.cipek.ctdt.model.type.*;
import com.cipek.ctdt.repository.TypeRepository;
import com.cipek.ctdt.util.TypeUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TypeService extends BaseService<Type, TypeRepository> {
	
	@Autowired
    private CountryService countryService;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public TypeResponse create(TypeRequest request ) {
		TypeResponse response = new TypeResponse();
		try {
			for(TypeRequestDto dto : request.getTypeList()) {
				handleTypeInserting(dto);
			}
			response.setResultMessage("SUCCESSFUL");
		} catch (BaseException e) {
			response.setResultMessage(e.getReasonMessage());
		} catch (Exception e) {
			response.setResultMessage("UNEXPECTED_ERROR");
		}
		return response;
	}
	
	private void handleTypeInserting(TypeRequestDto dto) {
		Class<?> clazz = TypeUtils.getTypeByCode(dto.getCod_());
		
		if(TypeUtils.CATEGORY_TYPE.equals(clazz.getSimpleName()))
			insertCategoryType(dto);
		else if (TypeUtils.COMPETITION_SUPER_TYPE.equals(clazz.getSimpleName())) 
			insertCompetitionSuperType(dto);
		else if (TypeUtils.COMPETITION_TYPE.equals(clazz.getSimpleName())) 
			insertCompetitionType(dto);
		else if (TypeUtils.NATION_TYPE.equals(clazz.getSimpleName())) 
			insertNationType(dto);
		else if (TypeUtils.REGION_TYPE.equals(clazz.getSimpleName())) 
			insertRegionType(dto);
		else if (TypeUtils.STRUCTURE_SUPER_TYPE.equals(clazz.getSimpleName())) 
			insertStructureSuperType(dto);
		else if (TypeUtils.TEAM_SKILL_TYPE.equals(clazz.getSimpleName())) 
			insertTeamSkillType(dto);
		else if (TypeUtils.COLOR_TYPE.equals(clazz.getSimpleName())) 
			insertColorType(dto);
	}
	
	private CategoryType insertCategoryType(TypeRequestDto dto) {
		log.info("inserting CategoryType with name :{}", dto.getNam_());
		CategoryType type = new CategoryType();
		type.setName(dto.getNam_());
		type.setCode(dto.getCod_());
		return repo.save(type);
	}
	
	private CompetitionSuperType insertCompetitionSuperType(TypeRequestDto dto) {
		log.info("inserting CompetitionSuperType with name :{}", dto.getNam_());
		CompetitionSuperType type = new CompetitionSuperType();
		type.setName(dto.getNam_());
		type.setCode(dto.getCod_());
		return repo.save(type);
	}
	
	private CompetitionType insertCompetitionType(TypeRequestDto dto) {
		log.info("inserting CompetitionType with name :{}", dto.getNam_());
		CompetitionType type = new CompetitionType();
		CompetitionSuperType superType = getCompatitionSuperTypeByName(dto.getNam_());
		type.setName(dto.getNam_());
		type.setCode(dto.getCod_());
		type.setCompetitionSuperType(superType);
		return repo.save(type);
	}
	
	private CompetitionSuperType getCompatitionSuperTypeByName(String name) {
		List<String> wordList = Stream.of(name.split("\\s+")).collect(Collectors.toList());
		return getByName(CompetitionSuperType.class, wordList.get(wordList.size()-1));
	}
	
	private NationType insertNationType(TypeRequestDto dto) {
		log.info("inserting NationType with name :{}", dto.getNam_());
		return countryService.getCountryDetailsByCountryName(dto.getNam_(), dto.getCod_());
	}
	
	private RegionType insertRegionType(TypeRequestDto dto) {
		log.info("inserting RegionType with name :{}", dto.getNam_());
		RegionType type = new RegionType();
		type.setName(dto.getNam_());
		type.setCode(dto.getCod_());
		return repo.save(type);
	}
	
	private StructureSuperType insertStructureSuperType(TypeRequestDto dto) {
		log.info("inserting StructureSuperType with name :{}", dto.getNam_());
		StructureSuperType type = new StructureSuperType();
		type.setName(dto.getNam_());
		type.setCode(dto.getCod_());
		return repo.save(type);
	}
	
	private TeamSkillType insertTeamSkillType(TypeRequestDto dto) {
		log.info("inserting TeamSkillType with name :{}", dto.getNam_());
		TeamSkillType type = new TeamSkillType();
		type.setName(dto.getNam_());
		type.setCode(dto.getCod_());
		return repo.save(type);
	}
	
	private ColorType insertColorType(TypeRequestDto dto) {
		log.info("inserting ColorType with name :{}", dto.getNam_());
		ColorType type = new ColorType();
		type.setName(dto.getNam_());
		type.setCode(dto.getCod_());
		return repo.save(type);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public TypeResponse clear(TypeRequest request) {
		deleteAll();
		return new TypeResponse("success");
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public <T extends Type> T getByName(Class<T> clazz, String name) {
		return (T)repo.findByName(name);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public <T extends Type> T saveChild(Class<T> clazz, T type) {
		return (T)save(type);
	}

}

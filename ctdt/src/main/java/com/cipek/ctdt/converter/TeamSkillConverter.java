package com.cipek.ctdt.converter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cipek.ctdt.model.relation.Relation;
import com.cipek.ctdt.model.skill.TeamSkill;
import com.cipek.ctdt.model.type.RelationType;
import com.cipek.ctdt.model.type.TeamSkillType;
import com.cipek.ctdt.repository.RelationRepository;
import com.cipek.ctdt.repository.TeamSkillRepository;
import com.cipek.ctdt.repository.TypeRepository;
import com.cipek.ctdt.service.BaseService;
import com.cipek.ctdt.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TeamSkillConverter extends BaseService<TeamSkill, TeamSkillRepository> {
	
	private static String CLUB = "Club";
	private static String JAPANESE = "Japanese";
	private static String NON_JAPANESE = "Non-Japanese";
	private static String SOLIDARITY = "Super Solidarity";
	private static String AWAKENING = "Extreme Awakening";
	private static List<String> PREFIXES = Arrays.asList("With", "or", "more");
	private static List<String> CATEGORIES = Arrays.asList(CLUB, JAPANESE, NON_JAPANESE);
	
	@Autowired
	private TypeRepository typeRepo;
	
	@Autowired
	private RelationRepository relationRepo;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public TeamSkill createTeamSkillFromName(String name, String description) {
		
		if(repo.existsByNameAndDescription(name, description))
			return repo.findByNameAndDescription(name, description);
		
		TeamSkill teamSkill = new TeamSkill();
		teamSkill.setName(name);
		teamSkill.setDescription(description);
		
		//Team Skills that not have solidarity or awakening ignored.
		if(name.contains(SOLIDARITY))
			teamSkill.setTeamSkillType((TeamSkillType)typeRepo.findByName(SOLIDARITY));
		else if(name.contains(AWAKENING))
			teamSkill.setTeamSkillType((TeamSkillType)typeRepo.findByName(AWAKENING));
		else 
			return teamSkill;
		
		List<String> wordList = Stream.of(description.split("\\s+")).collect(Collectors.toList());
		
		teamSkill = handleWithNOrMoreTeamSkill(wordList, teamSkill);
		
		String word = wordList.get(wordList.size()-1);
		BigDecimal rate = new BigDecimal(StringUtils.strip(word, "+%")).setScale(2);
		rate = rate.divide(new BigDecimal(100), RoundingMode.CEILING).setScale(2);
		teamSkill.setRate(BigDecimal.ONE.add(rate));
		
		return save(teamSkill);
	}
	
	private TeamSkill handleWithNOrMoreTeamSkill(List<String> wordList, TeamSkill teamSkill) {
		List<String> colorNames = typeRepo.getAllColorTypeNames();
		StringBuilder builder = new StringBuilder();
		Relation relation = null;
		Long firstTypeId = null;
		Long secondaryTypeId = null;
		Boolean flag = true;
		
		Iterator<String> iterator = wordList.iterator();
		
		
		while(flag) {
			String word = iterator.next();
			if (StringUtils.containsAny(word, PREFIXES)) {
				while(StringUtils.containsAny(word, PREFIXES)) {
					word = iterator.next();
				}
				teamSkill.setRequiredCount(Integer.valueOf(word));
			} else { 
				if(StringUtils.containsAny(word, colorNames)) {
					log.debug("Type restricted...");
					builder.append(" " + word);
					String color = word.split("-")[0];
					firstTypeId = typeRepo.getIdByName(color);
				} else if(StringUtils.containsAny(word, CATEGORIES)) {
					log.debug("Category base restriction");
					word = StringUtils.strip(word, ":");
					builder.append(" " + word);
					secondaryTypeId = typeRepo.getIdByName(word);
					flag=false;
				} else {
					log.debug("Country base restriction");
					word = StringUtils.strip(word, ":");
					builder.append(" " + word);
					secondaryTypeId = typeRepo.getIdByName(word);
					flag=false;
				}
			}
		}
		
		if(relationRepo.existsByFirstTypeIdAndSecondaryTypeId(firstTypeId, secondaryTypeId))
			relation = relationRepo.findByFirstTypeIdAndSecondaryTypeId(firstTypeId, secondaryTypeId);
		else {
			relation = new Relation();
			relation.setName(teamSkill.getTeamSkillType().getName().concat(" ").concat(builder.toString()));			
			relation.setFirstTypeId(firstTypeId);
			relation.setSecondaryTypeId(secondaryTypeId);
			relation.setRelationType(getRelationType(teamSkill.getName()));
			relation = relationRepo.save(relation);
		}
		
		teamSkill.setRelation(relation);
		return teamSkill;
	}
	
	private RelationType getRelationType(String name ) {
		List<String> wordList = Stream.of(name.split("\\s+")).collect(Collectors.toList());
		String desiredName = wordList.get(0) + " " + wordList.get(1) + " Relation" ;
		if(typeRepo.existsByName(desiredName)) {
			return (RelationType)typeRepo.findByName(desiredName);
		} else {
			RelationType type = new RelationType();
			type.setName(desiredName);
			return typeRepo.save(type);
		}
		
	}


}

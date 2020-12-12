package com.cipek.ctdt.repository;

import org.springframework.stereotype.Repository;

import com.cipek.ctdt.model.skill.TeamSkill;

@Repository
public interface TeamSkillRepository extends BaseRepository<TeamSkill, Long> {
	
	Boolean existsByNameAndDescription(String name, String description);
	TeamSkill findByNameAndDescription(String name, String description);
	

}

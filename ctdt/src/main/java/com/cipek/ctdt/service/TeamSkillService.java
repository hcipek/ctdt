package com.cipek.ctdt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cipek.ctdt.converter.TeamSkillConverter;
import com.cipek.ctdt.model.request.TeamSkillRequest;
import com.cipek.ctdt.model.request.dto.TeamSkillDto;
import com.cipek.ctdt.model.response.TeamSkillResponse;
import com.cipek.ctdt.model.skill.TeamSkill;
import com.cipek.ctdt.repository.TeamSkillRepository;

@Service
public class TeamSkillService extends BaseService<TeamSkill, TeamSkillRepository>{
	
	@Autowired
	private TeamSkillConverter teamSkillConverter;

	@Transactional(propagation = Propagation.REQUIRED)
	public TeamSkillResponse create(TeamSkillRequest request ) {
		for(TeamSkillDto dto : request.getSkillList()) {
			teamSkillConverter.createTeamSkillFromName(dto.getNam_(), dto.getDes_());
		}
		TeamSkillResponse resp =  new TeamSkillResponse("success");
		return resp;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public TeamSkill createOrGetTeamSkill(TeamSkillDto dto) {
		return teamSkillConverter.createTeamSkillFromName(dto.getNam_(), dto.getDes_());
	}
}

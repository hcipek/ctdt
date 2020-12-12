package com.cipek.ctdt.model.request;

import java.util.List;

import com.cipek.ctdt.model.request.dto.TeamSkillDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class TeamSkillRequest {

	private List<TeamSkillDto> skillList;
	
	public TeamSkillRequest() {
		
	}
}

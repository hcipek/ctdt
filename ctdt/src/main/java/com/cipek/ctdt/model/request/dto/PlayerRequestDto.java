package com.cipek.ctdt.model.request.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class PlayerRequestDto {
	
	private String name;
	private String title;
	private String playerNationName;
	private String playerTeamName;
	private StatCardDto stats;
	private TeamSkillDto teamSkill;
	private SkillSetDto skillSet;
	
	public PlayerRequestDto() {
		
	}

}

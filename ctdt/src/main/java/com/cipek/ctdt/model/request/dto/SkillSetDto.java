package com.cipek.ctdt.model.request.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class SkillSetDto {

	private SkillDto pas_;
	private List<SkillDto> hid_;
	
	public SkillSetDto() {
		
	}
	
}

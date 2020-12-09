package com.cipek.ctdt.model.request.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class TeamSkillDto {
	
	private String tar_;
	private Integer req_;
	private BigDecimal rat_;
	
	public TeamSkillDto() {
		
	}

}

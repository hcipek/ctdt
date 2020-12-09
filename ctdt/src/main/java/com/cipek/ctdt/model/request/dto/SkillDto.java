package com.cipek.ctdt.model.request.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class SkillDto {

	private String nam_;
	private BigDecimal rat_;
	private Integer req_;
	
	public SkillDto() {
		
	}
}

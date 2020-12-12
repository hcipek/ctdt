package com.cipek.ctdt.model.request.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class StatCardDto {
	
	private Integer sta_;
	private Integer dri_;
	private Integer sho_;
	private Integer pas_;
	private Integer tac_;
	private Integer blo_;
	private Integer int_;
	private Integer spe_;
	private Integer pow_;
	private Integer tec_;
	private String low_;
	private String hig_;
	
	public StatCardDto() {
		
	}

}

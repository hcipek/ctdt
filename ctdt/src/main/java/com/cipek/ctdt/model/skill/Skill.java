package com.cipek.ctdt.model.skill;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cipek.ctdt.model.base.BaseModel;
import com.cipek.ctdt.model.type.StructureType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="skill")
public class Skill extends BaseModel {
	
	@Column(name="skill_structure_id")
	private Long skillStructureId;
	
	@OneToOne
	@JoinColumn(name="structure_type_id")
	private StructureType structureType;
	
	@Column(name="rate")
	private BigDecimal rate;
	
	@Column(name="required_minimum")
	private Integer requiredMinimum;
	
	@Column(name="required_type")
	private Boolean isMinimum;

}

package com.cipek.ctdt.model.skill;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cipek.ctdt.model.base.BaseModel;
import com.cipek.ctdt.model.relation.Relation;
import com.cipek.ctdt.model.type.TeamSkillType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="team_skill", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"name", "description"})
})
public class TeamSkill extends BaseModel {
	
	@Column(name="description", nullable=false)
	private String description;
	
	@Column(name="rate", nullable=false)
	private BigDecimal rate;
	
	@Column(name="required_count")
	private Integer requiredCount;

	@OneToOne
	@JoinColumn(name="team_skill_type_id", nullable=false)
	private TeamSkillType teamSkillType;
	
	@OneToOne
	@JoinColumn(name="relation_id")
	private Relation relation;

}

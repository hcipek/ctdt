package com.cipek.ctdt.model.relation;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cipek.ctdt.model.base.BaseModel;
import com.cipek.ctdt.model.player.Player;
import com.cipek.ctdt.model.skill.Skill;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="skill_card")
public class SkillCard extends BaseModel {
	
	@OneToOne(mappedBy = "skillCard")
    private Player player;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="passive_skill_id", referencedColumnName = "id")
	private Skill passiveSkill;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="hidden_skill1_id", referencedColumnName = "id")
	private Skill hiddenSkill1;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="hidden_skill2_id", referencedColumnName = "id")
	private Skill hiddenSkill;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="hidden_skill3_id", referencedColumnName = "id")
	private Skill hiddenSkill3;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="hidden_skill4_id", referencedColumnName = "id")
	private Skill hiddenSkill4;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="hidden_skill5_id", referencedColumnName = "id")
	private Skill hiddenSkill5;
	
	

}

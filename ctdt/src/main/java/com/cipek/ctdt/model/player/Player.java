package com.cipek.ctdt.model.player;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cipek.ctdt.model.base.BaseModel;
import com.cipek.ctdt.model.relation.SkillCard;
import com.cipek.ctdt.model.skill.TeamSkill;
import com.cipek.ctdt.model.type.ColorType;
import com.cipek.ctdt.model.type.NationType;
import com.cipek.ctdt.model.type.TeamType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "player")
public class Player extends BaseModel {
	
	@OneToOne
	@JoinColumn(name="color_type_id")
	private ColorType colorType;
	
	@OneToOne
	@JoinColumn(name="nation_type_id")
	private NationType nation;

	@OneToOne
	@JoinColumn(name="team_id")
	private TeamType team;
	
	@Column(name="title")
	private String title;
	
	@Column(name="stamina")
	private Integer stamina;
	
	@Column(name="dribble")
	private Integer dribble;
	
	@Column(name="shot")
	private Integer shot;
	
	@Column(name="pass")
	private Integer pass;
	
	@Column(name="tackle")
	private Integer tackle;
	
	@Column(name="block")
	private Integer block;
	
	@Column(name="intercept")
	private Integer intercept;
	
	@Column(name="speed")
	private Integer speed;
	
	@Column(name="power")
	private Integer power;
	
	@Column(name="technique")
	private Integer technique;

	@Column(name="high_ball")
	private String highBall;
	
	@Column(name="low_ball")
	private String lowBall;
	
	@OneToOne
	@JoinColumn(name="team_skill_id")
	private TeamSkill teamSkill;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skill_card_id", referencedColumnName = "id")
	private SkillCard skillCard;
	
}

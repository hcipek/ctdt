package com.cipek.ctdt.model.type;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
//@Table(name="team_type")
@DiscriminatorValue("team_type")
public class TeamType extends Type {

	@OneToOne
	@JoinColumn(name="competition_type_id")
	private CompetitionType competitionType;
}

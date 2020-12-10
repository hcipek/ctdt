package com.cipek.ctdt.model.type;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@DiscriminatorValue("competition_type")
public class CompetitionType extends Type {

	@OneToOne
	@JoinColumn(name="competition_super_type_id")
	private CompetitionSuperType competitionSuperType;
	
}

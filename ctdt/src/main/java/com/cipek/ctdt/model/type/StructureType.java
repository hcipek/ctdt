package com.cipek.ctdt.model.type;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@DiscriminatorValue("structure_type")
public class StructureType extends Type{

	@OneToOne
	@JoinColumn(name="structure_super_type_id")
	private StructureSuperType structureSuperType;
}

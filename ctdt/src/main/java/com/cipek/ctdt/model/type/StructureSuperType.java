package com.cipek.ctdt.model.type;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Setter;

import lombok.Getter;

@Entity
@Getter @Setter
@DiscriminatorValue("structure_super_type")
public class StructureSuperType extends Type {

}

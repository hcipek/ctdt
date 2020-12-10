package com.cipek.ctdt.model.type;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Setter;

import lombok.Getter;

@Entity
@Getter @Setter
@DiscriminatorValue("region_type")
public class RegionType extends Type {

}

package com.cipek.ctdt.model.type;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("relation_type")
public class RelationType extends Type {

}

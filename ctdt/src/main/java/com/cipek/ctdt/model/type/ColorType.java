package com.cipek.ctdt.model.type;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("color_type")
public class ColorType extends Type {

	
}

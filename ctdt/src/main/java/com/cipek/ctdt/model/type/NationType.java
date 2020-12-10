package com.cipek.ctdt.model.type;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@DiscriminatorValue("nation_type")
public class NationType extends Type {
	
	@OneToOne
	@JoinColumn(name="category_type_id")
	private CategoryType categoryType;
	
	@OneToOne
	@JoinColumn(name="region_type_id")
	private RegionType regionType;
}

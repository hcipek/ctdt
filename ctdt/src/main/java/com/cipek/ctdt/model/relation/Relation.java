package com.cipek.ctdt.model.relation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.cipek.ctdt.model.base.BaseModel;
import com.cipek.ctdt.model.type.RelationType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Relation extends BaseModel {
	
	@Column(name="first_type_id")
	private Long firstTypeId;
	@Column(name="secondary_type_id")
	private Long secondaryTypeId;
	@OneToOne
	@JoinColumn(name="relation_type_id", nullable=false)
	private RelationType relationType;
}

package com.cipek.ctdt.model.type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cipek.ctdt.model.base.BaseType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="type", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"name", "code"})
})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Type extends BaseType {
	
	@Column(name = "code")
	private Integer code;

}

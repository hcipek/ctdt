package com.cipek.ctdt.model.type;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.cipek.ctdt.model.base.BaseType;

@Entity
@Table(name="type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Type extends BaseType {

}

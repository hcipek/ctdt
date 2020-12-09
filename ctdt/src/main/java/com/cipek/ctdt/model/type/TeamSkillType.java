package com.cipek.ctdt.model.type;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("team_skill_type")
public class TeamSkillType extends Type {

}

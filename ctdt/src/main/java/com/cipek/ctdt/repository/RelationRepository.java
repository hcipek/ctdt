package com.cipek.ctdt.repository;

import org.springframework.stereotype.Repository;

import com.cipek.ctdt.model.relation.Relation;

@Repository
public interface RelationRepository extends BaseRepository<Relation, Long> {
	
	Boolean existsByFirstTypeIdAndSecondaryTypeId(Long firstTypeId, Long secondaryTypeId); 
	Relation findByFirstTypeIdAndSecondaryTypeId(Long firstTypeId, Long secondaryTypeId); 

}

package com.moss.custom.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.moss.custom.dto.OrphanDto;
import com.moss.custom.dto.OrphansLookupDTO;
import com.moss.custom.model.orphan.Orphan;

@Mapper
public interface OrphanMapper {

	OrphanMapper MAPPER = Mappers.getMapper(OrphanMapper.class);
	
	@Mappings({
	    @Mapping(target = "lineage", source = "orphanLineageType"),
	    @Mapping(target = "dateOfBirth", source = "birthday"),
	    @Mapping(target = "educationStage", source = "educationalLevel")
	  })
	OrphanDto mapToOrphanDTO(Orphan orphan);
	
	OrphansLookupDTO mapToOrphansLookupDTO(Orphan orphan);
}
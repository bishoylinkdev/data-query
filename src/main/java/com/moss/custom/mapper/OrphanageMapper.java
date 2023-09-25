package com.moss.custom.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.moss.custom.dto.OrphanageDto;
import com.moss.custom.dto.OrphanagesLookupDTO;
import com.moss.custom.model.orphanage.Orphanage;

@Mapper
public interface OrphanageMapper {

	OrphanageMapper MAPPER = Mappers.getMapper(OrphanageMapper.class);
	
//	@Mappings({
//	    @Mapping(target = "group", constant = "headerSettings"),
//	    @Mapping(target = "name", constant = "showLogo"),
//	    @Mapping(target = "value", source = "headerSettings.showLogo")
//	  })
	OrphanageDto mapToOrphanageDto(Orphanage orphanage);
	
	OrphanagesLookupDTO mapToOrphanagesLookupDTO(Orphanage orphan);
}
package com.moss.custom.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.moss.custom.dto.GeneralLookupDTO;
import com.moss.custom.model.aid.AidType;

@Mapper
public interface GeneralLookupMapper {

	GeneralLookupMapper MAPPER = Mappers.getMapper(GeneralLookupMapper.class);
		
	AidType mapToAidType(GeneralLookupDTO aidTypeDto);
}
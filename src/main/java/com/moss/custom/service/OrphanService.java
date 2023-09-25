package com.moss.custom.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moss.custom.dto.OrphanDto;
import com.moss.custom.exception.OrphanNotFoundException;
import com.moss.custom.mapper.OrphanMapper;
import com.moss.custom.model.orphan.Orphan;
import com.moss.custom.repository.OrphanRepository;

@Service
public class OrphanService {

	@Autowired
	private OrphanRepository orphanRepository;

	public OrphanDto getOrphan(Long id) throws OrphanNotFoundException {

		Optional<Orphan> orphan= orphanRepository.findById(id);
		
		 if(orphan.isPresent())
			 return OrphanMapper.MAPPER.mapToOrphanDTO(orphan.get());
		 
		 else
			 throw new OrphanNotFoundException(Long.toString(id));
	}

}

package com.moss.custom.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moss.custom.dto.OrphanagesLookupDTO;
import com.moss.custom.exception.OrphanNotFoundException;
import com.moss.custom.exception.OrphanageNotFoundException;
import com.moss.custom.mapper.OrphanageMapper;
import com.moss.custom.model.common.Administration;
import com.moss.custom.model.orphanage.Orphanage;
import com.moss.custom.repository.AdministrationRepository;

@Service
public class AdmininstrationService {

	@Autowired
	private AdministrationRepository administrationRepository;

	public List<OrphanagesLookupDTO> getAdminOrphanages(Long administrationId) throws OrphanageNotFoundException, OrphanNotFoundException {

		Optional<Administration> adminOptional = administrationRepository.findById(administrationId);

		if (!adminOptional.isPresent())
			throw new OrphanNotFoundException(Long.toString(administrationId));

		Set<Orphanage> orphanages = adminOptional.get().getOrphanages();
		
		return orphanages.stream().map((orphanage) -> OrphanageMapper.MAPPER.mapToOrphanagesLookupDTO(orphanage))
				.collect(Collectors.toList());

	}
}

package com.moss.custom.lookup.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moss.custom.model.orphanage.OrphanageIncomeSourceType;
import com.moss.custom.repository.IncomeSourceRepository;

@Service
public class IncomeSourceService {

	@Autowired
	private IncomeSourceRepository incomeSourceRepository;

	public List<String> getIncomeSourceTypeLookup() {

		List<OrphanageIncomeSourceType> incomeSourceTypes = incomeSourceRepository.findAll();

		return incomeSourceTypes.stream().map((incomeSourceType) -> incomeSourceType.getType())
				.collect(Collectors.toList());
	}
}

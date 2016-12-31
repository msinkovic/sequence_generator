package com.springwebapp.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springwebapp.domain.GeneratedData;
import com.springwebapp.repositories.GeneratedDataRepository;
import com.springwebapp.services.GeneratedDataService;

@Service
public class GeneratedDataServiceImpl implements GeneratedDataService{

	@Autowired
	private GeneratedDataRepository generatedDataRepository;
	
	@Override
	public List<GeneratedData> listAllGeneratedData() {
		return (List<GeneratedData>) generatedDataRepository.findAll();
	}

	@Override
	public GeneratedData getGeneratedDataBySeqNum(Long id) {
		return generatedDataRepository.findOne(id);
	}

	@Override
	public void deleteGeneratedData(Long id) {
		generatedDataRepository.delete(id);
	}
	
}

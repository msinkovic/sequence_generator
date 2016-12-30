package com.springwebapp.services;

import java.util.List;

import com.springwebapp.domain.GeneratedData;

public interface GeneratedDataService {

	List<GeneratedData> listAllGeneratedData();

	GeneratedData getGeneratedDataBySeqNum(Long id);

	void deleteGeneratedData(Long id);
	
}

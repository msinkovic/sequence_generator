package com.springwebapp.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springwebapp.domain.GeneratedData;
import com.springwebapp.services.GeneratedDataService;
import com.springwebapp.services.GeneratedDataServiceImpl;

@Controller
public class DataController {

	private GeneratedDataService generatedDataService;
	
	@Autowired
    public void setGeneratedDataService(GeneratedDataService generatedDataService) {
        this.generatedDataService = generatedDataService;
    }

	@RequestMapping(value = "generatedData", method = RequestMethod.GET)
	public List<GeneratedData> dataList(Map<String,Object> model)
	{
		List<GeneratedData> allData = generatedDataService.listAllGeneratedData();
		return allData;
	}
	

	@Bean
	public GeneratedDataService generatedDataService(){
		return new GeneratedDataServiceImpl();
	}
	
}

package com.springwebapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springwebapp.domain.GeneratedData;
import com.springwebapp.domain.Users;
import com.springwebapp.repositories.GeneratedDataRepository;
import com.springwebapp.services.GeneratedDataService;

@Controller
public class DataController {

	@Autowired
	private GeneratedDataService generatedDataService;
	
	@Autowired
	private GeneratedDataRepository generatedDataRepository;

	
	@RequestMapping(value = "/generatedDataList", method = RequestMethod.GET)
	public String dataList(Model model)
	{
		List<GeneratedData> allData = generatedDataService.listAllGeneratedData();
		model.addAttribute("allData", allData);
		return "hello";
	}
	
	@RequestMapping(value = "/generateData", method = RequestMethod.POST)
	public String setData(Model model){
		GeneratedData data = new GeneratedData();
		List<GeneratedData> allData = generatedDataService.listAllGeneratedData();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		
		if (principal instanceof Users) {
		  username = ((Users)principal).getUsername();
		} else {
		  username = principal.toString();
		}

		String pom;
		int poc = username.indexOf("Username: ");
		poc += 10;
		int kraj = username.indexOf(";", poc);
		pom = username.substring(poc, kraj);
		data.setUsername(pom);
		data.setNextSeqNum((long) (allData.size() + 1));
		model.addAttribute("data", data);
		return "generateData";
	}
	
	@PostMapping("/saveData")
    public String dataSubmit(@Valid @ModelAttribute GeneratedData data, BindingResult bindingResult, @RequestParam(value = "version", required=false) Integer version) {
		
		if (data.getVersion() != version) {
	        bindingResult.reject("concurrency", "The data was modified concurrently.");
	    }
		
		 if (bindingResult.hasErrors()) {
		        return "login";
		    } else {
				generatedDataRepository.save(data);
		        return "redirect:/hello";
		    }
    }
	
}

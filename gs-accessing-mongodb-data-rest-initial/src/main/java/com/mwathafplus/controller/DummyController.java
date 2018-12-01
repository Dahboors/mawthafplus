package com.mwathafplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mwathafplus.service.DummyService;

@RestController
@RequestMapping("DummyData/api")
public class DummyController {

	@Autowired 
	private DummyService dummyService ;
	
	@GetMapping("/addEmployee")
	public boolean getEmployee() {
		dummyService.addEmployee();
		return true;
	}
	
}

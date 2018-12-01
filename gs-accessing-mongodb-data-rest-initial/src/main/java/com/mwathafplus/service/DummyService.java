package com.mwathafplus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mwathafplus.entities.Employee;
import com.mwathafplus.repo.EmployeeRepo;

@Component
public class DummyService {

	@Autowired
	EmployeeRepo employeeRepo;

	
	public boolean addEmployee() {
		List<Employee> employees = new ArrayList<Employee>();

		Employee employee = new Employee();
		employee.setEmpId("0000");
		employee.setFirstName("Saba");
		employee.setLastName("Dahboor");
		employee.setAddress("Zarqa");
		employee.setMobileNumber("0787874001");
		employee.setCompanyId("Asp_01");
		employees.add(employee);
		employee = new Employee();
		employee.setEmpId("0002");
		employee.setFirstName("Adallah");
		employee.setLastName("Flafil");
		employee.setAddress("Amman");
		employee.setMobileNumber("0787874001");
		employee.setCompanyId("Zain_02");
		employees.add(employee);
		employee = new Employee();
		employee.setEmpId("0003");
		employee.setFirstName("Abdallah");
		employee.setLastName("Dababas");
		employee.setAddress("Zarqa");
		employee.setMobileNumber("0787874001");
		employee.setCompanyId("LG_03");
		employees.add(employee);

		employee = new Employee();
		employee.setEmpId("0004");
		employee.setFirstName("Muzna");
		employee.setLastName("Sabari");
		employee.setAddress("Amman");
		employee.setMobileNumber("0787874001");
		employee.setCompanyId("Asp_01");
		employees.add(employee);
		
		employeeRepo.saveAll(employees);
		
		return true;
		
	}

}

package com.mwathafplus.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.mwathafplus.entities.Employee;

@Component
public interface EmployeeRepo extends MongoRepository<Employee, String> {

	Optional<Employee> findByEmpId(String empId);

	List<Employee> findByCompanyId(String companyId);

	
}

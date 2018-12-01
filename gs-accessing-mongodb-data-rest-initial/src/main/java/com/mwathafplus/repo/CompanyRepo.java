package com.mwathafplus.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.mwathafplus.entities.Company;
@Component
public interface CompanyRepo extends MongoRepository<Company, String> {

	Optional<Company> findByCompanyId(String companyId);

	
}

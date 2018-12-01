package com.mwathafplus.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.mwathafplus.entities.Merchant;

@Component
public interface MerchantRepo extends MongoRepository<Merchant, String>{

	Optional<Merchant> findByMerchId(String merchId);
	
	Optional<Merchant> findByMerchIdAndEmailAddress(String merchantId, String emailAddress);
}

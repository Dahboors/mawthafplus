package com.mwathafplus.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.mwathafplus.data.DiscountData;
import com.mwathafplus.entities.Discount;

@Component
public interface DiscountsRepo extends MongoRepository<Discount, String> {

	Optional<List<Discount>> findBycompanyIdAndCategoryId(String companyId,int categoryId);

	List<Integer> findBycompanyId(String companyId);

	Optional<List<Discount>> findByMerchId(String merchId);

	Long deleteByMerchIdAndCompanyId(String merchantId, String companyId);
}

package com.mwathafplus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mwathafplus.data.DiscountData;
import com.mwathafplus.data.EmployeeData;
import com.mwathafplus.entities.Company;
import com.mwathafplus.entities.Discount;
import com.mwathafplus.entities.Employee;
import com.mwathafplus.entities.Merchant;
import com.mwathafplus.exception.CompanyNotFoundException;
import com.mwathafplus.exception.EmployeeNotFoundException;
import com.mwathafplus.repo.CompanyRepo;
import com.mwathafplus.repo.DiscountsRepo;
import com.mwathafplus.repo.EmployeeRepo;
import com.mwathafplus.repo.MerchantRepo;

@Component
public class MwathafPlusService {

	@Autowired
	EmployeeRepo employeeRepo;
	
	@Autowired
	CompanyRepo companyRepo;
	
	@Autowired
	DiscountsRepo discountRepo;
	
	@Autowired
	MerchantRepo merchantRepo;

	public List<DiscountData> getDiscounts(String companyId,int categoryId)
	{
		List<DiscountData> discountData = new ArrayList<DiscountData>();
		Optional<List<Discount>> discounts = discountRepo.findBycompanyIdAndCategoryId(companyId,categoryId);
		if(discounts.isPresent()) {
			List<Discount> listOfDiscounts = discounts.get();
			listOfDiscounts.forEach(x->{
			String merchantName = getMerchantById(x.getMerchId());
			String companyName = getCompanyById(companyId);
			DiscountData discount = new DiscountData(companyName,merchantName,x.getValue(),x.getLang(),x.getLat());
			discountData.add(discount);
			});
		}
		
		return discountData;
	}
	
	public List<Integer> getCategories(String companyId){
		
		return discountRepo.findBycompanyId(companyId);
	}
	
	public EmployeeData findEmployee(String employeeId) {
		Optional<Employee> employee = employeeRepo.findByEmpId(employeeId);
		if(!employee.isPresent())
		throw new EmployeeNotFoundException();

		Employee emp = employee.get();
		EmployeeData employeeData = new EmployeeData(emp.getFirstName(),emp.getLastName(),emp.getMobileNumber(),emp.getEmpId(),emp.getCompanyId());
		return employeeData;
	}
	public Company saveCompany(String companyId,String name, String mobileNumber, String address) {
		Company company = new Company(companyId,name,mobileNumber,address);
		return companyRepo.save(company);
	}
	
	
	public Merchant saveMerchant(String merchantId, String name, String mobileNumber, String address) {
		Merchant merchant = new Merchant(merchantId,name,mobileNumber,address);
		return merchantRepo.save(merchant);
	}
		
	
	//--ToDo
	public Discount saveDiscounst(String companyId, String merchId, int value,int categoryId, String lang, String lat)
	{
		
		//check companyId not found
		Optional<Company> company = companyRepo.findByCompanyId(companyId);
		
		if(!company.isPresent()) {
			throw new CompanyNotFoundException();
		}
		
		//save discount
		Discount discount= discountRepo.save(new Discount(companyId, merchId, categoryId, value, lang, lat));
		
		//after add discount send offer for Employee of company
		List<Employee> employees = employeeRepo.findByCompanyId(companyId);
		
		return discount;
	}

	public List<DiscountData> getDiscountsByMerchantId(String merchantId) {
		List<DiscountData> discountData = new ArrayList<DiscountData>();

		Optional<List<Discount>> discounts = discountRepo.findByMerchId(merchantId);
		
		if(discounts.isPresent()) {
			List<Discount> listOfDiscounts = discounts.get();
			listOfDiscounts.forEach(x->{
			String merchantName = getMerchantById(merchantId);
			String companyName = getCompanyById(x.getCompanyId());
			DiscountData discount = new DiscountData(companyName,merchantName,x.getValue(),x.getLang(),x.getLat());
			discountData.add(discount);
			});
		}
		
		return discountData;
		
	}


	
	private String getCompanyById(String companyId) {
		Optional<Company> company = companyRepo.findByCompanyId(companyId);
		if(!company.isPresent())
		throw new CompanyNotFoundException();
		
		return company.get().getName();
	}
	
	private String getMerchantById(String merchantId) {
		Optional<Merchant> merchant = merchantRepo.findByMerchId(merchantId);
		if(!merchant.isPresent())
		throw new CompanyNotFoundException();
		
		return merchant.get().getName();
	}

	public boolean removeDiscounts(String merchantId, String companyId) {
		return discountRepo.deleteByMerchIdAndCompanyId(merchantId,companyId);
	}
}

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
import com.mwathafplus.exception.MerchantNotFoundException;
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
			DiscountData discount = new DiscountData(companyName,merchantName,x.getValue(),x.getLang(),x.getLat(),companyId);
			discountData.add(discount);
			});
		}
		
		return discountData;
	}
	
	public List<Integer> getCategories(String companyId){
		
		return discountRepo.findBycompanyId(companyId);
	}
	
	public EmployeeData findEmployee(String employeeId,String tokenId) {
		Optional<Employee> employee = employeeRepo.findByEmpId(employeeId);
		if(!employee.isPresent())
		throw new EmployeeNotFoundException();

		
		Employee emp = employee.get();
		emp.setTokenId(tokenId);
		//update employee with token
		employeeRepo.save(emp);
		
		EmployeeData employeeData = new EmployeeData(emp.getFirstName(),emp.getLastName(),emp.getMobileNumber(),emp.getEmpId(),emp.getCompanyId());
		return employeeData;
	}
	public Company saveCompany(String companyId,String name, String mobileNumber, String address) {
		Company company = new Company(companyId,name,mobileNumber,address);
		return companyRepo.save(company);
	}
	
	
	public Merchant saveMerchant(String merchantId, String name, String mobileNumber, String address,String emailAddress) {
		Merchant merchant = new Merchant(merchantId,name,mobileNumber,address,emailAddress);
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
			DiscountData discount = new DiscountData(companyName,merchantName,x.getValue(),x.getLang(),x.getLat(),x.getCompanyId());
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
		discountRepo.deleteByMerchIdAndCompanyId(merchantId,companyId);
		return true;
	}
	
	
	public void sendNotification() {
	    //Just I am passed dummy information
        String tokenId = "cHtZVDYNfiY:APA91bEIzJLk7jjjmPuLexdYGeekUpQ6w8M2bn45VUC_oytyWRlXWKu6LJ1k28yWIX5bRBpp0eKDD5SN1pZsKq9VQXiLpZpICeDetP562FaOBdwd1UmO2OUYx9c4cQJHQ5dsR_DJI-Gu";

        String server_key = "AAAAhEy3EPQ:APA91bEnGV0KxOvmz8pQcAxRRUGZ2jZWuTpirwnOT-CCrqcgYw8mBJGZ43vxuNvy7DAvVC4yusSsJ2jC56k2tCx9-Z27PhMkVayQCybDu3wN3dsbXXgQw3JqZw3QUADTfNryBkDKcP36";

        String title = "Hello ... ";

        String message = "Welcome to FCM Server push notification!.";

//Method to send Push Notification
        FCM.send_FCM_Notification(tokenId, server_key, title, message);
	}

	public Merchant getMerchantByMerchantIdAndEmailAddress(String merchantId, String emailAddress) {
		
		Optional<Merchant> merchant = merchantRepo.findByMerchIdAndEmailAddress(merchantId,emailAddress);
		
		if(!merchant.isPresent())
			throw new MerchantNotFoundException();
		
			return merchant.get();
	}
}

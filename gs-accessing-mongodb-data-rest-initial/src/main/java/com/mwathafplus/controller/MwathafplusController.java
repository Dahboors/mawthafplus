package com.mwathafplus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mwathafplus.data.DiscountData;
import com.mwathafplus.data.EmployeeData;
import com.mwathafplus.entities.Company;
import com.mwathafplus.entities.Discount;
import com.mwathafplus.entities.Merchant;
import com.mwathafplus.service.MwathafPlusService;

@RestController
@RequestMapping("mwathafplus/api")
public class MwathafplusController {
	@Autowired 
	private MwathafPlusService mwathafPlusService ;

	/**
	 * for Login Page in Mobile Application
	 * @param employeeId
	 * @return
	 */
	@GetMapping("/Employee/{employeeId}")
	public EmployeeData getEmployee(@PathVariable String employeeId) {
		return mwathafPlusService.findEmployee(employeeId);
	}

	/**
	 * for categories Page in Mobile Application
	 * @param companyId
	 * @return
	 */
	@GetMapping("/categories/{companyId}")
	public List<Integer> getCategories(@PathVariable String companyId)
	{
		return mwathafPlusService.getCategories(companyId);
	}
	
	/**
	 * for Discount Page in Mobile Applications
	 * @param companyId
	 * @param categoryId
	 * @return
	 */
	@GetMapping("/offers/{companyId}/{categoryId}")
	public List<DiscountData> getOffers(@PathVariable String companyId,@PathVariable int categoryId)
	{
		return mwathafPlusService.getDiscounts(companyId,categoryId);
	}
	
	@PostMapping("/company")
    public Company saveCompany(String companyId,String companyName, String mobileNumber, String address)
    {
        return mwathafPlusService.saveCompany(companyId,companyName, mobileNumber, address);
    }
	
	@PostMapping("/merchant")
    public Merchant saveMerchant(String merchantId,String name, String mobileNumber, String address)
    {
        return mwathafPlusService.saveMerchant(merchantId,name, mobileNumber, address);
    }
	
	/**
	 * 
	 * @param merchantId
	 * @return
	 */
	@GetMapping("/offers/{merchantId}")
	public List<DiscountData> getOffersByMerchantId(@PathVariable String merchantId)
	{
		return mwathafPlusService.getDiscountsByMerchantId(merchantId);
	}
	
	@PostMapping("/removedOffers/{merchantId}/{companyId}")
	public boolean removeOffersByMerchantId(@PathVariable String merchantId,@PathVariable String companyId)
	{
		return mwathafPlusService.removeDiscounts(merchantId,companyId);
	}
	
	//--ToDo must value be double 
	/**
	 * to Save Offers 
	 * @param companyId
	 * @param merchId
	 * @param value
	 * @param category
	 * @param lang
	 * @param lat
	 * @return
	 */
	@PostMapping("/offers")
	public Discount saveOffers(String companyId, String merchId, int value, int category, String lang, String lat)
	{
		return mwathafPlusService.saveDiscounst(companyId, merchId, category, value, lang, lat);
	}
}

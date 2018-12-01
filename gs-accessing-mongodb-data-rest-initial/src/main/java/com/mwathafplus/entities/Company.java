package com.mwathafplus.entities;

import org.springframework.data.annotation.Id;

public class Company {

	@Id
	String id;
	
	String companyId;

	String name;

	String mobileNumber;
	
	String  address;
	
	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}

	Company()
	{
		
	}
	
	public Company(String companyId,String name, String mobileNumber, String address) {
		super();
		this.companyId = companyId;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", address=" + address + "]";
	}
	
	
	

	
}

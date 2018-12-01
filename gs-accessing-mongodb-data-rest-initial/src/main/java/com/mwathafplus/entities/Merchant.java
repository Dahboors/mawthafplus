package com.mwathafplus.entities;

import org.springframework.data.annotation.Id;

public class Merchant {

	@Id
	String id;
	
	String merchId;
	
	String merchantName;
	
	String name;

	String mobileNumber;
	
	String  address;
	
	String emailAddress;
	
	public String getMerchId() {
		return merchId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setMerchId(String merchId) {
		this.merchId = merchId;
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

	Merchant()
	{
		
	}
	
	public Merchant(String merchId,String name, String mobileNumber, String address,String emailAddress) {
		super();
		this.merchId=merchId;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.emailAddress=emailAddress;
	}

	@Override
	public String toString() {
		return "Merchant [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", address=" + address + "]";
	}
	
	
	


}

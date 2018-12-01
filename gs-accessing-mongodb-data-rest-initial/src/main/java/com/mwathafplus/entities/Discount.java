package com.mwathafplus.entities;

import org.springframework.data.annotation.Id;

public class Discount {

	@Id
	String id;

	String companyId;

	String merchId;

	int value;
	
	int categoryId;
	
	String lang;
	
	String lat;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int category) {
		this.categoryId = category;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getMerchId() {
		return merchId;
	}

	public void setMerchId(String merchId) {
		this.merchId = merchId;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getId() {
		return id;
	}
	
	public Discount()
	{}

	public Discount(String companyId, String merchId, int value, int category, String lang, String lat) {
		super();
		this.companyId = companyId;
		this.merchId = merchId;
		this.value = value;
		this.categoryId = category;
		this.lang = lang;
		this.lat = lat;
	}

	@Override
	public String toString() {
		return "Discount [id=" + id + ", companyId=" + companyId + ", merchId=" + merchId + ", value=" + value
				+ ", category=" + categoryId + ", lang=" + lang + ", lat=" + lat + "]";
	}
}

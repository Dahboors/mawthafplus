package com.mwathafplus.data;

public class DiscountData {

	private String companyName;
	private String marchentName;
	private int valueOfDiscount;
	private String lang;
	private String lat;
	
	public String getMarchentName() {
		return marchentName;
	}
	public void setCompanyName(String companyName) {
		this.companyName=companyName;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setMarchentName(String marchentName) {
		this.marchentName = marchentName;
	}
	public int getValueOfDiscount() {
		return valueOfDiscount;
	}
	public void setValueOfDiscount(int valueOfDiscount) {
		this.valueOfDiscount = valueOfDiscount;
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
	
	public DiscountData() {
	}
	
	public DiscountData(String companyName,String marchentName, int valueOfDiscount, String lang, String lat) {
		super();
		this.companyName= companyName;
		this.marchentName = marchentName;
		this.valueOfDiscount = valueOfDiscount;
		this.lang = lang;
		this.lat = lat;
	}
	
	
}

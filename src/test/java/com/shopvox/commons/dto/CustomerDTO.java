package com.shopvox.commons.dto;

public class CustomerDTO {

	
	private String name ;
	private String leagalName ;
	private String type ;
	private String board_view ;
	private String status ;
	private String tax ;
	private String terms ;
	private String sales_rep ;
	private String primary_name ;
	private String email;
	private String primary_email;
	private String primary_phone;
	private String ext ;
	private String industry ;
	private String lead_source ;
	private String pricing;
	private String credit_limit;
	
	public String toString(){
		String res = "name = " + name +  "; leagalName = " +leagalName +  "; type = " +
	type  + "; board_view = " + board_view  +  "name = " + status + tax + terms + sales_rep + primary_name + email + primary_email + primary_phone + ext + industry + lead_source + pricing + credit_limit;
		return res;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

	public String getLeagalName() {
		return leagalName;
	}

	public void setLeagalName(String leagalName) {
		this.leagalName = leagalName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBoard_view() {
		return board_view;
	}

	public void setBoard_view(String board_view) {
		this.board_view = board_view;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	public String getSales_rep() {
		return sales_rep;
	}

	public void setSales_rep(String sales_rep) {
		this.sales_rep = sales_rep;
	}

	public String getPrimary_name() {
		return primary_name;
	}

	public void setPrimary_name(String primary_name) {
		this.primary_name = primary_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrimary_email() {
		return primary_email;
	}

	public void setPrimary_email(String primary_email) {
		this.primary_email = primary_email;
	}

	public String getPrimary_phone() {
		return primary_phone;
	}

	public void setPrimary_phone(String primary_phone) {
		this.primary_phone = primary_phone;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getLead_source() {
		return lead_source;
	}

	public void setLead_source(String lead_source) {
		this.lead_source = lead_source;
	}

	public String getPricing() {
		return pricing;
	}

	public void setPricing(String pricing) {
		this.pricing = pricing;
	}

	public String getCredit_limit() {
		return credit_limit;
	}

	public void setCredit_limit(String credit_limit) {
		this.credit_limit = credit_limit;
	}
	
	
	
	
}

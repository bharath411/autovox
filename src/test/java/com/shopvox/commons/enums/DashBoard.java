package com.shopvox.commons.enums;

public enum DashBoard {

	JOBS("Jobs"),
	RESOURCES("Resources"),
	CUSTOMERS_VENDORS("Customers & Vendors"),
	TRANSACTIONS(""),
	SALESLEADS(""),
	MAT_REQS(""),
	PROJECTS(""),
	TASKS(""),
	CATALOGES("");
	String value = "";
	private DashBoard(String value){
		this.value= value;
	}
	
	public String getDashBoardValue(){
		return value;
	}
}

package com.rit.inheritance;

public class Inheritence {
	private String fname;
	private String lname;
	public Inheritence(String thefname,String thelname) {
		fname=thefname;
		lname=thelname;
	}
	public String getName() {		
		return fname+" "+lname;
	}
	
	private String getFirstName() {
		return fname;
	}
	private String getLastName() {
		return lname;
	}

}

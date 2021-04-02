package com.timbuchalka.springdemo;

import java.util.ArrayList;
import java.util.List;

import com.timbuchalka.springdemo.dao.OrganizationDAO;
import com.timbuchalka.springdemo.domain.Organization;

public class DaoUtils {
	
	public static final String createOperation = "CREATE";
	public static final String readOperation = "READ";
	public static final String uppdateOperation = "UPDATE";
	public static final String deleteOperation = "DELETE";
	public static final String cleanupOperation = "TRUNCATE";
	
	
	public static void printOrganizations(List<Organization> orgs, String operation) {
		
		System.out.println("\n******** printing organization after " + operation + " operation ********");
		for(Organization org: orgs) {
			System.out.println(org);
		}
		
	}
	
	public static void printOrganization(Organization org, String operation) {
		System.out.println("\n******** printing organization after invoking " 
							+ operation + " operation ******** " + org);
	}
	
	public static void printSuccessFailure(String operation, boolean param) {
		
		if(param)
			System.out.println("\nOperation " + operation + " succesful");
		else
			System.out.println("\nOperation " + operation + " failed");
		
	}
	
	public static void createSeedData(OrganizationDAO dao) {
		
		Organization org1 = new Organization("Amazon", 1994, "65656", 8765, "Work hard, make fun, make history");
		Organization org2 = new Organization("BMW", 1929, "45454", 5501, "We build ultimate Driving machines");
		Organization org3 = new Organization("Google", 1996, "57575", 4567, "Don't be evil");
		
		List<Organization> orgs = new ArrayList<Organization>();
		orgs.add(org1); orgs.add(org2); orgs.add(org3);
		
		int createCount = 0;
		for(Organization org: orgs) {
			boolean isCreated = dao.create(org);
			if(isCreated)
				createCount++;
		}
		
		System.out.println("Created " + createCount + " organization");
				
		
	}
	
	
	public static void printOrganizationCount(List<Organization> orgs, String operation) {
		
		System.out.println("\n******** currently we have " + orgs.size()  
					   + " organization after " + operation + " operation ********");
		
	}
	
	

}

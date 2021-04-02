package com.timbuchalka.springdemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.timbuchalka.springdemo.dao.OrganizationDAO;
import com.timbuchalka.springdemo.domain.Organization;

public class JdbcTemplateClassicApp2 {
	
	public static void main(String[] args) {
		
		//Creating the application context
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		//create the bean
		
		OrganizationDAO dao = (OrganizationDAO) ctx.getBean("orgDao");
		
		//Create seed data
		
		DaoUtils.createSeedData(dao);
		
		//List organization
		List<Organization> orgs = dao.getAllOrganization();
		DaoUtils.printOrganizations(orgs, DaoUtils.readOperation);
		
		//Create a new organization
		Organization org = new Organization("General Electric", 1978, "98989", 5776, "Imagination at work");
		boolean isCreated = dao.create(org);
		DaoUtils.printSuccessFailure(DaoUtils.createOperation, isCreated);
		DaoUtils.printOrganizationCount(orgs, DaoUtils.createOperation);
		
		//CleanUp
		dao.cleanUp();
		DaoUtils.printOrganizationCount(dao.getAllOrganization(), DaoUtils.cleanupOperation);
		
		
		((ClassPathXmlApplicationContext) ctx).close();
		
	}

}

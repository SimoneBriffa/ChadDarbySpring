package com.timbuchalka.springdemo;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.timbuchalka.springdemo.dao.OrganizationDAO;
import com.timbuchalka.springdemo.domain.Organization;

public class JdbcTemplateClassicApp1 {
	
	public static void main(String[] args) {
		
		//Creating the application context
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		//create the bean
		
		OrganizationDAO dao = (OrganizationDAO) ctx.getBean("orgDao");
		List<Organization> orgs = dao.getAllOrganization();
		
		for(Organization org: orgs)
			System.out.println(org);
		
		
		((ClassPathXmlApplicationContext) ctx).close();
		
	}

}

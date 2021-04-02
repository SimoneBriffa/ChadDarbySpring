package com.timbuchalka.springdemo.dao;

import java.util.List;

import javax.sql.DataSource;

import com.timbuchalka.springdemo.domain.Organization;

public interface OrganizationDAO {
	
	
	//Prende i dati per connettersi al database
	public void setDataSource(DataSource ds);
	
	//Effettua una registrazione nella tabella
	public boolean create(Organization org);
	
	//preleva una singola voce dalla tabella
	public Organization getOrganization(Integer id);
	
	//preleva tutto
	public List<Organization> getAllOrganization();
	
	//cancella una specifica voce
	public boolean delete(Organization org);
	
	//modifica
	public boolean update(Organization org);
	
	//
	public void cleanUp();

}

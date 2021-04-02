package com.timbuchalka.springdemo.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.timbuchalka.springdemo.dao.OrganizationDAO;
import com.timbuchalka.springdemo.domain.Organization;

@Repository("orgDao")
public class OrganizationDaoImpl implements OrganizationDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource ds) {
		
		jdbcTemplate = new JdbcTemplate(ds);
		//il dataSource fa riferimento ad un file xml

	}

	public boolean create(Organization org) {
		String sqlQuery = "INSERT INTO organization (company_name, year_of_incorporation, "
				+ "postal_code, employee_count, slogan) VALUES (?,?,?,?,?)";
		Object[] args = new Object[] {org.getCompanyName(), org.getYearOfIncorporation(),
				       org.getPostalCode(), org.getEmployeeCount(), org.getSlogan()};
		
		return jdbcTemplate.update(sqlQuery, args) == 1;
		//cioè deve tornare 1 come numero di righe manipolate
		
		}
	

	public Organization getOrganization(Integer id) {
		String sqlQuery = "SELECT * FROM organization WHERE id = ?";
		Object[] args = new Object[] {id};
		Organization org = jdbcTemplate.queryForObject(sqlQuery, args, new OrganizationRowMapper());
		return org;
	}

	public List<Organization> getAllOrganization() {
		String sqlQuery = "SELECT * FROM organization";
		List<Organization> orgList = jdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
		
		return orgList;
	}

	public boolean delete(Organization org) {
	
		String sqlQuery = "DELETE FROM organization WHERE id = ?";
		Object[] args = new Object[] {org.getId()};
		
		return jdbcTemplate.update(sqlQuery, args) == 1;
	
	}

	public boolean update(Organization org) {
		
		String sqlQuery = "UPDATE organization SET slogan = ? WHERE id = ?";
		Object[] args = new Object[] {org.getSlogan(), org.getId()};
		
		return jdbcTemplate.update(sqlQuery, args) == 1;
		
	}

	public void cleanUp() {
		
		String sqlQuery = "TRUNCATE TABLE organization";
		jdbcTemplate.execute(sqlQuery);

	}
	
	

}

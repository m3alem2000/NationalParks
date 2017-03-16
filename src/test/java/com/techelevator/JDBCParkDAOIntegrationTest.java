package com.techelevator;

import org.springframework.beans.factory.annotation.Autowired;

import com.techelevator.npgeek.parks.jdbc.JDBCParkDAO;

public class JDBCParkDAOIntegrationTest extends DAOIntegrationTest{
	
	@Autowired
	private JDBCParkDAO parkDao;

}

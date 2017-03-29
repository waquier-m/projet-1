package com.test;
import com.metier.*;
import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CamionTest {

	private Camion c;
	private SimpleDateFormat formater;
	private Date demain;
	@Before
	
	public void setUp() throws Exception {
		formater = new SimpleDateFormat("dd/MM/yyyy");
		Date aujourdhui = null;
		aujourdhui = formater.parse("17/07/2016");
		c = new Camion("AA-123-BB", aujourdhui);
		Date demain = formater.parse("04/04/2014");
	}

	@After
	public void tearDown() throws Exception {
		c=null;
	}
	@Test
	public void testCamion() {
		assertNotNull("L'instance est créée",c);
	}

	@Test
	public void testToString() {
		
	}

	@Test
	public void testGetImmatriculation() {
		assertEquals("Est ce que immatriculation est correct", "AA-123-BB",c.getImmatriculation());
		
	}

	@Test
	public void testSetImmatriculation() {
		c.setImmatriculation("BB-321-AA");
		assertEquals("Est ce que immatriculation est correct", "BB-321-AA",c.getImmatriculation());
		
	}

	@Test
	public void testGetDateMiseEnCirculation() {
		assertEquals("Est ce que la date est correct", "17/07/2016",formater.format(c.getDateMiseEnCirculation()));
		
	}

	@Test
	public void testSetDateMiseEnCirculation() {
		c.setDateMiseEnCirculation(demain);
		assertEquals("Est ce que la date est correct","04/04/2014",formater.format(c.getDateMiseEnCirculation()));
		
		
	}

	
	

}

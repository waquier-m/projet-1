package com.test;
import com.metier.*;
import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Chauffeur;

public class ChauffeurTest {
	private SimpleDateFormat formater = null;
	private Chauffeur c;
    @Before
	

	// System.out.println(formater.format(aujourdhui));

	public void setUp() throws Exception {

		formater = new SimpleDateFormat("dd/MM/yyyy");
		Date aujourdhui = null;
		aujourdhui = formater.parse("17/07/2016");
		c = new Chauffeur("id1", "nom1", "prenom1", aujourdhui);
		//System.out.println(c.getIdChauffeur());
	}

	@After
	public void tearDown() throws Exception {
		c = null;
	}
	@Test
	public void testChauffeur() {
		assertNotNull("L'instance est créée",c);
		
	}

	@Test
	public void testToString() {
		
	}

	@Test
	public void testGetIdChauffeur() {
		assertEquals("Est ce que id est correct", "id1",c.getIdChauffeur());
		
	}

	

	@Test
	public void testGetNomChauffeur() {
		assertEquals("Est ce que nom est correct", "nom1",c.getNomChauffeur());
		
		
	}

	//@Test
	public void testSetNomChauffeur() {
		c.setIdChauffeur("nom2");
		assertEquals("Est ce que nom est correct", "nom2",c.getNomChauffeur());
		fail("Not yet implemented");
	}

	@Test
	public void testGetPrenomChauffeur() {
		assertEquals("Est ce que prenom est correct", "prenom1",c.getPrenomChauffeur());
		
	}

	//@Test
	/*public void testSetPrenomChauffeur() {
		c.setIdChauffeur("prenom2");
		assertEquals("Est ce que prenom est correct", "prenom2",c.getIdChauffeur());
		fail("Not yet implemented");
	}*/

	@Test
	public void testGetDateEmbauche() {
		assertEquals("Est ce que la date est correct", "17/07/2016",formater.format(c.getDateEmbauche()));
		
	}

	@Test
	public void testSetDateEmbauche() {
		
	}

	
	

}

package com.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Levee;

public class LeveeTest2 {
	
	private Levee l;
	private SimpleDateFormat formater;

	@Before
	public void setUp() throws Exception {
		formater = new SimpleDateFormat("dd/MM/yyyy");
		Date aujourdhui = null;
		aujourdhui = formater.parse("17/07/2016");
		l = new Levee(20,aujourdhui,50.5,"idPoub1","immat1","idChauf1");
	}

	@After
	public void tearDown() throws Exception {
		l = null;
	}
	@Test
	public void testLevee() {
		assertNotNull("L'instance est créée",l);
		
	}

	@Test
	public void testToString() {
		
	}

	@Test
	public void testGetIdLevee() {
		assertEquals("Est ce que id est correct",20,l.getIdLevee());
		
		
	}

	@Test
	public void testSetIdLevee() {
		l.setIdLevee(21);
		assertEquals("Est ce que id est correct",21,l.getIdLevee());
	}

	@Test
	public void testGetLaDate() {
		
		
	}

	@Test
	public void testSetLaDate() {
		
	}

	@Test
	public void testGetPoids() {
		assertTrue(50.5 == l.getPoids());
		assertFalse(50.5 != l.getPoids());
	}

	@Test
	public void testSetPoids() {
		l.setPoids(100.5);
		assertTrue(100.5 == l.getPoids());
		assertFalse(100.5 != l.getPoids());
	}

	@Test
	public void testGetIdPoubelle() {
		assertEquals("Est ce que idPoub est correct","idPoub1", l.getIdPoubelle());
	
	}

	@Test
	public void testSetIdPoubelle() {
		l.setIdPoubelle("idPoub2");
		assertEquals("Est ce que idPoub est correct","idPoub2",l.getIdPoubelle());
	
	}

	@Test
	public void testGetImmatriculation() {
		assertEquals("Est ce que immat est correct","immat1",l.getImmatriculation());
	
	}

	@Test
	public void testSetImmatriculation() {
		l.setImmatriculation("immat2");
		assertEquals("Est ce que immat est correct","immat2",l.getImmatriculation());
	
	}

	@Test
	public void testGetIdChauffeur() {
		assertEquals("Est ce que idChauf est correct","idChauf1",l.getIdChauffeur());
	
	}

	@Test
	public void testSetIdChauffeur() {
		l.setIdChauffeur("idChauf2");
		assertEquals("Est ce que idChauf est correct","idChauf2",l.getIdChauffeur());

	}

	

}

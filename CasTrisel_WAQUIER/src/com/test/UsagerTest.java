package com.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Habitation;
import com.metier.Usager;

public class UsagerTest {
	
	private Usager u;
	private Habitation h1;
	private Habitation h2;
	private ArrayList<Habitation> lesHabitations;

	@Before
	
	public void setUp() throws Exception {
		u = new Usager("id1","nom1", "prenom1", "adrRue1", "cp1", "adrVille1");
		h1 = new Habitation("id1","adrRue1","cp1","adrVille1", 5,u);
		h2 = new Habitation("id2","adrRue2","cp2","adrVille2", 5,u);
	}

	@After
	public void tearDown() throws Exception {
		u = null;
	}

	@Test
	public void testToString() {
		
	}
	@Test
	public void testUsager() {
		assertNotNull("L'instance est créée", u);
	
	}

	@Test
	public void testGetId() {
		assertEquals("Est ce que id est correct", "id1",u.getId());
		
	}

	@Test
	public void testSetId() {
		u.setId("id2");
		assertEquals("Est ce que id est correct", "id2",u.getId());
		
	}

	@Test
	public void testGetNom() {
		assertEquals("Est ce que nom est correct", "nom1",u.getNom());
		
	}

	@Test
	public void testSetNom() {
		u.setNom("nom2");
		assertEquals("Est ce que nom est correct", "nom2",u.getNom());
		
	}

	@Test
	public void testGetPrenom() {
		assertEquals("Est ce que prenom est correct", "prenom1",u.getPrenom());
	}

	@Test
	public void testSetPrenom() {
		u.setPrenom("prenom2");
		assertEquals("Est ce que prenom est correct", "prenom2",u.getPrenom());
		
	}

	@Test
	public void testGetAdrRueUsager() {
		assertEquals("Est ce que adrRue est correct", "adrRue1",u.getAdrRueUsager());
		
	}

	@Test
	public void testSetAdrRueUsager() {
		u.setAdrRueUsager("adrRue2");
		assertEquals("Est ce que adrRue est correct", "adrRue2",u.getAdrRueUsager());
		
	}

	@Test
	public void testGetCpUsager() {
		assertEquals("Est ce que cp est correct", "cp1",u.getCpUsager());
		
	}

	@Test
	public void testSetCpUsager() {
		u.setCpUsager("cp2");
		assertEquals("Est ce que cp est correct", "cp2",u.getCpUsager());
		
	}

	@Test
	public void testGetAdrVilleUsager() {
		assertEquals("Est ce que adrVille est correct", "adrVille1",u.getAdrVilleUsager());
	}

	@Test
	public void testSetAdrVilleUsager() {
		u.setAdrVilleUsager("adrVille2");
		assertEquals("Est ce que adrVille est correct", "adrVille2",u.getAdrVilleUsager());
	
	}

	@Test
	public void testGetLesHabitations() {
		//lesHabitations.add(h1);
		//lesHabitations.add(h2);
		//assertEquals("Est ce que habitation est correct", h1,u.getLesHabitations());
		
	}

	@Test
	public void testSetLesHabitations() {
		
	}

	

	@Test
	public void testAjoutHabitation() {
	
	}

	@Test
	public void testSupprimerHabitation() {
		
	}

}

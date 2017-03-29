package com.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Habitation;
import com.metier.Poubelle;
import com.metier.Usager;

public class HabitationTest2 {
	private Habitation h;
	private Usager usager;
	private Usager usager2;
	private Poubelle p1;
	private Poubelle p2;
	ArrayList<Poubelle> lesPoubelles;

	@Before
	public void setUp() throws Exception {
		
		usager = new Usager("nom1","prenom1","adrRue1","cp1","adrVille1", null);
		usager2 = new Usager("nom2","prenom2","adrRue2","cp2","adrVille2", null);
		p1 = new Poubelle("idPoub1","idHab1",null);
		p2 = new Poubelle("idPoub2","idHab2",null);
		h = new Habitation("id1","adrRue1","cp1","adrVille1", 5,usager);
		
	}

	@After
	public void tearDown() throws Exception {
		h = null;
	}

	@Test
	public void testHabitation() {
		assertNotNull("L'instance est créée",h);
		
	}

	@Test
	public void testGetUsager() {
		assertEquals("Est ce que usager est correct", usager,h.getUsager());

		
	}

	@Test
	public void testSetUsager() {
		h.setUsager(usager2);
		assertEquals("Est ce que usager est correct", usager2,h.getUsager());
	
	}

	@Test
	public void testGetLesPoubelles() {
		lesPoubelles.add(p1);
		lesPoubelles.add(p2);
		h.setLesPoubelles(lesPoubelles);
		assertEquals("Est ce que poubelle est correct",p1, h.getLesPoubelles());
	
	}

	@Test
	public void testSetLesPoubelles() {
	
	}

	@Test
	public void testToString() {
	
	}

	@Test
	public void testGetIdHabitation() {
		assertEquals("Est ce que idHab est correct","id1", h.getIdHabitation());
	
	}

	@Test
	public void testSetIdHabitation() {
		h.setIdHabitation("id2");
		assertEquals("Est ce que idHab est correct","id2", h.getIdHabitation());
	
	}

	@Test
	public void testGetAdrRueHab() {
		assertEquals("Est ce que adrRue est correct","adrRue1", h.getAdrRueHab());
	}

	@Test
	public void testSetAdrRueHab() {
		h.setAdrRueHab("adrRue2");
		assertEquals("Est ce que adrRue est correct","adrRue2", h.getAdrRueHab());	
	
	}

	@Test
	public void testGetCpHab() {
		assertEquals("Est ce que cp est correct","cp1", h.getCpHab());
	
	}

	@Test
	public void testSetCpHab() {
		h.setCpHab("cp2");
		assertEquals("Est ce que cp est correct","cp2", h.getCpHab());
	}

	@Test
	public void testGetAdrVilleHab() {
		assertEquals("Est ce que adrVille est correct","adrVille1", h.getAdrVilleHab());
	}

	@Test
	public void testSetAdrVilleHab() {
		h.setAdrVilleHab("adrVille2");
		assertEquals("Est ce que adrVille est correct","adrVille2", h.getAdrVilleHab());
	}

	@Test
	public void testGetNbPersonne() {
		assertEquals("Est ce que nbPersonne est correct",5, h.getNbPersonne());

	}

	@Test
	public void testSetNbPersonne() {
		h.setNbPersonne(8);
		assertEquals("Est ce que nbPersonne est correct",8, h.getNbPersonne());
		
	}

}

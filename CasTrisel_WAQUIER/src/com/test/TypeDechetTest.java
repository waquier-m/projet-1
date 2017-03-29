package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.TypeDechet;

public class TypeDechetTest {
	private TypeDechet TypeD;

	@Before
	public void setUp() throws Exception {
		TypeD = new TypeDechet("id1","libelle1",50.5);
	}

	@After
	public void tearDown() throws Exception {
		TypeD = null;
	}
	@Test
	public void testTypeDechet() {
		assertNotNull("L'instance est créée",TypeD);
	}

	@Test
	public void testGetIdTypeDechet() {
		assertEquals("Est ce que id est correct", "id1",TypeD.getIdTypeDechet());
		
	}

	@Test
	public void testSetIdTypeDechet() {
		TypeD.setIdTypeDechet("id2");
		assertEquals("Est ce que id est correct", "id2",TypeD.getIdTypeDechet());
		
	}

	@Test
	public void testGetLibelle() {
		assertEquals("Est ce que libelle est correct", "libelle1",TypeD.getLibelle());
		
	}

	@Test
	public void testSetLibelle() {
		TypeD.setLibelle("libelle2");
		assertEquals("Est ce que libelle est correct", "libelle2",TypeD.getLibelle());
		
	}

	@Test
	public void testGetTarif() {
		assertEquals("Est ce que tarif est correct", "50.5",TypeD.getTarif());
		
	}

	@Test
	public void testSetTarif() {
		TypeD.setTarif(100.5);
		assertEquals("Est ce que tarif est correct", "100.5",TypeD.getTarif());
		
	}

	@Test
	public void testToString() {
		
	}

	

}

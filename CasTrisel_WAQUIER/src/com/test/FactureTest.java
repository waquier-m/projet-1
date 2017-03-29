package com.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Facture;

public class FactureTest {
	
	private Facture f;
	private SimpleDateFormat formater;

	@Before
	public void setUp() throws Exception {
		
		f = new Facture("id1","mois1","annee1","nom1");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testToString() {
		
	}

	@Test
	public void testFacture() {
		
	}

	@Test
	public void testGetIdFacture() {
		
	}

	@Test
	public void testSetIdFacture() {
		
	}

	@Test
	public void testGetMoisF() {
		
	}

	@Test
	public void testSetMoisF() {
		
	}

	@Test
	public void testGetAnF() {
		
	}

	@Test
	public void testSetAnF() {
		
	}

	@Test
	public void testGetNomFacture() {
		
	}

	@Test
	public void testSetNomFacture() {
		
	}

}

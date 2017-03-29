package com.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Levee;
import com.metier.Poubelle;
import com.metier.TypeDechet;

public class PoubelleTest2 {
	private Poubelle p;
	private TypeDechet typeDechet;
	private TypeDechet typeDechet2;
	private SimpleDateFormat formater;
	private ArrayList lesLevees = new ArrayList<Levee>();

	@Before
	public void setUp() throws Exception {
		
		typeDechet = new TypeDechet("id1","libelle1",50.5);
		formater = new SimpleDateFormat("dd/MM/yyyy");
		Date aujourdhui = null;
		aujourdhui = formater.parse("17/07/2016");
		p = new Poubelle("idPoub1","idHab1",typeDechet);
	}

	@After
	public void tearDown() throws Exception {
		p = null;
	}
	@Test
	public void testPoubelle() {
		assertNotNull("L'instance est créée",p);
		
	}
	

	@Test
	public void testToString() {
		
	}

	@Test
	public void testGetIdPoubelle() {
		assertEquals("Est ce que idPoub est correct", "idPoub1",p.getIdPoubelle());
		
	}

	@Test
	public void testSetIdPoubelle() {
		p.setIdPoubelle("idPoub2");
		assertEquals("Est ce que idPoub est correct", "idPoub2",p.getIdPoubelle());
		
	}

	

	@Test
	public void testGetIdHabitation() {
		assertEquals("Est ce que idHab est correct", "idHab1",p.getIdHabitation());
		
	}

	@Test
	public void testSetIdHabitation() {
		p.setIdHabitation("idHab2");
		assertEquals("Est ce que idHab est correct", "idHab2",p.getIdHabitation());
		
	}

	@Test
	public void testGetNature() {
		assertEquals("Est ce que nature est correct", typeDechet,p.getNature());
		
	}

	@Test
	public void testSetNature() {
		typeDechet2 = new TypeDechet("id2","libelle2",150.5);
		p.setNature(typeDechet2);
		assertEquals("Est ce que nature est correct", typeDechet2,p.getNature());
		
		
	}

	@Test
	public void testGetLesLevees() throws ParseException {
		
		
		lesLevees.add("levee1");
		lesLevees.add("levee2");
		p.setLesLevees(lesLevees);
		assertEquals(lesLevees, p.getLesLevees());
		assertNotEquals(" ", p.getLesLevees());
	}
	@Test
	public void testSetLesLevees() {
		p.setLesLevees(lesLevees);
		assertEquals("Est ce que levee est correct", lesLevees,p.getLesLevees());
		
		
		
		
		
	}

	

}

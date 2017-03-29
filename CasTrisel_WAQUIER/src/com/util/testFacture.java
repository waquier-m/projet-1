package com.util;

import java.util.ArrayList;

import com.metier.Habitation;
import com.pdf.EditionFacture;
import com.pdf.EditionFacturePDF;


public class testFacture {
	

	public static void testFacture(int an, int mois)
	{
		/*
		HabitationDAO hDAO= new HabitationDAO() ;
		ArrayList<Habitation> lesHabitations = hDAO.retrieve() ;
		EditionFacturePDF.editionElementfacture(hDAO.find("hab1"), an, mois);
		*/
		
		ArrayList<Habitation> lesHabitations = AccesData.getLesHabitations();
		//EditionFacturePDF.editionElementfacture(AccesData.getHabitation("hab1"), an, mois);
			
		
		if(lesHabitations.size() != 0) 
		{
			for(Habitation h : lesHabitations)
			{
					EditionFacturePDF.editionElementfacture(h, an, mois);
			}
		}
	}
	}

		



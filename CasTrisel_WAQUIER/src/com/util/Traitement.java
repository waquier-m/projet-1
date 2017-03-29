package com.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import com.metier.Habitation;
import com.pdf.*;

public class Traitement {
	
	public static void insertion()
	{	
		int nbFichiers = Parametre.nbLevee();	
		System.out.println("Nombre de fichier a traiter " +nbFichiers);
		
		if(nbFichiers != 0)
		{
			System.out.println("Traitement en cours...");
			InsertionLevee.traitementLevee();
			System.out.println("Traitement effectu�");
		}
		else
		{
			System.out.println("Aucun fichier � traiter");
		}
		
		
	}
	public static void facturation()
	{
		Scanner in=new Scanner(System.in);
		ArrayList<Habitation> listeHab = AccesData.getLesHabitations();
		System.out.println("Num�ro du mois de la facture � �diter : ");
		int mois = in.nextInt();
		System.out.println("Ann�e de la facture � �diter : ");
		int an = in.nextInt();
		if(listeHab.size() != 0)
		{
			System.out.println("Traitement en cours...");
			for(Habitation h : listeHab)
			{
				EditionFacturePDF.editionElementfacture(h, an, mois);
				
			}
			System.out.println("Traitement termin�");
		}
		else
		{
			System.out.println("Aucunes habitations � traiter.");
		}
		
		
		
	}

}

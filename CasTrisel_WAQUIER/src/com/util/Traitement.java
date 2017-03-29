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
			System.out.println("Traitement effectué");
		}
		else
		{
			System.out.println("Aucun fichier à traiter");
		}
		
		
	}
	public static void facturation()
	{
		Scanner in=new Scanner(System.in);
		ArrayList<Habitation> listeHab = AccesData.getLesHabitations();
		System.out.println("Numéro du mois de la facture à éditer : ");
		int mois = in.nextInt();
		System.out.println("Année de la facture à éditer : ");
		int an = in.nextInt();
		if(listeHab.size() != 0)
		{
			System.out.println("Traitement en cours...");
			for(Habitation h : listeHab)
			{
				EditionFacturePDF.editionElementfacture(h, an, mois);
				
			}
			System.out.println("Traitement terminé");
		}
		else
		{
			System.out.println("Aucunes habitations à traiter.");
		}
		
		
		
	}

}

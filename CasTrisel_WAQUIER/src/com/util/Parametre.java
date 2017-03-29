package com.util;

import java.io.File;

import com.metier.Habitation;

public class Parametre {

	private static String nomFichier = "paramAppli.ini";
	
	private static final String tabMois[]={"", "janvier", "fevrier", "mars", "avril", "mai", "juin", "juillet", "aout", "septembre", "octobre", "novembre", "decembre"};
	
	public static String lire(int n) {

		FichierTexte t = new FichierTexte();
		t.openFileReader(nomFichier);
		String ligne = null;
		for (int i = 0; i < n; i++) {
			ligne = t.readLigne();
		}
		t.closeFileReader();
		return ligne;
	}
	
	public static String getNomFichier(Habitation hab, int mois, int an)
	{	
		String nomFichier = hab.getIdHabitation()+"-"+hab.getUsager().getId()+"-facture-"+tabMois[mois]+"-"+an+".pdf";
		return nomFichier;
	}
	public static String getCheminFichier(Habitation hab, int mois, int an)
	{
		
		String nomDossier = Parametre.getCheminFacturePdf()+"\\"+tabMois[mois];
		String nomFichier = getNomFichier(hab, mois, an);
		String cheminComplet = nomDossier+"\\"+nomFichier;
		return cheminComplet;
	}

	public static String getCheminBd() {
		return lire(2);

	}

	public static String getCheminLeveeATraiter() {
		return lire(4);
	}

	public static String getCheminLeveeLog() {
		return lire(10);
	}

	public static String getCheminLeveeTraites() {
		return lire(6);
	}

	public static String getCheminFacturePdf() {
		return lire(8);
	}
	
	public static String getExtensionFichier(String nomFichier)
	{
		String[] extension = nomFichier.split("\\.");
		return extension[1];
	}
	public static boolean transfertFichier(File source, String destination)
	{
		destination = destination + "\\" + source.getName();
		File cheminDestination = new File(destination);
		if(source.renameTo(cheminDestination))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static int nbLevee()
	{
		String cheminLevee = getCheminLeveeATraiter();
		File f = new File(cheminLevee);
		return f.listFiles().length;
	}
		
		
	}
	
	



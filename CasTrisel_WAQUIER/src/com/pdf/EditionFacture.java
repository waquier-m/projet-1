package com.pdf;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.metier.Habitation;
import com.metier.Levee;
import com.metier.Poubelle;
import com.metier.TypeDechet;
import com.util.AccesData;

public class EditionFacture 
{
	public static void testFacture(int an, int mois)
	{
		
		ArrayList<Habitation> lesHabitations = AccesData.getLesHabitations();
		if(lesHabitations.size() != 0) 
		{
			for(Habitation h : lesHabitations)
			{
					EditionFacture.editionElementfacture(h, an, mois);
			}
		}
	}
	
	public static void editionElementfacture(Habitation h, int an, int mois)
	{
		//Var Usager
		String nomUsager;
		String prenomUsager;
		String adresseRueUsager;
		String adresseVilleUsager;
		String cpUsager;
		String idUsager;
		
		//Var Logement
		String adresseRueHab;
		String cpLogement;
		String adresseVilleHab;
		int nbPersonnes;
		
		//Var Tarif
		double tauxPartFixe;
		
		//Var Poubelle 
		String idPoubelle;
		String libellePoubelle;
		
		//Var Levee
		Date datePesee;
		double poids;
		
		//Var TypeDechet
		double prix;
		
		List<Poubelle> listePoubelle = h.getLesPoubelles();
		
	
		Date actuelle = new Date();
		System.out.println("*****************************************************************************");
		DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
		String dat = dateFormat.format(actuelle);
		
		System.out.println(dat+"\n");
		
		nomUsager = h.getUsager().getNom();
		prenomUsager = h.getUsager().getPrenom();
		adresseRueUsager = h.getUsager().getAdrRueUsager();
		adresseVilleUsager = h.getUsager().getAdrVilleUsager();
		cpUsager = h.getUsager().getCpUsager();
		idUsager = h.getUsager().getId();
		
		System.out.println("Usager concerné" + "\n");
		System.out.println(nomUsager +" "+prenomUsager+ "\n"+adresseRueUsager+"\n"+cpUsager + adresseVilleUsager);
		
		adresseRueHab = h.getAdrRueHab();
		adresseVilleHab = h.getAdrVilleHab();
		cpLogement = h.getCpHab();
		nbPersonnes = h.getNbPersonne();
		
		System.out.println("Adresse du logement concerné :" +"\n");
		System.out.println(adresseRueHab+ "\n" + cpLogement + " " + adresseVilleHab+"\n");
		
		tauxPartFixe = AccesData.getTarif(1);
		int tauxPF = (int) tauxPartFixe;
		int totalHt = tauxPF * nbPersonnes;
		
		System.out.println("Code Usager : " +idUsager);
		System.out.println("Nombre de personnes déclarées : " +nbPersonnes+"\n");
		
		System.out.println("Taux part fixe : " +tauxPartFixe);
		System.out.println("Nombre de personnes : "+nbPersonnes);
		System.out.println("Total HT : "+totalHt);
		
		
		for(Poubelle p : listePoubelle)
		{	
			
			idPoubelle = p.getIdPoubelle();
			libellePoubelle = p.getNature().getLibelle();
			List<Levee> listeLevee = p.getLesLevees();
			prix = p.getNature().getTarif();
			System.out.println("Poubelle : "+idPoubelle);
			System.out.println("Nature des déchets : "+libellePoubelle);
			for(Levee l : listeLevee)
			{
				
				datePesee = l.getLaDate();
				poids = l.getPoids();
				double totalHtPb = poids * prix; 
				double coutTotalHt = p.getCout(an, mois);
				System.out.println("Date de pesée : "+datePesee);
				System.out.println("Nombre de kg :" +poids);
				System.out.println("Prix HT au kg : "+prix);
				System.out.println("Total HT : "+totalHtPb);
				System.out.println("Prix total HT : "+coutTotalHt+"\n");
				
			}
			
			
		}
		double montantTotalHT = h.getCout(an, mois) + totalHt;
		System.out.println("Montant Total HT : "+montantTotalHT);
		double tva = 0.2*totalHt;
		double totalTTC = montantTotalHT + tva;
		
		System.out.println("Montant TVA : ");
		System.out.println("Total à payer : "+totalTTC);
	}
}

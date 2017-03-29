package com.pdf;
import com.util.AccesData;
import com.util.HibernateSession;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.metier.Facture;
import com.metier.Habitation;
import com.metier.Levee;
import com.metier.Poubelle;
import com.metier.TypeDechet;
import com.util.Parametre;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class EditionFacturePDF 
{
	private static  Session s = HibernateSession.getSession();
	
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
		int tarif;
		
		
		List<Poubelle> listePoubelle = h.getLesPoubelles();
		
		/*tauxPartFixe = AccesData.getTarif(1);
		int tauxPF = (int) tauxPartFixe;
		int totalHt = tauxPF * nbPersonnes;
		*/
	
		Date actuelle = new Date();
		
		DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
		String dat = dateFormat.format(actuelle);
		
		
		
		nomUsager = h.getUsager().getNom();
		prenomUsager = h.getUsager().getPrenom();
		adresseRueUsager = h.getUsager().getAdrRueUsager();
		adresseVilleUsager = h.getUsager().getAdrVilleUsager();
		cpUsager = h.getUsager().getCpUsager();
		idUsager = h.getUsager().getId();
		
		
		
		
		adresseRueHab = h.getAdrRueHab();
		adresseVilleHab = h.getAdrVilleHab();
		cpLogement = h.getCpHab();
		nbPersonnes = h.getNbPersonne();
		
		
		tauxPartFixe = AccesData.getTarif(1);
		int tauxPF = (int) tauxPartFixe;
		int totalHt = tauxPF * nbPersonnes;
		
		/*
		tauxPartFixe = tarif.getTarifInd();
		int totalHt = tauxPartFixe * nbPersonnes;
		*/
		
		
		//************************************PDF*********************************************************
		
		Document pdf = new Document ();
		try {
		PdfWriter.getInstance (pdf, new FileOutputStream(Parametre.getCheminFichier(h, mois, an)));
		pdf.open();
		
		

		//date
		Paragraph dateSystem = new Paragraph(dat);
		dateSystem.setAlignment(Element.ALIGN_RIGHT);
		pdf.add(dateSystem);
		
		//logo
		Image logo = Image.getInstance ("trisel.jpg");
		pdf.add (logo);
		
		//nom prenom adresse
		Phrase nomPrenomUsagerPdf = new Phrase(nomUsager +" "+ prenomUsager);
		Paragraph adresseRueUsagerPdf = new Paragraph(adresseRueUsager);
		Phrase cpVilleUsager = new Phrase(cpUsager + " " + adresseVilleUsager);
		Paragraph cpVilleUsagerPdf = new Paragraph();
		Paragraph nomPrenomUsager = new Paragraph();
		cpVilleUsagerPdf.add(cpVilleUsager);
		nomPrenomUsager.add(nomPrenomUsagerPdf);
		nomPrenomUsager.setAlignment(Element.ALIGN_RIGHT);
		adresseRueUsagerPdf.setAlignment(Element.ALIGN_RIGHT);
		cpVilleUsagerPdf.setAlignment(Element.ALIGN_RIGHT);
		pdf.add(nomPrenomUsager);
		pdf.add(adresseRueUsagerPdf);
		pdf.add(cpVilleUsagerPdf);
		
		//Logement
		Paragraph logement = new Paragraph("Adresse du logement concerné : ");
		pdf.add(logement);
		Paragraph espace = new Paragraph("\n");
		pdf.add(espace);
		Paragraph adresseRueHabPdf = new Paragraph(adresseRueHab);
		pdf.add(adresseRueHabPdf);
		Paragraph cpVilleHabPdf = new Paragraph();
		Phrase cpVilleHab = new Phrase(cpLogement + " " +adresseVilleHab);
		cpVilleHabPdf.add(cpVilleHab);
		pdf.add(cpVilleHabPdf);
		
		//code usager et nbpersonnes
		pdf.add(espace);
		Paragraph codeUsagerPdf = new Paragraph("Code usager : "+idUsager);
		pdf.add(codeUsagerPdf);
		Paragraph nbPersonnesPdf = new Paragraph("Nombre de personnes déclarées : "+nbPersonnes);
		pdf.add(nbPersonnesPdf);
		
		
		//Creation de tableau logo/date
		pdf.add(espace);
		PdfPTable tableauTarif = new PdfPTable(3);
		PdfPCell cell1 = new PdfPCell (new Paragraph("Taux part fixe"));
		PdfPCell cell2 = new PdfPCell (new Paragraph("Nombre de personnes"));
		PdfPCell cell3 = new PdfPCell (new Paragraph("Total HT"));
	
		tableauTarif.addCell (cell1);
		tableauTarif.addCell (cell2);
		tableauTarif.addCell (cell3);
		pdf.add (tableauTarif);
		
		PdfPTable tableauTarifValeur = new PdfPTable(3);
		PdfPCell cellV1 = new PdfPCell (new Paragraph(" " +tauxPartFixe));
		PdfPCell cellV2 = new PdfPCell (new Paragraph(" " +nbPersonnes));
		PdfPCell cellV3 = new PdfPCell (new Paragraph(" " +totalHt));
	
		tableauTarifValeur.addCell (cellV1);
		tableauTarifValeur.addCell (cellV2);
		tableauTarifValeur.addCell (cellV3);
		pdf.add (tableauTarifValeur);
		
		
		
		for(Poubelle p : listePoubelle)
		{	
			
			idPoubelle = p.getIdPoubelle();
			libellePoubelle = p.getNature().getLibelle();
			ArrayList<Levee> listeLevee = p.getLesLevees(an, mois);
			prix = p.getNature().getTarif();
			
			//Poubelles 
			pdf.add(espace);
			PdfPTable tableauPoubellePDF = new PdfPTable(1);
			PdfPCell P1 = new PdfPCell (new Phrase("Poubelle : " +idPoubelle + " Nature des déchets : "+libellePoubelle));	
			tableauPoubellePDF.addCell (P1);
			pdf.add (tableauPoubellePDF);

			//Levees 
			PdfPTable tableauLeveesEntete = new PdfPTable(4);
			PdfPCell L1 = new PdfPCell (new Paragraph("Date de pesée"));
			PdfPCell L2 = new PdfPCell (new Paragraph("Nombre de kg"));
			PdfPCell L3 = new PdfPCell (new Paragraph("Prix HT au kg"));
			PdfPCell L4 = new PdfPCell (new Paragraph("Total HT "));
			tableauLeveesEntete.addCell (L1);
			tableauLeveesEntete.addCell (L2);
			tableauLeveesEntete.addCell (L3);
			tableauLeveesEntete.addCell (L4);
			pdf.add (tableauLeveesEntete);
					
			
			double coutTotalHt = p.getCout(an, mois);
			for(Levee l : listeLevee)
			{
				
				datePesee = l.getLaDate();
				poids = l.getPoids();
				double totalHtPb = poids * prix; 
								
				//Levees Valeur
				PdfPTable tableauLeveesValeur = new PdfPTable(4);
				PdfPCell LV1 = new PdfPCell (new Paragraph(" "+ datePesee));
				PdfPCell LV2 = new PdfPCell (new Paragraph(" " +poids));
				PdfPCell LV3 = new PdfPCell (new Paragraph(" "+prix));
				PdfPCell LV4 = new PdfPCell (new Paragraph(" "+totalHtPb));
				tableauLeveesValeur.addCell (LV1);
				tableauLeveesValeur.addCell (LV2);
				tableauLeveesValeur.addCell (LV3);
				tableauLeveesValeur.addCell (LV4);
				pdf.add (tableauLeveesValeur);
			
			}
			
			//Total HT Levees
			PdfPTable tableauTotalHtPoub = new PdfPTable(4);
			PdfPCell TP1 = new PdfPCell (new Phrase(" Total HT "));
			PdfPCell TP2 = new PdfPCell (new Phrase(" "+coutTotalHt));
			TP1.setColspan(3);
			TP1.setHorizontalAlignment (PdfPCell.ALIGN_RIGHT);
			tableauTotalHtPoub.addCell (TP1);
			tableauTotalHtPoub.addCell (TP2);
			pdf.add (tableauTotalHtPoub);
			
		}
		
		double montantTotalHT = h.getCout(an, mois) + totalHt;
		double tva = 0.2*totalHt;
		double totalTTC = montantTotalHT + tva;
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		//TOTAL A PAYER HT
		pdf.add(espace);
		PdfPTable tableauTotalHT = new PdfPTable(4);
		PdfPCell T1 = new PdfPCell (new Paragraph("Total HT "));
		PdfPCell T2 = new PdfPCell (new Paragraph(" " + montantTotalHT));
		T1.setColspan(3);
		T1.setHorizontalAlignment (PdfPCell.ALIGN_RIGHT);
		tableauTotalHT.addCell (T1);
		tableauTotalHT.addCell (T2);
		pdf.add (tableauTotalHT);
		
		//TOTAL A PAYER TVA
		PdfPTable tableauTVA = new PdfPTable(4);
		PdfPCell TV1 = new PdfPCell (new Paragraph("Montant TVA "));
		PdfPCell TV2 = new PdfPCell (new Paragraph(" " + df.format(tva)));
		TV1.setColspan(3);
		TV1.setHorizontalAlignment (PdfPCell.ALIGN_RIGHT);
		tableauTVA.addCell (TV1);
		tableauTVA.addCell (TV2);
		pdf.add (tableauTVA);
		
		//TOTAL A PAYER TVA
		PdfPTable TableauTTC = new PdfPTable(4);
		PdfPCell TTC1 = new PdfPCell (new Paragraph("Total à payer "));
		PdfPCell TTC2 = new PdfPCell (new Paragraph(" " + df.format(totalTTC)));
		TTC1.setColspan(3);
		TTC1.setHorizontalAlignment (PdfPCell.ALIGN_RIGHT);
		TableauTTC.addCell (TTC1);
		TableauTTC.addCell (TTC2);
		pdf.add (TableauTTC);
		
		
		
		
		Runtime.getRuntime().exec("explorer.exe " + Parametre.getCheminFichier(h, mois, an));
		Facture f = new Facture(mois, an, Parametre.getNomFichier(h, mois, an), h.getIdHabitation());
		
		AccesData.ajoutFacture(f);
			
		pdf.close();
		}
		catch (DocumentException e) 
		{
			e.printStackTrace ();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace ();
		}
		catch (IOException ex) 
		{
			ex.printStackTrace();
		}
		
		
		
		
		

		
		
		
		
		//------------------------------------------------------------------------------------------------------------//
		
		
	}
		
		
}

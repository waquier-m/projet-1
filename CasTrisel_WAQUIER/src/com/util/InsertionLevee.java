package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.metier.Levee;

public class InsertionLevee 
{
	/**Traitement d'un fichier texte
	 * @param nomFichier
	 * on donne le nom du fichier a traiter
	 */
	public static void traitementFichierTexte(String nomFichier) {
		FichierTexte fichier = new FichierTexte();
		boolean ouvrirFichier = fichier.openFileReader("pesee.txt");
		Date laDate = null;
		Double poids= null;
		String codePoubelle= null;
		java.util.Date laDateUtil = null;

		if (ouvrirFichier == true) {
			String ligne = fichier.readLigne();
			String[] part = ligne.split(":");
			System.out.println("immatriculation : " + part[0]);
			System.out.println("code chauffeur : " + part[1]);
			System.out.println("date : " + part[2]);

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				laDateUtil = sdf.parse(part[2]);
				while ((ligne = fichier.readLigne()) != null) {
					String partLevee[] = ligne.split(":");
					codePoubelle = partLevee[0];
					System.out.println("code poubelle :" + partLevee[0]);
					poids = Double.parseDouble(partLevee[1]);
					System.out.println("poids : " + poids);
					Levee levee = new Levee(laDateUtil, poids, codePoubelle, part[0], part[1]);
					//LeveeDAO leveeDAO = new LeveeDAO();
					if(AccesData.ajoutLevee(levee) == true)
					{
						System.out.println("Insertion réussie");
					}
					else
					{
						System.out.println("Insertion fail");
					}

					
				}
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
		} else {
			// Problème lecture
			System.out.println("Fichier non trouvé");
		}
		
		fichier.closeFileReader();

	}

	public static void traitementFichierXML(String nomFichier) throws ParseException {
		// déclaration document xml
		Document document = null;
		// déclaration élément racine
		Element racine = null;
		// On crée une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		
		Date laDate = null;
		Double poids= null;
		String codePoubelle= null;
		String immatriculation=null;
		String codeChauffeur=null;
		java.util.Date laDateUtil = null;
		SimpleDateFormat formater;
		formater = new SimpleDateFormat("dd/MM/yyyy");
		
		
		try {

			// On crée un nouveau document JDOM avec en argument le fichier XML
			document = sxb.build(new File("pesee.xml"));
			// On initialise un nouvel élément racine avec l'élément racine du
			// document.
			racine = document.getRootElement();
			
			// parcours

			System.out.print("Camion :  " + "\n");
			System.out.print("immatriculation : " + racine.getChild("immatriculation").getText() + "  " + "\n");
			immatriculation =racine.getChild("immatriculation").getText();
			System.out.print("codeChauffeur : " + racine.getChild("codechauffeur").getText() + "  " + "\n");
			codeChauffeur = racine.getChild("codechauffeur").getText();
			System.out.println("date : " + racine.getChild("date").getText() + "\n");
			laDate = formater.parse(racine.getChild("date").getText());

			List<Element> listLevee = racine.getChildren("levee");
			for (Element e : listLevee) {
				System.out.print("poubelle : " + e.getChild("poubelle").getText() + "  " + "\n");
				poids = Double.parseDouble(e.getChild("poids").getText());
				System.out.print("poids : " + poids + "  " + "\n");
				Levee levee = new Levee(laDateUtil, poids, codePoubelle, immatriculation, codeChauffeur);
				//LeveeDAO leveeDAO = new LeveeDAO();
				if(AccesData.ajoutLevee(levee) == true)
				{
					System.out.println("Insertion réussie");
				}
				else
				{
					System.out.println("Insertion fail");
				}

			}
			
		} catch (JDOMException e2) {

			e2.printStackTrace();
		} catch (IOException e2) {

			e2.printStackTrace();
		}
		

	}
	public static void traitementLevee() 
	{
		String cheminAtraiter = Parametre.getCheminLeveeATraiter();
		String cheminTraites = Parametre.getCheminLeveeTraites();
		String cheminLog = Parametre.getCheminLeveeLog();
		
		File f  = new File(cheminAtraiter);
		
		if((f.list()) == null)
		{
			System.out.println("Aucun fichier a traiter");
		}
		else
		{
			File[] listeFichier = f.listFiles();
			
			
			for(File fichier : listeFichier)
			{
				
				if(fichier.isFile())
				{
					String extensionFichier = Parametre.getExtensionFichier(fichier.getName());
					switch(extensionFichier)
					{
					case "txt":
						InsertionLevee.traitementFichierTexte(fichier.getAbsolutePath());
						Parametre.transfertFichier(fichier, cheminTraites);
						break;
					case "xml":
						InsertionLevee.traitementFichierTexte(fichier.getAbsolutePath());
						Parametre.transfertFichier(fichier, cheminTraites);
						break;
					default :
						System.out.println("Fichier incorrect");
						Parametre.transfertFichier(fichier, cheminLog);
						break;
					}
				}
				
			}
		}
		
	}
}

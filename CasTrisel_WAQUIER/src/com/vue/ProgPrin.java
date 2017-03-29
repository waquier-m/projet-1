package com.vue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.metier.Facture;
import com.metier.Habitation;
import com.metier.Levee;
import com.metier.TypeDechet;
import com.metier.Usager;
import com.pdf.EditionFacture;
import com.pdf.EditionFacturePDF;
import com.util.*;
public class ProgPrin {

	public static void main(String[] args) throws SQLException, ParseException
	{
		//InsertionLevee.traitementFichierTexte("pesee.txt");
		//InsertionLevee.traitementFichierXML("pesee.xml");
		//System.out.println("Chemin BDD : " + Parametre.getCheminBd() + "\n");
		//System.out.println("Chemin a traiter : " + Parametre.getCheminLeveeATraiter() + "\n");
		//System.out.println("Chemin log : " + Parametre.getCheminLeveeLog() + "\n");
		//System.out.println("Chemin traité : " + Parametre.getCheminLeveeTraites() + "\n");
		//System.out.println("Chemin facture : " + Parametre.getCheminFacturePdf() + "\n");
		
		//System.out.println("L'extension est : "+Parametre.getExtensionFichier("pesee.txt") );
		//InsertionLevee.traitementLevee();
		
		/*if(AccesBd.getInstance() == null)
		{
			System.out.println("Connection fail");
		}
		else
		{
			System.out.println("Connection réussie");
		}
		Connection cnx = AccesBd.getInstance();
		ResultSet rs;
		try {
			rs = cnx.createStatement().executeQuery("SELECT * FROM usager");
			while(rs.next())
			{
				System.out.println("IdUsager : " + rs.getString(1)+ " // Nom Usager : " + rs.getString(2) + " // Prenom Usager : " + rs.getString(3));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//Connection cnx = AccesBd.getInstance();
		
		/*TypeDechetDAO typeDechetDAO = new TypeDechetDAO();
		TypeDechet type = typeDechetDAO.find("pla");
		System.out.println(type.toString());
		
		UsagerDAO usager = new UsagerDAO();
		Usager id  = usager.find("usag1");
		System.out.println(id.toString());*/
		
		/*HabitationDAO hab = new HabitationDAO();
		Habitation habitation = hab.find("hab1");
		System.out.println(habitation.toString());
		*/
		
		// ************ EditionFacturePDF.testFacture(2015,7);
		
	/*	// **************FIND*******************
		Session s = HibernateSession.getSession();
		TypeDechet td = (TypeDechet)s.get(TypeDechet.class, "ver");
		System.out.println(td.toString());
		
		// **************RETREIVE*******************
		ArrayList<TypeDechet> listeDechet = (ArrayList<TypeDechet>) s.createQuery("from TypeDechet").list();
		for(TypeDechet typD : listeDechet)
		{
			System.out.println(typD);
		}
		// **************CREATION NOUVEAU TYPE*******************
		TypeDechet td1 = new TypeDechet("pap", "papier", 0.150);
		Transaction t = s.beginTransaction();
		s.save(td1);
		t.commit();
		*/
	
		/*Date date = new Date(2015-07-15);
		Session s = HibernateSession.getSession();
		Levee l = new Levee(date,5,"pb6","AX-789-AF","C120");
		AccesData.ajoutLevee(l);
		 
		 */
		/*Session s = HibernateSession.getSession();
		ArrayList<Habitation> habitation = AccesData.getLesHabitations();
		for(Habitation h : habitation)
		{
			System.out.println(h.toString());
		}
		*/
		/*Facture f = new Facture(1, 7, 2015,"hab1-usag1-facture-juillet-2015.pdf", "hab1");
		AccesData.ajoutFacture(f);
		*/
		
		/*List<Habitation> listeHabitation = AccesData.getLesHabitationsUsager("usag1");
		  for(Habitation h : listeHabitation)
				{
					System.out.println(h.toString());
				}
		*/
		System.out.println(AccesData.getUtilisateur("lequay", "tyty"));

		
		
		//InsertionLevee.traitementFichierTexte("pesee.txt");
		
		
	}

}

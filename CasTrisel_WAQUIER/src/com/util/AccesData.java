package com.util;

import com.metier.Habitation;
import com.metier.Levee;
import com.metier.Tarif;
import com.metier.TypeDechet;
import com.metier.Usager;
import com.metier.Utilisateurs;
import com.metier.Facture;

import java.sql.*; 
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction; 

public class AccesData 
	{ 

private static  Session s = HibernateSession.getSession();

		public static ArrayList<Habitation> getLesHabitations() 
		{ 
			
			ArrayList<Habitation> listeHabitation = (ArrayList<Habitation>) s.createQuery("from Habitation").list();
			return listeHabitation;
		}
		public static boolean ajoutLevee(Levee l)
		{
			boolean retour = false;
			
			Transaction t = s.beginTransaction();
			if(s.save(l)!=null)
			{
				retour = true;
			}
			t.commit();
			return retour;
			
		}
		public static boolean ajoutFacture(Facture f)
		{
			boolean ok = false;
			String hql = "from Facture f where f.anF ="+f.getAnF();
			hql = hql + "and f.moisF = "+f.getMoisF();
			hql = hql +"and f.idHabitation = '"+f.getIdHabitation()+"'";
			Facture existF = (Facture) s.createQuery(hql).uniqueResult();
			if(existF == null)
			{
					try {
						Transaction trans = s.beginTransaction();
						s.save(f);
						trans.commit();
						ok=true;
					}
					catch(HibernateException e){
						e.printStackTrace();
						ok = false;
					}
			}
			return ok;
		}
		public static boolean ajouterControleFacture(Facture f)
		{
			boolean ok = false;
			String hql = "from Facture f where f.anF ="+f.getAnF();
			hql = hql + "and f.moisF = "+f.getMoisF();
			hql = hql +"and f.idHabitation = '"+f.getIdHabitation()+"'";
			Facture existF = (Facture) s.createQuery(hql).uniqueResult();
			if(existF == null)
			{
					try {
						Transaction trans = s.beginTransaction();
						s.save(f);
						trans.commit();
						ok=true;
					}
					catch(HibernateException e){
						ok = false;
					}
			}
			return ok;
		}
		public static List<Habitation> getLesHabitationsUsager(String idUsager) {
			return   s.createQuery("from Habitation h where h.usager.idUsager ='"+ idUsager +"'").list();
		}

		public static Habitation getHabitation(String idHab)
		{
			
			Habitation h = (Habitation)s.get(Habitation.class, idHab);
			return h;
		}
		public static boolean ajoutTypeDechet(TypeDechet typeD)
		{
			boolean retour = false;
			
			Transaction t = s.beginTransaction();
			if(s.save(typeD)!=null)
			{
				retour = true;
			}
			t.commit();
			return retour;
		}
		
		
		public static Usager getUsager(String id)
		{
			return (Usager) s.createQuery("from Usager u where u.idUsager ='"+id+"'").uniqueResult();
		}
		public static List<Usager> getLesUsager()
		{
			return s.createQuery("from Usager").list();
		}
		public static ArrayList<Facture> getLesFactures() 
		{ 
			
			ArrayList<Facture> listeFacture = (ArrayList<Facture>) s.createQuery("from facture").list();
			return listeFacture;
		}
		public static double getTarif(int id)
		{
			Tarif t = (Tarif)s.get(Tarif.class, id);
			double valeur = t.getValeur();
			return valeur;
		}
		public static Utilisateurs getUtilisateur(String login, String mdp)
		{
			return (Utilisateurs) s.createQuery("from Utilisateurs u where u.login ='"+login+"'and u.mdp='"+mdp+"'").uniqueResult();
		}
		public static List<TypeDechet> getLesTypeDechet()
		{
			return s.createQuery("from TypeDechet").list();
		}
		public static boolean updateTarif(TypeDechet typeD)
		{
			boolean ok = false;
			try{

				Transaction t = s.beginTransaction();
				s.update(typeD);
				t.commit();
				ok=true;
			}
			catch(HibernateException e){
				ok = false;
			}
			return ok;
		}

	} 

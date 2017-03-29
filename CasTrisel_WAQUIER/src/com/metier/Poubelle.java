package com.metier;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="poubelle")



public class Poubelle {
	
	@Id
	@Column(name="idPoubelle")
	private String idPoubelle;
	//
	@Column(name="idHabitation")
	private String idHabitation;
	//
	@ManyToOne
	@JoinColumn(name="idTypeDechet")
	private TypeDechet nature;
	//
	@OneToMany
	@JoinColumn(name="idPoubelle")
	private List<Levee> lesLevees;

	public String getIdPoubelle() {
		return idPoubelle;
	}
	

	public void setIdPoubelle(String idPoubelle) {
		this.idPoubelle = idPoubelle;
	}
	
	public Poubelle(String idPoubelle,TypeDechet nature,String idHabitation) {
		super();
		this.idPoubelle = idPoubelle;
		lesLevees = new ArrayList<Levee>();
		this.nature = nature;
		this.idHabitation = idHabitation;

	}

	public String getIdHabitation() {
		return idHabitation;
	}

	public void setIdHabitation(String idHabitation) {
		this.idHabitation = idHabitation;
	}

	public TypeDechet getNature() {
		return nature;
	}

	public void setNature(TypeDechet nature) {
		this.nature = nature;
	}
	public Poubelle()
	{
		super();
	}
	public List getLesLevees() {
		return lesLevees;
	}

	public void setLesLevees(ArrayList lesLevees) {
		this.lesLevees = lesLevees;
	}

	@Override
	public String toString() {
		return "Poubelle [idPoubelle=" + idPoubelle + ", idHabitation=" + idHabitation + ", nature=" + nature
				+ ", lesLevees=" + lesLevees + "]";
	}

	public ArrayList<Levee> getLesLevees(int an, int mois) {
		ArrayList<Levee> lesLeveesAnMois = new ArrayList<Levee>();
		Calendar date = Calendar.getInstance();

		for (Levee l : lesLevees) {
			date.setTime(l.getLaDate());
			int year = date.get(Calendar.YEAR);
			int month = date.get(Calendar.MONTH)+1;
			if ((year == an) && (month == mois)) {
				lesLeveesAnMois.add(l);
			}
		}

		return lesLeveesAnMois;

	}

	public double getCout(int an, int mois) {
		double cout = 0;
		ArrayList<Levee> listeLevee = this.getLesLevees(an, mois);
		System.out.println(lesLevees.size());
		for (Levee l : listeLevee) {
			cout = cout+l.getPoids()*nature.getTarif();
		}
		return cout;
	}

	public boolean addLevee(Levee l) {
		boolean retour;
		if (lesLevees.add(l)) {
			retour = true;
		} else {
			retour = false;
		}

		return retour;
	}

}

package com.metier;
import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="habitation")
//héritage basé sur une seule table avec champ discriminant
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//on donne le nom du champ discriminant dans la base et son type
@DiscriminatorColumn(name="typeH", discriminatorType=DiscriminatorType.INTEGER)
public abstract class Habitation implements Serializable {
	

	@Id
	@Column(name="idHabitation")
	private String idHabitation;
	//
	@Column(name="cpHab")
	private String cpHab;
	//
	@Column(name="adrVilleHab")
	private String adrVilleHab;
	//
	@Column(name="adrRueHab")
	private String adrRueHab;
	//
	@Column(name="nbPersonne")
	private int nbPersonne;
	//
	@ManyToOne
	@JoinColumn(name="idUsager")
	private Usager usager;
	//
	@OneToMany
	@JoinColumn(name="idHabitation")
	private List<Poubelle> lesPoubelles;
	//
	/*@OneToMany
	@JoinColumn(name="idFacture")
	private List<Facture> lesFactures;
	*/
	
	public Habitation(String idHabitation, String adrRueHab, String cpHab, String adrVilleHab, int nbPersonne, Usager usager) {
		super();
		this.idHabitation = idHabitation;
		this.adrRueHab = adrRueHab;
		this.cpHab = cpHab;
		this.adrVilleHab = adrVilleHab;
		this.nbPersonne = nbPersonne;
		this.usager = usager;
		lesPoubelles = new ArrayList<Poubelle>();
		//lesFactures = new ArrayList<Facture>();
	}
	public Habitation()
	{
		super();
	}
	public Usager getUsager() {
		return usager;
	}
	public void setUsager(Usager usager) {
		this.usager = usager;
	}
	public List getLesPoubelles() {
		return lesPoubelles;
	}
	public int getNbPoubelles() {
		return lesPoubelles.size();
	}
	/*public List getLesFactures() {
		return lesFactures;
	}
	public void setLesFactures(ArrayList lesFactures) {
		this.lesFactures = lesFactures;
	}*/
	public void setLesPoubelles(ArrayList lesPoubelles) {
		this.lesPoubelles = lesPoubelles;
	}
	
	@Override
	public String toString() {
		return "Habitation [idHabitation=" + idHabitation + ", adrRueHab=" + adrRueHab + ", cpHab=" + cpHab
				+ ", adrVilleHab=" + adrVilleHab + ", nbPersonne=" + nbPersonne + ", usager=" + usager + ", lesPoubelles=" + lesPoubelles + "]";
	}
	public String getIdHabitation() {
		return idHabitation;
	}
	public void setIdHabitation(String idHabitation) {
		this.idHabitation = idHabitation;
	}
	public String getAdrRueHab() {
		return adrRueHab;
	}
	public void setAdrRueHab(String adrRueHab) {
		this.adrRueHab = adrRueHab;
	}
	public String getCpHab() {
		return cpHab;
	}
	public void setCpHab(String cpHab) {
		this.cpHab = cpHab;
	}
	public String getAdrVilleHab() {
		return adrVilleHab;
	}
	public void setAdrVilleHab(String adrVilleHab) {
		this.adrVilleHab = adrVilleHab;
	}
	public int getNbPersonne() {
		return nbPersonne;
	}
	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}
	
	public double getCout(int an, int mois) {
		double cout = 0;
		for(Poubelle p : lesPoubelles)
		{
			cout = cout + p.getCout(an,mois);
		}
		return cout;
	}
	public boolean addPoubelle(Poubelle p)
	{
		boolean retour;
		if(lesPoubelles.add(p))
		{
			retour = true;
		}
		else
		{
			retour = false;
		}
				
		return retour;
	}
	/*public boolean addFacture(Facture f)
	{
		boolean retour;
		if(lesFactures.add(f))
		{
			retour = true;
		}
		else
		{
			retour = false;
		}
				
		return retour;
	}*/
	


}

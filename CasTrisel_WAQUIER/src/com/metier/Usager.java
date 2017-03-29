package com.metier;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="usager")

public class Usager {
	
	@Id
	@Column(name="idUsager")
	private String idUsager;
	//
	@Column(name="nom")
	private String nom;
	//
	@Column(name="prenom")
	private String prenom;
	//
	@Column(name="adrRueUsager")
	private String adrRueUsager;
	//
	@Column(name="cpUsager")
	private String cpUsager;
	//
	@Column(name="adrVilleUsager")
	private String adrVilleUsager;
	//
	@OneToMany
	@JoinColumn(name="idHabitation")
	private List<Habitation> lesHabitations;

@Override
public String toString() {
	return "Usager [id=" + idUsager + ", nom=" + nom + ", prenom=" + prenom + ", adrRueUsager=" + adrRueUsager + ", cpUsager="
			+ cpUsager + ", adrVilleUsager=" + adrVilleUsager +"]";
}
public Usager()
{
	super();
}
public String getId() {
	return idUsager;
}
public void setId(String id) {
	this.idUsager = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getAdrRueUsager() {
	return adrRueUsager;
}
public void setAdrRueUsager(String adrRueUsager) {
	this.adrRueUsager = adrRueUsager;
}
public String getCpUsager() {
	return cpUsager;
}
public void setCpUsager(String cpUsager) {
	this.cpUsager = cpUsager;
}
public String getAdrVilleUsager() {
	return adrVilleUsager;
}
public void setAdrVilleUsager(String adrVilleUsager) {
	this.adrVilleUsager = adrVilleUsager;
}
public List getLesHabitations() {
	return lesHabitations;
}
public void setLesHabitations(ArrayList lesHabitations) {
	this.lesHabitations = lesHabitations;
}
public Usager(String id, String nom, String prenom, String adrRueUsager, String cpUsager, String adrVilleUsager) {
	super();
	this.idUsager = id;
	this.nom = nom;
	this.prenom = prenom;
	this.adrRueUsager = adrRueUsager;
	this.cpUsager = cpUsager;
	this.adrVilleUsager = adrVilleUsager;
	lesHabitations = new ArrayList<Habitation>();
}
public boolean AjoutHabitation(Habitation h)
{
	boolean retour;
	if(lesHabitations.add(h))
	{
		retour = true;
	}
	else
	{
		retour = false;
	}
			
	return retour;
}
public boolean SupprimerHabitation(Habitation h)
{
	boolean retour;
	if(lesHabitations.remove(h))
	{
		retour = true;
	}
	else
	{
		retour = false;
	}
			
	return retour;
}



}

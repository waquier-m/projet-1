package com.metier;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
@Entity
@Table(name="levee")

public class Levee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idLevee")
	private int idLevee;
	
	//private int idLevee;
	@Column(name="laDate")
	private Date laDate;
	//
	@Column(name="poids")
	private Double poids;
	//
	@Column(name="idPoubelle")
	private String idPoubelle;
	//
	@Column(name="immatriculation")
	private String immatriculation;
	//
	private String idChauffeur;
	@Column(name="idChauffeur")
	@Override
	public String toString() {
		return "Levee [idLevee=" + idLevee + ", laDate=" + laDate + ", poids=" + poids + ", idPoubelle=" + idPoubelle
				+ ", immatriculation=" + immatriculation + ", idChauffeur=" + idChauffeur + "]";
	}
	public Levee()
	{
		super();
	}
	public int getIdLevee() {
		return idLevee;
	}
	public void setIdLevee(int idLevee) {
		this.idLevee = idLevee;
	}
	public Date getLaDate() {
		return laDate;
	}
	public void setLaDate(Date laDate) {
		this.laDate = laDate;
	}
	public Double getPoids() {
		return poids;
	}
	public void setPoids(Double poids) {
		this.poids = poids;
	}
	public String getIdPoubelle() {
		return idPoubelle;
	}
	public void setIdPoubelle(String idPoubelle) {
		this.idPoubelle = idPoubelle;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	public String getIdChauffeur() {
		return idChauffeur;
	}
	public void setIdChauffeur(String idChauffeur) {
		this.idChauffeur = idChauffeur;
	}
	public Levee(int idLevee,Date laDate, double poids, String idPoubelle, String immatriculation, String idChauffeur) {
		super();
		this.idLevee = idLevee;
		this.laDate = laDate;
		this.poids = poids;
		this.idPoubelle = idPoubelle;
		this.immatriculation = immatriculation;
		this.idChauffeur = idChauffeur;
	}
	public Levee(Date laDate,double poids,String idPoubelle, String immatriculation, String idChauffeur)
	{
		super();
		this.laDate = laDate;
		this.poids = poids;
		this.idPoubelle = idPoubelle;
		this.immatriculation = immatriculation;
		this.idChauffeur = idChauffeur;
	}
}
	
	


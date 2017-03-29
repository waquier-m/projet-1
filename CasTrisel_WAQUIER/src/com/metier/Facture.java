package com.metier;
import javax.persistence.*;
@Entity
@Table(name="facture")
public class Facture {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idFacture")
	private int idFacture;
	//
	//
	@Column(name="moisF")
	private int moisF;
	//
	@Column(name="anF")
	private int anF;
	//
	@Column(name="idHabitation")
	private String idHabitation;
	
	
	//
	@Column(name="nomFacture")
	private String nomFacture;
	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture + ", moisF=" + moisF + ", anF=" + anF + ", nomFacture=" + nomFacture
				+ "]";
	}
	public Facture()
	{
		super();
	}
	public Facture(int idFacture, int moisF, int anF, String nomFacture, String idHabitation) {
		super();
		this.idFacture = idFacture;
		this.moisF = moisF;
		this.anF = anF;
		this.nomFacture = nomFacture;
		this.idHabitation = idHabitation;
	}
	public Facture(int moisF, int anF, String nomFacture, String idHabitation) {
		super();
		this.moisF = moisF;
		this.anF = anF;
		this.nomFacture = nomFacture;
		this.idHabitation = idHabitation;
	}
	public int getIdFacture() {
		return idFacture;
	}
	public String getIdHabitation() {
		return idHabitation;
	}
	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}
	public int getMoisF() {
		return moisF;
	}
	public void setMoisF(int moisF) {
		this.moisF = moisF;
	}
	public int getAnF() {
		return anF;
	}
	public void setAnF(int anF) {
		this.anF = anF;
	}
	public String getNomFacture() {
		return nomFacture;
	}
	public void setNomFacture(String nomFacture) {
		this.nomFacture = nomFacture;
	}

	

}

package com.metier;

import java.util.Date;

public class Camion {
	private String immatriculation;
	@Override
	public String toString() {
		return "Camion [immatriculation=" + immatriculation + ", dateMiseEnCirculation=" + dateMiseEnCirculation + "]";
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	public Date getDateMiseEnCirculation() {
		return dateMiseEnCirculation;
	}
	public void setDateMiseEnCirculation(Date dateMiseEnCirculation) {
		this.dateMiseEnCirculation = dateMiseEnCirculation;
	}
	public Camion(String immatriculation, Date dateMiseEnCirculation) {
		super();
		this.immatriculation = immatriculation;
		this.dateMiseEnCirculation = dateMiseEnCirculation;
	}
	private Date dateMiseEnCirculation;
	

}

package com.vue;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import com.metier.*;
import com.util.AccesData;
public class ModeleListeHabitation extends AbstractTableModel {
	private String[] entetes = { "idHabitation", "adresse rue", "code postal", "adresse ville", "nombre de poubelles"};
	private List<Habitation> listeHabitationUsager;
	public ModeleListeHabitation(String idUsager) {
		listeHabitationUsager = AccesData.getLesHabitationsUsager(idUsager);
		}
	@Override
	public int getRowCount() {
		return listeHabitationUsager.size();
	}
	@Override
	public int getColumnCount() {
		return entetes.length;
	}
	@Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return listeHabitationUsager.get(rowIndex).getIdHabitation();
		case 1:
		return listeHabitationUsager.get(rowIndex).getAdrRueHab();
		case 2:
			return listeHabitationUsager.get(rowIndex).getCpHab();
		case 3:
			return listeHabitationUsager.get(rowIndex).getAdrVilleHab();
		case 4:
			return listeHabitationUsager.get(rowIndex).getNbPoubelles();
		
		default:
			throw new IllegalArgumentException();
		}
	}
}


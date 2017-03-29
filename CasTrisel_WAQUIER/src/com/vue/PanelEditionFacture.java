package com.vue;

import javax.swing.JPanel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.pdf.EditionFacturePDF;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import com.util.InsertionLevee;
import com.util.Traitement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelEditionFacture extends JPanel implements PropertyChangeListener{

	private int an;
	private int mois;
	

	/**
	 * Create the panel.
	 */
	
	public int getYear(){
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.YEAR);
	}
	public int getMonth(){
		  Calendar calendar = Calendar.getInstance();
		  return calendar.get(Calendar.MONTH);
	}

	
	public PanelEditionFacture() {
		setLayout(null);
		
		an = getYear();
		mois  = getMonth() + 1;// + 1 car mois de 0 à 11 et non pas de 1 = 12

		
		JButton btnLancerEdition = new JButton("Lancer Edition");
		btnLancerEdition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditionFacturePDF.testFacture(an,mois);
				afficheMessage("Facturation ok");
			}
		});
		btnLancerEdition.setBounds(100, 190, 168, 23);
		add(btnLancerEdition);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setBounds(100, 96, 97, 20);
		add(monthChooser);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(221, 96, 47, 20);
		add(yearChooser);
		
		
		

	}


	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("year")){
			an = (Integer)evt.getNewValue();
		}
		if(evt.getPropertyName().equals("month")){
			mois  = (Integer)evt.getNewValue() + 1;
		}

		
	}
	private void afficheMessage(String message)
	{
		JOptionPane.showMessageDialog(null,message);
	}
}

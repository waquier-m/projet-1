package com.vue;

import javax.swing.JPanel;

import com.util.InsertionLevee;
import com.util.Parametre;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelLevee extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelLevee() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Il y a  " + Parametre.nbLevee() + " fichier(s) à traiter");
		lblNewLabel.setBounds(142, 88, 195, 14);
		add(lblNewLabel);
		
		JButton btnLancer = new JButton("Lancer");
		btnLancer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertionLevee.traitementLevee();
				afficheMessage("Mise à jour effectuée");
			}
		});
		btnLancer.setBounds(153, 145, 89, 23);
		add(btnLancer);
		

	}
	private void afficheMessage(String message)
	{
		JOptionPane.showMessageDialog(null,message);
	}

}

package com.vue;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.metier.TypeDechet;
import com.util.AccesData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAjoutDechet extends JPanel {
	private JTextField textField_CodeTypeDechet;
	private JTextField textField_LibelleDechet;
	private JTextField textField_Tarif;
	private String idTypeDechet;
	private String libelleDechet;
	private double tarifDechet;

	/**
	 * Create the panel.
	 */
	public PanelAjoutDechet() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Saisie d'un nouveau type de d\u00E9chet");
		lblNewLabel.setBounds(140, 56, 182, 21);
		add(lblNewLabel);
		
		JLabel lblCodeTypeDchet = new JLabel("Code type d\u00E9chet");
		lblCodeTypeDchet.setBounds(28, 124, 117, 14);
		add(lblCodeTypeDchet);
		
		JLabel lblLibellDchet = new JLabel("Libell\u00E9 d\u00E9chet");
		lblLibellDchet.setBounds(30, 167, 77, 14);
		add(lblLibellDchet);
		
		JLabel lblTarifAuKg = new JLabel("Tarif au kg");
		lblTarifAuKg.setBounds(28, 210, 79, 14);
		add(lblTarifAuKg);
		
		textField_CodeTypeDechet = new JTextField();
		textField_CodeTypeDechet.setBounds(160, 121, 86, 20);
		add(textField_CodeTypeDechet);
		textField_CodeTypeDechet.setColumns(10);
		
		textField_LibelleDechet = new JTextField();
		textField_LibelleDechet.setBounds(160, 164, 86, 20);
		add(textField_LibelleDechet);
		textField_LibelleDechet.setColumns(10);
		
		textField_Tarif = new JTextField();
		textField_Tarif.setBounds(160, 207, 86, 20);
		add(textField_Tarif);
		textField_Tarif.setColumns(10);
		
		JButton btnNewButton_Valider = new JButton("Valider");
		btnNewButton_Valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idTypeDechet = textField_CodeTypeDechet.getText();
				libelleDechet = textField_LibelleDechet.getText();
				
				try {
					tarifDechet = Double.parseDouble(textField_Tarif.getText());
				} catch (NumberFormatException nfe) {
					afficheMessage("Le tarif doit être un nombre" );
				    textField_Tarif.requestFocus();
				}
				if(idTypeDechet.equals(""))
				{
					afficheMessage("Saisie du code type dechet obligatoire");
					textField_CodeTypeDechet.requestFocus();
				}
				else if(idTypeDechet.length()!=3)
				{
					afficheMessage("La taille du code doit etre de 3 caracteres");
					textField_CodeTypeDechet.requestFocus();
				}
				if(libelleDechet.equals(""))
				{
					afficheMessage("Saisie du libelle dechet obligatoire");
					textField_LibelleDechet.requestFocus();
				}
				if(tarifDechet==-1)
				{
					afficheMessage("Saisie du tarif dechet obligatoire");
					textField_Tarif.requestFocus();
				}
				else
				{
					TypeDechet typeD = new TypeDechet(idTypeDechet, libelleDechet, tarifDechet);
					if(AccesData.ajoutTypeDechet(typeD))
					{
						afficheMessage("insertion ok");
					}
					else
					{
						afficheMessage("Le type dechet existe deja");
					}
				}
				
			}
		});
		btnNewButton_Valider.setBounds(83, 254, 89, 23);
		add(btnNewButton_Valider);
		
		JButton btnNewButton_Annuler = new JButton("Annuler");
		btnNewButton_Annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_CodeTypeDechet.setText("");
				textField_LibelleDechet.setText("");
				textField_Tarif.setText("");
				textField_CodeTypeDechet.requestFocus();
			}
		});
		btnNewButton_Annuler.setBounds(230, 254, 89, 23);
		add(btnNewButton_Annuler);

	}
	private void afficheMessage(String message)
	{
		JOptionPane.showMessageDialog(null,message);
	}
}

package com.vue;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.metier.Tarif;
import com.metier.TypeDechet;
import com.metier.Usager;
import com.util.AccesData;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelMiseAjourTarif extends JPanel {
	private JTextField textField_TarifActuel;
	private JTextField textField_NouveauTarif;
	private List<TypeDechet> listeTypeDechet;
	private String idTypeDechet;
	private String libelleDechet;
	private double tarifActuel;
	private double tarifMaj;
	private int indexComboBox;
	private TypeDechet typeD;

	/**
	 * Create the panel.
	 */
	public PanelMiseAjourTarif() {
		setLayout(null);
		listeTypeDechet = AccesData.getLesTypeDechet();
		
		JLabel lblNewLabel = new JLabel("Mise \u00E0 jour taif par type de d\u00E9chet");
		lblNewLabel.setBounds(132, 27, 202, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Type d\u00E9chet");
		lblNewLabel_1.setBounds(35, 101, 68, 14);
		add(lblNewLabel_1);
		
		JLabel lblTarifActuel = new JLabel("Tarif actuel");
		lblTarifActuel.setBounds(35, 139, 97, 14);
		add(lblTarifActuel);
		
		JLabel lblNewLabel_2 = new JLabel("Nouveau tarif");
		lblNewLabel_2.setBounds(35, 178, 68, 14);
		add(lblNewLabel_2);
		
		JComboBox comboBox_TypeDechet = new JComboBox();
		for(TypeDechet typeD:listeTypeDechet)
		{
			comboBox_TypeDechet.addItem(typeD.getIdTypeDechet()+"-"+typeD.getLibelle());
			idTypeDechet = typeD.getIdTypeDechet();
			libelleDechet = typeD.getLibelle();
			
		}
		comboBox_TypeDechet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indexComboBox = comboBox_TypeDechet.getSelectedIndex();
				if(indexComboBox!=-1)
				{
					afficheTarifActuel(indexComboBox);
				}
			}
		});
		comboBox_TypeDechet.setBounds(148, 98, 167, 20);
		add(comboBox_TypeDechet);
		
		
		
		textField_TarifActuel = new JTextField();
		textField_TarifActuel.setBounds(146, 136, 169, 20);
		add(textField_TarifActuel);
		textField_TarifActuel.setColumns(10);
		textField_TarifActuel.setEnabled(false);
		
		textField_NouveauTarif = new JTextField();
		textField_NouveauTarif.setBounds(148, 175, 167, 20);
		add(textField_NouveauTarif);
		textField_NouveauTarif.setColumns(10);
		
		JButton btnNewButton_Valider = new JButton("Valider");
		btnNewButton_Valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//tarifActuel=Double.parseDouble(textField_TarifActuel.getText());
				try {
					tarifMaj = Double.parseDouble(textField_NouveauTarif.getText());
				} catch (NumberFormatException nfe) {
					afficheMessage("Le tarif doit être un nombre" );
					textField_NouveauTarif.requestFocus();
				}
				if(tarifMaj==-1)
				{
					afficheMessage("Saisie du nouveau tarif obligatoire");
					textField_NouveauTarif.requestFocus();
				}
				else
				{
					typeD=listeTypeDechet.get(comboBox_TypeDechet.getSelectedIndex());
					typeD.setTarif(tarifMaj);
					if(AccesData.updateTarif(typeD))
					{
						afficheMessage("mise a jour ok");
						afficheTarifActuel(indexComboBox);
					}
					else
					{
						afficheMessage("probleme mise a jour");
					}
				}
			}
		});
		btnNewButton_Valider.setBounds(80, 239, 89, 23);
		add(btnNewButton_Valider);
		
		JButton btnNewButton_Annuler = new JButton("Annuler");
		btnNewButton_Annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_NouveauTarif.setText("");
				textField_NouveauTarif.requestFocus();
			}
		});
		btnNewButton_Annuler.setBounds(245, 239, 89, 23);
		add(btnNewButton_Annuler);
		
		
		

	}
	private void afficheMessage(String message)
	{
		JOptionPane.showMessageDialog(null,message);
	}
	public void afficheTarifActuel(int index)
	{
		textField_TarifActuel.setText(String.valueOf(listeTypeDechet.get(indexComboBox).getTarif()));
	}
}

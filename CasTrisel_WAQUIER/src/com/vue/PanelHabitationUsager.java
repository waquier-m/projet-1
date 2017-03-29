package com.vue;

import javax.swing.JPanel;

import com.metier.Usager;
import com.util.AccesData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.List;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class PanelHabitationUsager extends JPanel {

	private List<Usager> listeUsager;
	private JTable table;
	private int indexComboBox;

	/**
	 * Create the panel.
	 */
	public PanelHabitationUsager() {
		setLayout(null);
		listeUsager=AccesData.getLesUsager();
		JLabel lblNewLabel_selectUsager = new JLabel("Selectionner usager");
		lblNewLabel_selectUsager.setBounds(47, 96, 138, 14);
		add(lblNewLabel_selectUsager);
		
		JComboBox comboBox_Usager = new JComboBox();
		comboBox_Usager.addActionListener(new ActionListener() {
			private ModeleListeHabitation modele;

			public void actionPerformed(ActionEvent arg0) {
				indexComboBox = comboBox_Usager.getSelectedIndex();
				if(comboBox_Usager.getSelectedIndex()!=-1)
				{
					System.out.println((listeUsager.get(comboBox_Usager.getSelectedIndex()).getId()));
					modele = new ModeleListeHabitation(listeUsager.get(comboBox_Usager.getSelectedIndex()).getId());
					table.setModel(modele);
					
					if(AccesData.getLesHabitationsUsager(listeUsager.get(indexComboBox).getId()).size() == 0)
					{
						afficheMessage("Aucunes habitations");
						((TableColumn) table.getColumnModel()).setPreferredWidth(180);
						((TableColumn) table.getColumnModel()).setPreferredWidth(40);
						((TableColumn) table.getColumnModel()).setPreferredWidth(80);
						table.getColumn(0).setPreferredWidth(100);
						JTableRenderer rend = new JTableRenderer();
						for(int i=0; i<table.getColumnModel().getColumnCount();i++)
						{
							table.getColumnModel().getColumn(i).setCellRenderer(rend);
						}
						table.revalidate();
					}
						
				}
			}
		});
		comboBox_Usager.setBounds(181, 93, 222, 20);
		add(comboBox_Usager);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 165, 379, 109);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		for(Usager u:listeUsager)
		{
			comboBox_Usager.addItem(u.getId()+"-"+u.getNom()+"-"+u.getPrenom());
		}

	}
	private void afficheMessage(String message)
	{
		JOptionPane.showMessageDialog(null,message);
	}
}

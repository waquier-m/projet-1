package com.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.metier.Utilisateurs;
import com.util.AccesData;
import com.util.InsertionLevee;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class MenuPrin extends JFrame {

	private JPanel contentPane;
	private JTextField textField_login;
	protected String login;
	protected String mdp;
	private JPasswordField passwordField_mdp;
	private JMenu mnNewMenu_fichier;
	private JMenu mnNewMenu_levee;
	private JMenu mnNewMenu_facture;
	private JMenu mnNewMenu_consultation;
	private JMenu mnNewMenu_DonneesDeBase;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrin frame = new MenuPrin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private void insertionLevee() {
		// on affecte le panel de la fenêtre
		// avec une instance de PanelLevee
		this.setContentPane(new PanelLevee());
		// mets à jour le formulaire
		this.revalidate();
	}
	private void editionFacture() {
		// on affecte le panel de la fenêtre
		// avec une instance de PanelLevee
		this.setContentPane(new PanelEditionFacture());
		// mets à jour le formulaire
		this.revalidate();
	}
	private void habitationUsager() {
		this.setContentPane(new PanelHabitationUsager());
		this.revalidate();
	}
	private void ajoutDechet() {
		this.setContentPane(new PanelAjoutDechet());
		this.revalidate();
	}
	private void majTarif() {
		this.setContentPane(new PanelMiseAjourTarif());
		this.revalidate();
	}
	public MenuPrin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Gestion Poubelles");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu_fichier = new JMenu("Fichier");
		menuBar.add(mnNewMenu_fichier);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Quitter");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu_fichier.add(mntmNewMenuItem);
		
		mnNewMenu_levee = new JMenu("Levee");
		menuBar.add(mnNewMenu_levee);
		
		JMenuItem mntmInsertionLevee = new JMenuItem("Insertion Levee");
		mntmInsertionLevee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertionLevee();		
			}
		});
		mnNewMenu_levee.add(mntmInsertionLevee);
		
		mnNewMenu_facture = new JMenu("Facture");
		menuBar.add(mnNewMenu_facture);
		
		JMenuItem mntmGenerationFacture = new JMenuItem("Generation Facture");
		mntmGenerationFacture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editionFacture();
			}
		});
		mnNewMenu_facture.add(mntmGenerationFacture);
		
		mnNewMenu_consultation = new JMenu("Consultation");
		menuBar.add(mnNewMenu_consultation);
		
		JMenuItem mntmNewMenuItem_habUsager = new JMenuItem("Habitations par usager");
		mntmNewMenuItem_habUsager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				habitationUsager();
			}
		});
		mnNewMenu_consultation.add(mntmNewMenuItem_habUsager);
		
		mnNewMenu_DonneesDeBase = new JMenu("Donnees de base");
		menuBar.add(mnNewMenu_DonneesDeBase);
		
		JMenuItem mntmNewMenuItem_AjoutTypeDechet = new JMenuItem("Ajout type dechet");
		mntmNewMenuItem_AjoutTypeDechet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ajoutDechet();
			}
		});
		mnNewMenu_DonneesDeBase.add(mntmNewMenuItem_AjoutTypeDechet);
		
		JMenuItem mntmNewMenuItem_majTarif = new JMenuItem("Mise a jour tarif");
		mntmNewMenuItem_majTarif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				majTarif();
			}
		});
		mnNewMenu_DonneesDeBase.add(mntmNewMenuItem_majTarif);
		
		JPanel panel = new JPanel();
		setContentPane(panel);
		panel.setBounds(0, 0, 305, 19);
		panel.setLayout(null);
		
		JLabel lblNewLabel_login = new JLabel("Login");
		lblNewLabel_login.setBounds(69, 82, 46, 14);
		panel.add(lblNewLabel_login);
		
		JLabel lblMdp = new JLabel("Mot de passe");
		lblMdp.setBounds(69, 131, 83, 14);
		panel.add(lblMdp);
		
		textField_login = new JTextField();
		textField_login.setBounds(199, 79, 86, 20);
		panel.add(textField_login);
		textField_login.setColumns(10);
		

		passwordField_mdp = new JPasswordField();
		passwordField_mdp.setBounds(199, 128, 86, 20);
		panel.add(passwordField_mdp);
		
		JButton btnNewButton_valider = new JButton("Valider");
		btnNewButton_valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = textField_login.getText();
				String mdp = new String(passwordField_mdp.getPassword());
				Utilisateurs u = AccesData.getUtilisateur(login, mdp); 
				if(u!= null)
				{
					paramNiveau(u.getNiveau());
					affichageFondEcran(u.getNomUtilisateur());
				}
				else
				{
					afficheMessage("Erreur d'authentification");
					textField_login.requestFocus();

				}
				
				
			}
		});
		
		btnNewButton_valider.setBounds(196, 177, 89, 23);
		panel.add(btnNewButton_valider);
		
	}
	public void paramNiveau(int niveau)
	{
		switch(niveau) {
		case 1 :{
			mnNewMenu_fichier.setEnabled(true);
			mnNewMenu_levee.setEnabled(true);
			mnNewMenu_facture.setEnabled(true);
			mnNewMenu_consultation.setEnabled(true);
			mnNewMenu_DonneesDeBase.setEnabled(true);
			break;
		}
		case 2:{
			mnNewMenu_fichier.setEnabled(false);
			mnNewMenu_levee.setEnabled(false);
			mnNewMenu_facture.setEnabled(true);
			mnNewMenu_consultation.setEnabled(false);
			mnNewMenu_DonneesDeBase.setEnabled(false);
			break;
		}
		case 3:{
			mnNewMenu_fichier.setEnabled(false);
			mnNewMenu_levee.setEnabled(true);
			mnNewMenu_facture.setEnabled(false);
			mnNewMenu_consultation.setEnabled(false);
			mnNewMenu_DonneesDeBase.setEnabled(false);
			break;
		}
		default :{
			mnNewMenu_fichier.setEnabled(false);
			mnNewMenu_levee.setEnabled(false);
			mnNewMenu_facture.setEnabled(false);
			mnNewMenu_consultation.setEnabled(false);
			mnNewMenu_DonneesDeBase.setEnabled(false);
			break;
		}
		}
	}
	private void afficheMessage(String message)
	{
		JOptionPane.showMessageDialog(null,message);
	}
	private void affichageFondEcran(String nomUtilisateur)
	{
		this.setContentPane(new PanelFondEcran(nomUtilisateur));
		this.revalidate();
	}
}

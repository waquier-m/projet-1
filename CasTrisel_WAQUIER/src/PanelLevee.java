import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.util.InsertionLevee;

import com.util.*;
public class PanelLevee extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelLevee() {
				
		// initialisation label de la zone de texte
		String textelabel = " Il y a  " + Parametre.nbLevee() + " fichier(s) � traiter";
		JLabel lblInfo = new JLabel(textelabel);

		// d�sactivation du bouton si pas de fichier � traiter
		JComponent btnLancer;
		if (Parametre.nbLevee() == 0) {
			btnLancer.setEnabled(false);
			}
		
		// proc�dure �v�nementielle sur bouton qui lance l'insertion
		 
		
		
		
		

}
private void afficheMessage(String message)
{
	JOptionPane.showMessageDialog(null,message);
}

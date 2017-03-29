package com.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FichierTexte {
	// buffer de lecture
	private BufferedReader br;
	// buffer d'�criture
	private BufferedWriter bw;
	public FichierTexte()
	{
		br=null;
		bw=null;
	}
	
	/**
	 * ouvre un fichier en lecture
	 * @param nom
	 * on donne le fichier concern�
	 * @return boolean
	 * a true si l'ouverture r�ussie, false sinon
	 */
	public boolean openFileReader(String nom)
	{
		boolean open;
		FileInputStream fichier=null;
		String ligne=null;
		try
		{
			fichier=new FileInputStream(new File(nom));
			br=new BufferedReader(new InputStreamReader(fichier));
			open=true;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("pb ouverture");
			open=false;
		}
		return open;
	}
	/**
	 * ouvre un fichier en �criture
	 * @param nom
	 * nom du fichier concern�
	 * @return boolean
	 * a true si l'ouverture r�ussie, false sinon
	 */
	public boolean openFileWriter(String nom)
	{ 
		boolean open;
		FileOutputStream fichier=null;
		try
		{
			fichier=new FileOutputStream(nom);
			bw=new BufferedWriter(new OutputStreamWriter(fichier));
			open=true;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("pb ouverture");
			open=false;
		}
		return open;
	}
	/**
	 * fermeture du flux d'�criture
	 * @return boolean
	 * true si la fermeture r�ussie, false sinon
	 */
	public boolean closeFileWriter()
	{
		boolean ok = true;
		try
		{
			bw.close();
		}
		catch (IOException e)
		{
			ok = false;
		}
		return ok;
	}
	
	public void closeFileReader()
	{
		try
		{
			br.close();}
		catch (IOException e)
		{
			System.out.println("pb fermeture");
		}
	}
	/**
	 * �criture d'une ligne
	 * @param ligne
	 * on fournit la ligne a �crire en param�tre
	 */
	public void writeLigne(String ligne)
	{
		try
		{
			bw.write(ligne+"\n");
		}
		catch (IOException e)
		{
			System.out.println("pb ecriture");
		}
	}
	/**
	 * lecture d'une ligne
	 * @return la ligne lue
	 */
	public String readLigne()
	{
		String ligne=null;
		try
		{
			ligne= br.readLine();
		}
		catch (IOException e)
		{
			System.out.println("pb lecture");
		}
		return ligne;
	}
}
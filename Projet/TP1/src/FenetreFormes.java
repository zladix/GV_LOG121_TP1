/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: FenetreFormes.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-05-03 Version initiale
*******************************************************/  

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

/**
 * Cette fen�tre g�re l'affichage des formes 
 * @author Patrice Boucher
 * 2013/05/04
 */
public class FenetreFormes extends JComponent{
	
	private static final long serialVersionUID = -2262235643903749505L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final Dimension dimension = new Dimension(500,500);
	public OrganiseForme org = new OrganiseForme();
	/**
	 * Constructeur
	 */
	public FenetreFormes(){
		//... 
	}
	
	/*
	 * Affiche la liste de formes 
	 */
	@Override 
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Forme[] tabForme = org.getTabForme();
		
		if(tabForme[0] != null)
		{
			// Testing...
			for(int i = 0;i<org.getPos();i++)
			{
				tabForme[i].dessiner(g);
			}
		}
	}
	
	/**
	 * Permet d'ajouter les formes dans un tableau qui sont envoy� par l'observateur
	 * @param sForme cha�ne de caract�re re�u par le serveur
	 */
	public void initialiserTabForme(String sForme){
		
		CreateurForme crea = new CreateurForme();
		Forme maForme = crea.creerForme(sForme);
		org.AjoutForme(maForme);
		repaint();
		
	}
	/*
	 * Le Layout qui utilise (contient) FenetreFormes doit réserver 
	 * l'espace nécessaire à son affichage
	 */
	@Override 
	public Dimension getPreferredSize(){
		return dimension;
	}
}

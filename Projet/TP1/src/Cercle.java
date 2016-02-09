/******************************************************
Cours:  LOG121
Projet: TP1 #1
Nom du fichier: Cercle.java
Date créé: 2016-01-14
*******************************************************
Historique des modifications
*******************************************************
*@author Vincent Leclerc(LECV07069406)
*@author Gabriel Déry(DERG30049401)
2016-01-14 Version initiale
*******************************************************/  

import java.awt.Color;
import java.awt.Graphics;

/**
 * Classe qui va afficher un cercle
 *
 */
public class Cercle extends Forme{

	private int centreX;
	private int centreY;
	private int rayon;
	
	/**
	 * Constructeur du cercle
	 * @param seq numéro de séquence
	 * @param couleur couleur de la forme
	 * @param centreX position x du centre du cercle
	 * @param centreY position y du centre du cercle
	 * @param rayon longeur du rayon
	 */
	public Cercle(int seq,Color couleur,int centreX, int centreY,int rayon)
	{
		super(seq,couleur);
		this.centreX = centreX;
		this.centreY = centreY;
		this.rayon = rayon;
	}
	

	/* (non-Javadoc)
	 * @see Forme#dessiner(java.awt.Graphics)
	 */
	public void dessiner(Graphics g,int numForme)
	{
		g.setColor(couleur);
		g.fillOval(numForme*40, numForme*40, rayon*2, rayon*2);
		g.setColor(Color.black);
		g.drawOval(numForme*40, numForme*40, rayon*2, rayon*2);
		g.drawRect(numForme*40, numForme*40, rayon*2, rayon*2);
	}
	
	/*
	 * (non-Javadoc)
	 * @see Forme#getAire()
	 */
	public double getAire()
	{
		//Pi * rayon à la 2
		return (Math.PI*Math.pow(rayon, 2));
	}
	
	public double getDistance()
	{
		//Diamètre
		return Math.pow(rayon, 2);
	}
}

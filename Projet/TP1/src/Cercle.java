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
	public void dessiner(Graphics g)
	{
		g.setColor(couleur);
		g.fillOval(centreX, centreY, rayon, rayon);
	}
}

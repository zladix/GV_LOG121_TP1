/******************************************************
Cours:  LOG121
Projet: TP1 #1
Nom du fichier: Ligne.java
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
 * Classe qui va dessiner une ligne
 * @author Gabriel Déry
 *
 */
public class Ligne extends Forme {
	private int x1;
	private int y1;
	private int x2;
	private int y2;

	/**
	 * Constructeur de la ligne
	 * @param seq numéro de séquence de la forme
	 * @param couleur couleur de la forme
	 * @param x1 position x de départ de la ligne
	 * @param y1 position y de départ de la ligne
	 * @param x2 position x de fin de la ligne
	 * @param y2 position y de fin de la ligne
	 */
	public Ligne(int seq,Color couleur,int x1,int y1,int x2, int y2)
	{
		super(seq,couleur);
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		
	}
	
	public void dessiner(Graphics g)
	{
		g.setColor(couleur);
		g.drawLine(x1, y1, x2, y2);

	}
	
	/*
	 * (non-Javadoc)
	 * @see Forme#getAire()
	 */
	public double getAire()
	{
		//Longueur*Largeur
		return (Math.abs(x2-x1));
	}
	
	public double getDistance()
	{
		//Formule de distance
		return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
	}
}

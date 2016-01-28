/******************************************************
Cours:  LOG121
Projet: TP1 #1
Nom du fichier: DecodeurChaine.java
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
 * Classe qui va dessiner un ovale
 *
 */
public class Ovale extends Forme{
	
	private int centreX;
	private int centreY;
	private int rayonH;
	private int rayonV;
	
	/**
	 * Constructeur de l'ovale
	 * @param seq numéro de séquence de la forme
	 * @param couleur couleur de la forme
	 * @param centreX position x du centre de l'ovale
	 * @param centreY position y du centre de l'ovale
	 * @param rayonH rayon horizontal de l'oval
	 * @param rayonV rayon vertical de l'oval
	 */
	public Ovale(int seq,Color couleur,int centreX,int centreY,int rayonH,int rayonV)
	{
		super(seq,couleur);
		this.centreX = centreX;
		this.centreY = centreY;
		this.rayonH = rayonH;
		this.rayonV = rayonV;
	}
	
	/* (non-Javadoc)
	 * @see Forme#dessiner(java.awt.Graphics)
	 */
	public void dessiner(Graphics g)
	{
		g.setColor(couleur);
		g.fillOval(centreX, centreY, rayonH, rayonV);
	}

}

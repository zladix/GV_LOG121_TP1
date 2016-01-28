/******************************************************
Cours:  LOG121
Projet: TP1 #1
Nom du fichier: Quadrilatere.java
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
 * Classe qui va dessiner un carré ou un rectangle
 *
 */
public class Quadrilatere extends Forme {
	
	private int x1;
	private int y1;
	private int x2;
	private int y2;

	/**
	 * Constructeur du quadrilatère
	 * @param seq numéro de séquence de la forme
	 * @param couleur couleur de la forme
	 * @param x1 position de départ en x de la forme
	 * @param y1 position de départ en y de la forme
	 * @param x2 position de fin en x de la forme
	 * @param y2 position de fin en y de la forme
	 */
	public Quadrilatere(int seq,Color couleur,int x1,int y1,int x2, int y2)
	{
		super(seq,couleur);
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		
	}
	
	/* (non-Javadoc)
	 * @see Forme#dessiner(java.awt.Graphics)
	 */
	public void dessiner(Graphics g)
	{
		g.setColor(couleur);
		g.fillRect(x1, y1, x2-x1,y2-y1);

	}
	
}

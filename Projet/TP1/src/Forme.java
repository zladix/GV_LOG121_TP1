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
 * Classe abstraite qui va afficher les formes selon leurs types
 *
 */
public abstract class Forme {
	protected int noSequence;
	protected Color couleur;
	
	/**
	 * Constructeur de la forme
	 * @param seq numéro de séquence de la forme
	 * @param couleur couleur de la forme
	 */
	public Forme(int seq,Color couleur)
	{
		this.couleur = couleur;
		this.noSequence = seq;
	}
	/**
	 * @return le numéro de séquence de la forme
	 */
	public int getSeq()
	{
		return noSequence;
	}
	
	/**
	 * va dessiner le bon type de forme
	 * @param g objet graphics dans la méthode paint component ou on veut dessiner
	 */
	protected void dessiner(Graphics g,int numForme){}
	
	/**
	 * Calcule l'aire selon la forme et retourne sa valeur
	 */
	protected double getAire(){return 0;}
	
	/**
	 * Calcule la distance entre les deux points les plus loin et renvoie la valeur.
	 */
	protected double getDistance(){return 0;}

}

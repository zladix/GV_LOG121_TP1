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
	public void dessiner(Graphics g){}
	
	

}

/******************************************************
Cours:  LOG121
Projet: TP1 #1
Nom du fichier: CreateurForme.java
Date cr��: 2016-01-14
*******************************************************
Historique des modifications
*******************************************************
*@author Vincent Leclerc(LECV07069406)
*@author Gabriel D�ry(DERG30049401)
2016-01-14 Version initiale
*******************************************************/  
import java.awt.Color;
import ca.etsmtl.log.util.IDLogger;

/**
 * Classe qui va s'occuper de cr�er les formes � partir d'une cha�ne de caract�res
 *
 */
public class CreateurForme {
	
	public CreateurForme(){}
	
	/**
	 * @param chaineForme chaine de caract�re re�u par le serveur
	 * @return La forme qui est cr��
	 */
	public Forme creerForme(String chaineForme)
	{
		DecodeurChaine decodeur = new DecodeurChaine();
		decodeur.decoderChaine(chaineForme);
		int[] tabCoordonnee = decodeur.getTableauCoordonnee();
		Forme uneForme = null;
		
		IDLogger logger = IDLogger.getInstance(); //M�thode statique
		logger.logID(decodeur.getNumeroSequence());
		
		switch(decodeur.getTypeForme())
		{
			case "CARRE":
				uneForme = new Quadrilatere(decodeur.getNumeroSequence(), Color.green, tabCoordonnee[0], tabCoordonnee[1], tabCoordonnee[2], tabCoordonnee[3]);
			break;
			case "RECTANGLE":
				uneForme = new Quadrilatere(decodeur.getNumeroSequence(), Color.yellow, tabCoordonnee[0], tabCoordonnee[1], tabCoordonnee[2], tabCoordonnee[3]);
			break;
			case "CERCLE":
				uneForme = new Cercle(decodeur.getNumeroSequence(), Color.red,tabCoordonnee[0], tabCoordonnee[1], tabCoordonnee[2]);
			break;
			case "OVALE":
				uneForme = new Ovale(decodeur.getNumeroSequence(), Color.blue,tabCoordonnee[0], tabCoordonnee[1], tabCoordonnee[2], tabCoordonnee[3]);
			break;
			case "LIGNE":
				uneForme = new Ligne(decodeur.getNumeroSequence(), Color.orange, tabCoordonnee[0], tabCoordonnee[1], tabCoordonnee[2], tabCoordonnee[3]);
			break;		
		}
		
		return uneForme;
	}
	
}

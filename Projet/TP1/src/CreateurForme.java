import java.awt.Color;

public class CreateurForme {
	
	CreateurForme(){}
	
	public Forme creerForme(String chaineForme)
	{
		DecodeurChaine Decodeur = new DecodeurChaine();
		Decodeur.DecoderChaine(chaineForme);
		int[] tabCoordonnee = Decodeur.getTableauCoordonnee();
		Forme uneForme = null;
		
		
		switch(Decodeur.getTypeForme())
		{
			case "CARRE":
				uneForme = new Quadrilatere(Decodeur.getNumeroSequence(), Color.green, tabCoordonnee[0], tabCoordonnee[1], tabCoordonnee[2], tabCoordonnee[3]);
			break;
			case "RECTANGLE":
				uneForme = new Quadrilatere(Decodeur.getNumeroSequence(), Color.yellow, tabCoordonnee[0], tabCoordonnee[1], tabCoordonnee[2], tabCoordonnee[3]);
			break;
			case "CERCLE":
				uneForme = new Cercle(Decodeur.getNumeroSequence(), Color.red,tabCoordonnee[0], tabCoordonnee[1], tabCoordonnee[2]);
			break;
			case "OVALE":
				uneForme = new Ovale(Decodeur.getNumeroSequence(), Color.blue,tabCoordonnee[0], tabCoordonnee[1], tabCoordonnee[2], tabCoordonnee[3]);
			break;
			case "LIGNE":
				uneForme = new Quadrilatere(Decodeur.getNumeroSequence(), Color.orange, tabCoordonnee[0], tabCoordonnee[1], tabCoordonnee[2], tabCoordonnee[3]);
			break;		
		}
		
		return uneForme;
	}
	
}

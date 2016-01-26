import java.awt.Color;
import java.awt.Graphics;

abstract class Forme {
	protected int noSequence;
	protected Color couleur;
	
	Forme(int seq,Color couleur)
	{
		this.couleur = couleur;
		this.noSequence = seq;
	}
	public int getSeq()
	{
		return noSequence;
	}
	
	void dessiner(Graphics g){}
	
	

}

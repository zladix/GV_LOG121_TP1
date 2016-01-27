import java.awt.Color;
import java.awt.Graphics;

public class Ligne extends Forme {
	private int x1;
	private int y1;
	private int x2;
	private int y2;

	Ligne(int seq,Color couleur,int x1,int y1,int x2, int y2)
	{
		super(seq,couleur);
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		
	}
	
	void dessiner(Graphics g)
	{
		g.setColor(couleur);
		g.drawLine(x1, y1, x2, y2);

	}
}

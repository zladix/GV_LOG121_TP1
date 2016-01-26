import java.awt.Color;
import java.util.Arrays;

public final class OrganiseForme {
		
		final int MAX_FORME = 10;
		Forme tabForme[];
		int pos;
	
		OrganiseForme()
		{
			pos = 0;
			tabForme = new Forme[MAX_FORME];
		}
		
		public void AjoutForme(Forme uneForme)
		{
			tabForme[pos] = uneForme;
			Forme tabFormeTemp[] = new Forme[MAX_FORME];
			
			tabFormeTemp = tabForme;
			
			if(pos == MAX_FORME-1)
			{
				for(int i=0;i<MAX_FORME-1;i++)
				{
					tabForme[i] = tabFormeTemp[i+1];
				}
				tabForme[MAX_FORME-1] = null;
			}
			else
			{
				pos = pos+1;
			}
		}
		public Forme[] getTabForme()
		{
			return this.tabForme;
		}
		public int getPos()
		{
			return this.pos;
		}
		
}

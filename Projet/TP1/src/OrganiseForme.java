import java.awt.Color;
import java.util.Arrays;

public final class OrganiseForme {
		
		final int MAX_FORME = 9;
		Forme tabForme[];
		int pos;
	
		OrganiseForme()
		{
			pos = 0;
			tabForme = new Forme[MAX_FORME];
		}
		
		public void AjoutForme(Forme uneForme)
		{
			if(pos > MAX_FORME)
			{
				tabForme = Arrays.copyOfRange(tabForme, 1, tabForme.length);
				pos = MAX_FORME;
			}

			tabForme[pos] = uneForme;
			pos = pos+1;
		}
		public Forme[] getTabForme()
		{
			return this.tabForme;
		}
}

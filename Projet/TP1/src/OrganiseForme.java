/******************************************************
Cours:  LOG121
Projet: TP1 #1
Nom du fichier: DecodeurChaine.java
Date cr��: 2016-01-14
*******************************************************
Historique des modifications
*******************************************************
*@author Vincent Leclerc(LECV07069406)
*@author Gabriel D�ry(DERG30049401)
2016-01-14 Version initiale
*******************************************************/  
import java.awt.Color;
import java.util.Arrays;

/**
 * classe qui va g�rer le tableau de forme
 *
 */
public final class OrganiseForme {
		
		final int MAX_FORME = 10;
		private Forme tabForme[];
		private int pos;

		/**
		 * Constructeur du tableau de forme l'initialise � 10
		 */
		public OrganiseForme()
		{
			pos = 0;
			tabForme = new Forme[MAX_FORME];
		}
		
		/**
		 * Va ajouter une forme dans le tableau et enlever la premi�re forme s'il y en a plus que 10
		 * @param uneForme Forme � ajouter dans le tableau
		 */
		public void ajoutForme(Forme uneForme)
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
		/**
		 * @return le tableau de forme
		 */
		public Forme[] getTabForme()
		{
			return this.tabForme;
		}
		/**
		 * @return la position du tableau de la forme
		 */
		public int getPos()
		{
			return this.pos;
		}
		
}

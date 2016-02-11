import java.awt.Graphics;

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
import java.util.Arrays;


/**
 * classe qui va gérer le tableau de forme
 *
 */
public final class OrganiseForme {
		

		private class Noeud
		{
			private Forme maForme;
			private Noeud noeudSuivant;
			
			public Noeud(Forme maForme, Noeud noeudSuivant)
			{
				this.maForme = maForme;
				this.noeudSuivant = noeudSuivant;
			}
			
			public Noeud getNoeudSuivant()
			{
				return noeudSuivant;
			}
		}
		
		Noeud NoeudPremier;
		private static OrganiseForme org = new OrganiseForme();

		
		/**
		 * Constructeur du tableau de forme l'initialise à 10
		 */
		private OrganiseForme()
		{
		   NoeudPremier = null;
		}
		
		public static OrganiseForme getOrganise()
		{
			return org;
			pos = 0;
		}
		
		/**
		 * Va ajouter une forme dans le tableau et enlever la première forme s'il y en a plus que 10
		 * @param uneForme Forme à ajouter dans le tableau
		 */
		public void ajoutForme(Forme uneForme)
		{
			if(pos == MAX_FORME-1)
			{
				for(int i=0;i<MAX_FORME-1;i++)
				{
					noeudCourant = noeudCourant.getNoeudSuivant();			
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

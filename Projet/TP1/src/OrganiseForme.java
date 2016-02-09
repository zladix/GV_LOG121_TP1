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
import java.awt.Graphics;
import java.util.Arrays;

/**
 * classe qui va g�rer le tableau de forme
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
		
		final int MAX_FORME = 10;
		private Forme tabForme[];
		private int pos;
		
		
		/**
		 * Constructeur de la liste cha�n�e de forme et l'initialise � 10
		 */
		public OrganiseForme()
		{
			Noeud NoeudPremier = null;
			pos = 0;
			tabForme = new Forme[MAX_FORME];
		}
		
		/**
		 * Ajout de la forme dans la liste cha�n�e
		 * @param uneForme Forme � ajouter
		 */
		public void ajoutForme(Forme uneForme)
		{
			if(NoeudPremier == null)
			{
				NoeudPremier = new Noeud(uneForme, NoeudPremier);
			}
			else
			{
				Noeud noeudCourant = NoeudPremier;
				
				while(noeudCourant.noeudSuivant!= null)
				{
					noeudCourant = noeudCourant.getNoeudSuivant();
					
				}
				
				noeudCourant.noeudSuivant = new Noeud(uneForme,noeudCourant);
				noeudCourant = noeudCourant.noeudSuivant;
				noeudCourant.noeudSuivant = null;
			}
			
		}
		
		public void afficherFormes(Graphics g)
		{
			int numForme = 0;
			if(NoeudPremier == null)
			{
				//message d'erreur
			}
			else
			{
				Noeud noeudCourant = NoeudPremier;
				
				while(noeudCourant!=null)
				{
					numForme = numForme+1;
					noeudCourant.maForme.dessiner(g,numForme);
					noeudCourant = noeudCourant.getNoeudSuivant();
					
				}
			}
		}
		
}

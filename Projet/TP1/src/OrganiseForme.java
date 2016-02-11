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
		final int MAX_FORME = 10;
		private static OrganiseForme org = new OrganiseForme();

		
		/**
		 * Constructeur de la liste chaînée de forme et l'initialise à 10
		 */
		private OrganiseForme()
		{
		   NoeudPremier = null;
		}
		
		public static OrganiseForme getOrganise()
		{
			return org;
		}
		
		/**
		 * Ajout de la forme dans la liste chaînée
		 * @param uneForme Forme à ajouter
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

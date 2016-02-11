/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: MenuFenetre.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
2016-02-04 Modification des menus (Vincent Leclerc)
*******************************************************
*@author Patrice Boucher
2013-05-03 Version initiale
*******************************************************/  

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import java.net.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

/**
 * Cr�e le menu de la fen�tre de l'application
 */
public class MenuFenetre extends JMenuBar{
	
	private static final long serialVersionUID = 1536336192561843187L;
	private static final int  MENU_FICHIER_DEMARRER_TOUCHE_MASK = ActionEvent.CTRL_MASK;
	private static final char MENU_FICHIER_DEMARRER_TOUCHE_RACC = KeyEvent.VK_D;
	private static final int  MENU_FICHIER_QUITTER_TOUCHE_MASK = ActionEvent.CTRL_MASK;
	private static final char MENU_FICHIER_QUITTER_TOUCHE_RACC = KeyEvent.VK_Q;
	private static final String
			MENU_FICHIER_TITRE = "app.frame.menus.file.title",
			MENU_FICHIER_OBTENIRFORME = "app.frame.menus.draw.start",
			MENU_FICHIER_QUITTER = "app.frame.menus.file.exit",
			MENU_ORDRE_TITRE = "app.frame.menus.order.title",
			MENU_ORDRE_NBSEQ_CROISSANT = "app.frame.menus.order.seq.increasing",
			MENU_ORDRE_NBSEQ_DECROISSANT = "app.frame.menus.order.seq.decreasing",
			MENU_ORDRE_AIRE_CROISSANTE = "app.frame.menus.order.area.increasing",
			MENU_ORDRE_AIRE_DECROISSANTE = "app.frame.menus.order.area.decreasing",
			MENU_ORDRE_TYPE_FORME = "app.frame.menus.order.form.type",
			MENU_ORDRE_TYPE_FORME_INVERSE = "app.frame.menus.order.form.type.reverse",
			MENU_ORDRE_DISTANCE = "app.frame.menus.order.distance",
			MENU_AIDE_TITRE = "app.frame.menus.help.title",
			MENU_AIDE_PROPOS = "app.frame.menus.help.about";
	private static final String MESSAGE_DIALOGUE_A_PROPOS = "app.frame.dialog.about";  


	private JMenuItem obtenirFormeMenuItem;
	private static final int DELAI_QUITTER_MSEC = 200;
	public OrganiseForme org = OrganiseForme.getOrganise();
	private PropertyChangeListener listener = null;
 	   
	CommBase comm; // Pour activer/désactiver la communication avec le serveur
	
	/**
	 * Constructeur
	 */
	public MenuFenetre(CommBase comm) {
		this.comm = comm;
		addMenuFichier();
		addMenuOrdre();
		addMenuAide();
	}
	/** 
	 * Créer le menu "File". 
	 */
	
	
	protected void addMenuFichier() {
		JMenu menu = creerMenu(MENU_FICHIER_TITRE, new String[] { MENU_FICHIER_OBTENIRFORME,MENU_FICHIER_QUITTER });
		obtenirFormeMenuItem = menu.getItem(0);
		obtenirFormeMenuItem.addActionListener(new ActionListener(){
		  public void actionPerformed(ActionEvent arg0) {
			comm.start();
		  }
		});
		obtenirFormeMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				MENU_FICHIER_DEMARRER_TOUCHE_RACC,
				MENU_FICHIER_DEMARRER_TOUCHE_MASK));

		menu.getItem(1).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    try {
						Thread.sleep(DELAI_QUITTER_MSEC);
				} catch (InterruptedException e) {
						e.printStackTrace();
				}
				System.exit(0);
			}
		});
		menu.getItem(0).setAccelerator(
				KeyStroke.getKeyStroke(MENU_FICHIER_QUITTER_TOUCHE_RACC,
						MENU_FICHIER_QUITTER_TOUCHE_MASK));
		add(menu);
	}

	
	/**
	 * Cr�er le menu ordre
	 */
	private void addMenuOrdre()
	{
		JMenu menu = creerMenu(MENU_ORDRE_TITRE, new String[] {});
		//NumSeq Croissant
		JRadioButtonMenuItem rOrdreSeqCroissant = new JRadioButtonMenuItem(LangueConfig.getResource(MENU_ORDRE_NBSEQ_CROISSANT));
		rOrdreSeqCroissant.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent arg0) {
				  Forme uneForme = new Quadrilatere(22, Color.red, 50, 50, 60, 60);
				  org.ajoutForme(uneForme);
				  	repaint();
				
			  }
		});
		//NumSeq D�croissant
		JRadioButtonMenuItem rOrdreSeqDecroissant = new JRadioButtonMenuItem(LangueConfig.getResource(MENU_ORDRE_NBSEQ_DECROISSANT));
		rOrdreSeqDecroissant.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent arg0) {
				  
			  }
		});
		//Aire Croissant
		JRadioButtonMenuItem rOrdreAireCroissant = new JRadioButtonMenuItem(LangueConfig.getResource(MENU_ORDRE_AIRE_CROISSANTE));
		rOrdreAireCroissant.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent arg0) {
				
			  }
		});

		//Aire D�croissant
		JRadioButtonMenuItem rOrdreAireDecroissant = new JRadioButtonMenuItem(LangueConfig.getResource(MENU_ORDRE_AIRE_DECROISSANTE));
		rOrdreAireDecroissant.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent arg0) {
				
			  }
		});

		//Ordre type forme
		JRadioButtonMenuItem rOrdreTypeForme = new JRadioButtonMenuItem(LangueConfig.getResource(MENU_ORDRE_TYPE_FORME));
		rOrdreTypeForme.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent arg0) {
				
			  }
		});

		//Ordre type forme inverse
		JRadioButtonMenuItem rOrdreTypeFormeInverse = new JRadioButtonMenuItem(LangueConfig.getResource(MENU_ORDRE_TYPE_FORME_INVERSE));
		rOrdreTypeFormeInverse.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent arg0) {
				
			  }
		});

		//Distance croissante
		JRadioButtonMenuItem rOrdreDistance = new JRadioButtonMenuItem(LangueConfig.getResource(MENU_ORDRE_DISTANCE));
		rOrdreDistance.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent arg0) {
				
			  }
		});
		//Regrouppement des radio bouton dans le m�me groupe
		ButtonGroup group = new ButtonGroup();
		group.add(rOrdreSeqCroissant);
		group.add(rOrdreSeqDecroissant);
		group.add(rOrdreAireCroissant);
		group.add(rOrdreAireDecroissant);
		group.add(rOrdreTypeForme);
		group.add(rOrdreTypeFormeInverse);
		group.add(rOrdreDistance);
		
		//Ajout des radio boutons dans le menu
		menu.add(rOrdreSeqCroissant);
		menu.add(rOrdreSeqDecroissant);
		menu.add(rOrdreAireCroissant);
		menu.add(rOrdreAireDecroissant);
		menu.add(rOrdreTypeForme);
		menu.add(rOrdreTypeFormeInverse);
		menu.add(rOrdreDistance);
		
		//Ajout du menu
		add(menu);
	}

	/**
	 *  Créer le menu "Help". 
	 */
	private void addMenuAide() {
		JMenu menu = creerMenu(MENU_AIDE_TITRE, new String[] { MENU_AIDE_PROPOS });
		menu.getItem(0).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,  LangueConfig.getResource(MESSAGE_DIALOGUE_A_PROPOS), 
						LangueConfig.getResource(MENU_AIDE_PROPOS), JOptionPane.INFORMATION_MESSAGE);
			}
		});
		add(menu);
	}
	
	/**
	 * Créer un élément de menu à partir d'un champs principal et ses éléments
	 * @param titleKey champs principal
	 * @param itemKeys éléments
	 * @return le menu
	 */
	private static JMenu creerMenu(String titleKey,String[] itemKeys) {
        JMenu menu = new JMenu(LangueConfig.getResource(titleKey));
        for(int i=0; i < itemKeys.length; ++i) {
           menu.add(new JMenuItem(LangueConfig.getResource(itemKeys[i])));
        }
        return menu;
   }
	
	public void setOrganiseForme(OrganiseForme org)
	{
		this.org = org;
	}
	
}

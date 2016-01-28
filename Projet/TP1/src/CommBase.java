/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: CommBase.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
-Ajout de la communication au serveur Serveur forme. (Par Vincent Leclerc et Gabriel Déry le 2016-01-21)
*******************************************************
*@author Patrice Boucher
2013-05-03 Version initiale
*******************************************************/  

import java.beans.PropertyChangeListener;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import java.net.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Base d'une communication via un fil d'exécution parallèle.
 */
public class CommBase {
	
	private final int DELAI = 1000;
	private SwingWorker threadComm =null;
	private PropertyChangeListener listener = null;
	private boolean isActif = false;
	private Socket socket = null;
	private BufferedReader in = null;
	private PrintWriter out = null;
	private String contenuChaine = null;
	/**
	 * Constructeur
	 */
	public CommBase(){
	}
	
	/**
	 * Définir le récepteur de l'information relié dans la communication avec le serveur
	 * @param listener sera alerté lors de l'appel de "firePropertyChanger" par le SwingWorker
	 */
	public void setPropertyChangeListener(PropertyChangeListener listener){
		this.listener = listener;
	}
	
	/**
	 * Démarre la communication
	 */
	public void start(){
		creerCommunication();
	}
	
	/**
	 * Arrête la communication
	 */
	public void stop(){
		fermerConnexionServeur();
		if(threadComm!=null)
			threadComm.cancel(true); 
		isActif = false;
	}
	
	/**
	 * Créer le nécessaire pour la communication avec le serveur
	 */
	protected void creerCommunication(){		
		// Crée un fil d'exécusion parallèle au fil courant,
		threadComm = new SwingWorker(){
			@Override
			protected Object doInBackground() throws Exception {
				System.out.println("Le fils d'execution parallele est lance");
				try {
					String infoConnexion = JOptionPane.showInputDialog(null,"Quel est le nom d'hôtes et le port du serveur de formes?",null);
					if(infoConnexion.contains("localhost") == true)
					{
						socket = new Socket(InetAddress.getLocalHost(),Integer.parseInt(infoConnexion.substring(infoConnexion.indexOf(":")+1,infoConnexion.length())));
					}
					else
					{
						socket = new Socket(infoConnexion.substring(0,infoConnexion.indexOf(":")),Integer.parseInt(infoConnexion.substring(infoConnexion.indexOf(":")+1,infoConnexion.length())));
					}
					in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					out = new PrintWriter(socket.getOutputStream());
					isActif = socket.isConnected();
				}catch (Exception e) {
					JOptionPane.showMessageDialog(null,"La connexion au serveur n'a pas pu être effectué Assurez-vous que le serveur est bien ouvert.", "Erreur Connexion",
						    JOptionPane.ERROR_MESSAGE);
					isActif = false;
					System.out.println(e);
				}
				while(isActif){
					Thread.sleep(DELAI);
					String sForme = communicationServeur();
					if(sForme.equals("commande> ") == false)
					{
					
					
	 					//La méthode suivante alerte l'observateur 
						if(listener!=null)
						   firePropertyChange("ENVOIE-TEST", null, (String) sForme); 
					}
				}
				
				return null;
			}
		};
		if(listener!=null)
		   threadComm.addPropertyChangeListener(listener); // La méthode "propertyChange" de ApplicationFormes sera donc appelée lorsque le SwinkWorker invoquera la méthode "firePropertyChanger" 		
		threadComm.execute(); // Lance le fil d'exécution parallèle.
		isActif = true;
	}
	
	/**
	 * @return si le fil d'exécution parallèle est actif
	 */
	public boolean isActif(){
		return isActif;
	}
	
	/**
	 * Envoi "GET" au serveur et récupère la réponse
	 */
	protected String communicationServeur()
	{	
		//On peu communiquer avec le serveur
			try{
				if(socket.isConnected() == true && socket.isClosed() == false)
				{
					out.println("GET");
					out.flush();
					contenuChaine = in.readLine();
				}
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"La connexion au serveur n'a pas pu être effectué Assurez-vous que le serveur est bien ouvert.", "Erreur Connexion",
					    JOptionPane.ERROR_MESSAGE);
				stop();
			}
			
			return contenuChaine;
	}
	
	/**
	 * Ferme la connexion avec le serveur en lui envoyant la commande "END".
	 */
	protected void fermerConnexionServeur()
	{
		try{
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			out.println("END");
			out.flush();
			socket.close();
			System.out.println("\nCommunication fermé");
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

package tournoi;

import java.util.ArrayList;
import java.util.Random;

import bar.Bar;
import bar.Barman;
import bar.Bijoux;
import bar.Boisson;
import bar.Client;
import bar.ClientFemme;
import bar.ClientHomme;
import bar.Couleur;
import bar.Humain;
import bar.Patronne;
import bar.Serveur;
import bar.ServeurFemme;
import bar.ServeurHomme;

public class Utilisateur {

	private static ArrayList<Bar> barList = new ArrayList<Bar>();			//liste des bar de l'appli( par défaut ne contient qu'un seul bar
	
	

    // accesseurs et mutateurs 
	
	public static ArrayList<Bar> getBarList() {
		return barList;
	}

	public static void setBarList(ArrayList<Bar> list) {
		barList = list;
	}
	
	
	public void basicConfiguration() 		// config de base pour l'utilisation de l'application
	{
		
	}
	/* constructeur*/
	public Utilisateur()
	{
		automaticBar();						// on crée un bar automatiquement quand on instancie la classe utilisateur
	}
	/* méthodes utiles */
	
	public void addBar(Bar bar)
	{
		barList.add(bar);				// on rajoute un bar à la liste des bars
	}
	public void displayBarList()		// on affiche la liste des bars disponibles de l'appli
	{
		ArrayList<Bar> list= barList;
		System.out.println("la liste des bars disponibles: ");
		for(int i = 0;i< list.size();i++)
			System.out.println(i+"-"+list.get(i).getNom()+"\n");

	}
	public void automaticBar()					// on crée un nouveau bar 					
	{
		Patronne patronne = automaticPatronne(2);
		Barman barman= automaticBarman();
		ArrayList<Humain> occupantsList= new ArrayList<Humain>() ;		// liste des occupants du bar
		ArrayList<Serveur> serveursList= automaticServeursList();		// liste des seurveurs du bar
		ArrayList<Client> clientsList= automaticClientList();		// liste des seurveurs du bar
		for(int i =0;i < serveursList.size();i++)
		{
			occupantsList.add(i, serveursList.get(i));   			// par covariance des variables je peux peux stocker une variable fille dans une variable mère
		}
		addPerso(patronne,occupantsList);
		addPerso(barman,occupantsList);
		Bar bar= new Bar("Queen victoria", patronne,barman, automaticInventaire(),serveursList,occupantsList,clientsList);
		addBar(bar); 						// on rajoute le bar nouvellement crée à la liste
		
	}
	/*création de personnages */
	
	public void addPerso(Humain perso,ArrayList<Humain> list)
	{
		list.add(perso);
	}
	public ServeurHomme automaticServeurHomme(int i)				//  méthode de création d'un serveur homme
	{
		String prenom[] = {"antony","joshua","romain","billy"};	// tableau de prénoms de serveurs
		String surnom[]= {"anto","josh","jules cesar","bill"};	
		String cri[]= {"aouuu","hehhehehe","pour la gloire de rome","tchap tchap"};
		
	  	ServeurHomme serveur = new ServeurHomme(prenom[i], surnom[i], 500, 5, cri[i], 10);
	  	return serveur;
	}
	public ServeurFemme automaticServeurFemme(int i)				//  méthode de création d'une serveuse femme
	{
		String prenom[] = {"janette","alexa","katie","beverly"};	// tableau de prénoms de serveuses
		String surnom[]= {"Miss jane","al","kate","hills"};	
		String cri[]= {"oooohh","miaouh","voix aigue","voie grave"};
		
	  	ServeurFemme serveur = new ServeurFemme(prenom[i], surnom[i], 500, 5, cri[i], 10);
	  	return serveur;
	}
	public ClientFemme automaticClientFemme(int i)				//  méthode de création d'une serveuse femme
	{
		String prenom[] = {"janette","alexa","katie","beverly"};	// tableau de prénoms de serveuses
		String surnom[]= {"Miss jane","al","kate","hills"};	
		String cri[]= {"oooohh","miaouh","voix aigue","voie grave"};
		
		
		Bijoux bijou= Bijoux.bague ;
	  	ClientFemme client = new ClientFemme(this.automaticBoisson(3),this.automaticBoisson(0),5,prenom[i],surnom[i],500, 5, cri[i],bijou);

	  	return client;
	}
	public ClientHomme automaticClientHomme(int i)				//  méthode de création d'une serveuse femme
	{
		String prenom[] = {"Godwin","junior","romain","billy"};	// tableau de prénoms de serveuses
		String surnom[]= {"godwill","benjamin","romi","bill"};	
		String cri[]= {"oooohh","miaouh","voix aigue","voie grave"};
		
		
		Couleur color= Couleur.bleu ;
	  	ClientHomme client = new ClientHomme(this.automaticBoisson(1),this.automaticBoisson(0),5,prenom[i],surnom[i],500, 5, cri[i],color);

	  	return client;
	}
	public Barman automaticBarman()
	{
		Barman barman= new Barman("Thomas", "tom", 500, 8,"une commande une");
		
		return barman;
	}
	public Patronne automaticPatronne(int i)
	{
		String prenom[] = {"Maryweather","lana","lou","beverly"};	// tableau de prénoms de serveuses
		String surnom[]= {"La diva","fox","the queen","cardi B"};	
		String cri[]= {"oooohh","miaouh","voix aigue","voie grave"};
		
		Bijoux bijou= Bijoux.couronne ;
		Patronne owner= new Patronne(this.automaticBoisson(1),this.automaticBoisson(2),5,prenom[i],surnom[i],500, 5, cri[i],bijou);
		
		return owner;
	}

	/*
	 * public ArrayList<Humain> automaticOccupantsList() // on rajoute des
	 * personnages à la liste des occupants { ArrayList<Humain> occupants = new
	 * ArrayList<Humain>(); for(int i=0; i< 4;i++) {
	 * occupants.add(automaticServeurFemme());
	 * occupants.add(automaticServeurHomme()); }
	 * 
	 * return occupants; }
	 */
	public ArrayList<Serveur> automaticServeursList()
	{
		ArrayList<Serveur> serveurs= new ArrayList<Serveur>();
		Random r= new Random();
		int nb=0;
		for(int i=0; i< 4;i++)
		{
			nb =r.nextInt(4);
			if((!serveurs.contains(automaticServeurFemme(nb)) ))
				serveurs.add(automaticServeurFemme(nb));
			if(!serveurs.contains(automaticServeurHomme(nb)))
				serveurs.add(automaticServeurHomme(nb));
			
		}
		return serveurs;
	}
	public ArrayList<Client> automaticClientList()
	{
		ArrayList<Client> clients= new ArrayList<Client>();
		
		for(int i=0; i< 4;i++)
		{
				clients.add(automaticClientFemme(i));
				clients.add(automaticClientHomme(i));
		}
		return clients;
	}
	/* création et load de l'inventaire de boisson du bar*/
	public Boisson automaticBoisson( int i)
	{
		String nom[] = {"Rince cochon","cuvée des trolls","coca","panaché"};	// tableau de prénoms de serveuses
		int quantite[]= {75,75,25,50};											// quantité en centilitre
		float prix[]= {7,5,8,3};												// prix de boissons
		boolean alcoolise[]= {true,true,false,false};							// alcoolise ou pas
		
		Boisson boisson= new Boisson(nom[i],quantite[i],prix[i],alcoolise[i]);
		
		return boisson;
	}
	public ArrayList<Boisson> automaticInventaire()  							// on rajoute les boissons à l'inventaire
	{
		
		ArrayList<Boisson> inventaire = new ArrayList<Boisson>();
		for(int i=0; i< 4;i++)
		{
			
			if((!inventaire.contains(automaticBoisson(i)) ))
				inventaire.add(automaticBoisson(i));
			}
	
		return inventaire;
	}
	
	
	
}

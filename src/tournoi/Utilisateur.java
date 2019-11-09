package tournoi;

import java.util.ArrayList;

import bar.*;

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
		Patronne patronne = automaticPatronne();
		Barman barman= automaticBarman();
		ArrayList<Humain> list= automaticOccupantsList();
		addPerso(patronne,list);
		addPerso(barman,list);
		Bar bar= new Bar("Queen victoria", patronne,barman, automaticInventaire(),list);
		addBar(bar); 						// on rajoute le bar nouvellement crée à la liste
		
	}
	/*création de personnages */
	
	public void addPerso(Humain perso,ArrayList<Humain> list)
	{
		list.add(perso);
	}
	public ServeurHomme automaticServeurHomme()				//  méthode de création d'un serveur homme
	{
		String prenom[] = {"antony","joshua","romain","billy"};	// tableau de prénoms de serveurs
		String surnom[]= {"anto","josh","jules cesar","bill"};	
		String cri[]= {"aouuu","hehhehehe","pour la gloire de rome","tchap tchap"};
		int i= (int)Math.random()*3;
	  	ServeurHomme serveur = new ServeurHomme(prenom[i], surnom[i], 500, 5, cri[i], 10);
	  	return serveur;
	}
	public ServeurFemme automaticServeurFemme()				//  méthode de création d'une serveuse femme
	{
		String prenom[] = {"janette","alexa","katie","beverly"};	// tableau de prénoms de serveuses
		String surnom[]= {"Miss jane","al","kate","hills"};	
		String cri[]= {"oooohh","miaouh","voix aigue","voie grave"};
		int i= (int)Math.random()*3;
	  	ServeurFemme serveur = new ServeurFemme(prenom[i], surnom[i], 500, 5, cri[i], 10);
	  	return serveur;
	}
	public ClientFemme automaticClientFemme()				//  méthode de création d'une serveuse femme
	{
		String prenom[] = {"janette","alexa","katie","beverly"};	// tableau de prénoms de serveuses
		String surnom[]= {"Miss jane","al","kate","hills"};	
		String cri[]= {"oooohh","miaouh","voix aigue","voie grave"};
		
		int i= (int)Math.random()*3;
		Bijoux bijou= Bijoux.bague ;
	  	ClientFemme client = new ClientFemme(this.automaticBoisson(),this.automaticBoisson(),5,prenom[i],surnom[i],500, 5, cri[i],bijou);

	  	return client;
	}
	public ClientHomme automaticClientHomme()				//  méthode de création d'une serveuse femme
	{
		String prenom[] = {"janette","alexa","katie","beverly"};	// tableau de prénoms de serveuses
		String surnom[]= {"Miss jane","al","kate","hills"};	
		String cri[]= {"oooohh","miaouh","voix aigue","voie grave"};
		
		int i= (int)Math.random()*3;
		Couleur color= Couleur.bleu ;
	  	ClientHomme client = new ClientHomme(this.automaticBoisson(),this.automaticBoisson(),5,prenom[i],surnom[i],500, 5, cri[i],color);

	  	return client;
	}
	public Barman automaticBarman()
	{
		Barman barman= new Barman("Thomas", "tom", 500, 8,"une commande une");
		
		return barman;
	}
	public Patronne automaticPatronne()
	{
		String prenom[] = {"janette","alexa","katie","beverly"};	// tableau de prénoms de serveuses
		String surnom[]= {"Miss jane","al","kate","hills"};	
		String cri[]= {"oooohh","miaouh","voix aigue","voie grave"};
		
		int i= (int)Math.random()*3;
		Bijoux bijou= Bijoux.couronne ;
		Patronne owner= new Patronne(this.automaticBoisson(),this.automaticBoisson(),5,prenom[i],surnom[i],500, 5, cri[i],bijou);
		
		return owner;
	}
	public ArrayList<Humain> automaticOccupantsList()		// on rajoute des personnages à la liste des occupants
	{
		ArrayList<Humain> occupants = new ArrayList<Humain>();
		for(int i=0; i< 4;i++)
		{
			occupants.add(automaticServeurFemme());
			occupants.add(automaticServeurHomme());
		}
		
		return occupants;
	}
	/* création et load de l'inventaire de boisson du bar*/
	public Boisson automaticBoisson()
	{
		String nom[] = {"Rince cochon","cuvée des trolls","coca","panaché"};	// tableau de prénoms de serveuses
		int quantite[]= {75,75,25,50};											// quantité en centilitre
		float prix[]= {7,5,8,3,2};												// prix de boissons
		boolean alcoolise[]= {true,true,false,false};							// alcoolise ou pas
		int i= (int)Math.random()*3;
		Boisson boisson= new Boisson(nom[i],quantite[i],prix[i],alcoolise[i]);
		
		return boisson;
	}
	public ArrayList<Boisson> automaticInventaire()  							// on rajoute les boissons à l'inventaire
	{
		ArrayList<Boisson> inventaire = new ArrayList<Boisson>();
		for(int i=0; i< 4;i++)
			inventaire.add(automaticBoisson());
	
		return inventaire;
	}
	
	
	
}

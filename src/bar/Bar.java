package bar;

import java.util.ArrayList;
import java.util.Random;

import tournoi.Equipe;
import tournoi.Tournoi;

/**
 * <b>Bar est la classe representant un bar.</b><br>
 * Un bar est caracterise par les informations suivantes :
 * <ul>
 * <li>Une caisse contenant tout l'argent du bar</li>
 * <li>Un nom</li>
 * <li>Une patronne</li>
 * <li>Un barman</li>
 * <li>Une capacite maximale d'occupants</li>
 * <li>Un nombre de tables</li>
 * <li>Un inventaire de toutes les boissons du bar</li>
 * <li>Une liste noire contenant tous les mauvais clients</li>
 * <li>Une liste de tous les occupants du bar</li>
 * <li>Une liste de tous les serveurs du Bar</li>
 * <li>Une liste des tournois qui se sont deroules dans le bar</li>
 * </ul>
 * 
 * @author Josias SEMANOU
 * @version 1.0
 */
public class Bar {
    
    /**
     * La caisse du bar
     */
    private static float caisse = 100000;
    
    /**
     * Le nom du bar
     */
    private String nom;
    
    /**
     * La patronne du bar
     */
    private Patronne patronne;
    
    /**
     * Le barman servant dans le bar
     */
    private static Barman barman;
    
    /**
     * La capacite maximale de personnes que le bar peut contenir
     */
    private int capaciteMax= 16;
    
    /**
     * Le nombre de tables presentes dans le bar
     */
    private int nbTables= 4;
    
    /**
     * La liste des boissons du bar
     */
    private static  ArrayList<Boisson> inventaire = new ArrayList<>();
    
    /**
     * La liste des personnes blacklistees dans le bar
     */
    private static ArrayList<Humain> listeNoire = new ArrayList<>();
    
    /**
     * La liste des personnes presentes dans le bar
     */
    private static ArrayList<Humain> occupants = new ArrayList<>();
    
    /**
     * La liste des serveurs du bar
     */
    private static ArrayList<Serveur> serveursList = new ArrayList<>();
    
    /**
     * La liste des clients du bar
     */
    private static ArrayList<Client> clientList = new ArrayList<Client>();
    
    /**
     * La liste des tournois qui se sont deroules dans le bar
     */
    private static ArrayList<Tournoi> tournamentList = new ArrayList<Tournoi>();
    
    /**
     * Constructeur simple de Bar
     * @param patronne
     * @param barman
     */
    public Bar(Patronne patronne, Barman barman) {
        this.nom = "Chez " + patronne.getPrenom();
        this.patronne = patronne;
        Bar.barman = barman;
    }
    
    public Patronne getPatronne() {
		return patronne;
	}

	public void setPatronne(Patronne patronne) {
		this.patronne = patronne;
	}

	public  void setBarman(Barman barman) {
		Bar.barman = barman;
	}

	public  ArrayList<Tournoi> getTournamentList() {
		return tournamentList;
	}

	public  void setTournamentList(ArrayList<Tournoi> tournamentList) {
		Bar.tournamentList = tournamentList;
	}

	public  ArrayList<Serveur> getServeursList() {
		return serveursList;
	}
	public void setServeursList(ArrayList<Serveur> serveurlist) {			// a� revoir l'utilite
        serveursList = serveurlist;
    }
	/**
     * Constructeur plus complet de Bar
     * @param name
     * @param barman
     * @param inventaire
     * @param occupants
     */
	public Bar()
	{}
    public Bar(String name,Patronne patronne, Barman barmaid, ArrayList<Boisson> inventair,ArrayList<Serveur> serveurss ,ArrayList<Humain> occupantss,ArrayList<Client> clients)
    {
        this.nom = name;
    	this.patronne= patronne;
    		 barman= barmaid;
    		 inventaire= inventair;
    		 serveursList= serveurss;
    		occupants= occupantss;
    		clientList= clients;
    		addTournament();
    }
    
    /**
     * 
     * @return la capacite maximale
     */
    public int getCapaciteMax() {
        return capaciteMax;
    }
    
    /**
     * Modifie la capacite maximale
     * @param capaciteMax
     */
    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }
    
    /**
     * @return le nombre de tables
     */
    public int getNbTables() {
        return nbTables;
    }
    
    /**
     * Modifie le nombre de tables
     * 
     * @param nbTables
     */
    public void setNbTables(int nbTables) {
        this.nbTables = nbTables;
    }
    
    /**
     * @return la liste des boissons
     */
    public ArrayList<Boisson> getInventaire() {
        return inventaire;
    }
    
    /**
     * @return le nom du bar
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return Le barman en charge du bar
     */
    public  Barman getBarman() {
        return barman;
    }
    
    /**
     * @return La liste des clients
     */
    public  ArrayList<Client> getClientList() {
        return clientList;
    }
    
    public void setClientList(ArrayList<Client> clientlist) {			// a� revoir l'utilite
        clientList = clientlist;
    }
    /**
     * @return Un serveur de maniere aleatoire
     */
    public  Serveur getOneServeur() {
        Random rand = new Random(); 
        return serveursList.get(rand.nextInt(serveursList.size()));
    }

    /**
     * @return La caisse du bar
     */
    public  float getCaisse() {
        return caisse;
    }

    /**
     * Modifie l'inventaire
     * 
     * @param Inventaire
     */
    public void setInventaire(ArrayList<Boisson> Inventaire) {       // a� revoir l'utilite
        inventaire = Inventaire;
    }

    /**
     * Modifie la caisse
     * 
     * @param caisse
     */
    public static void setCaisse(float caisse) {
        Bar.caisse = caisse;
    }

    /**
     * Ajoute une boisson a l'inventaire
     * 
     * @param boisson
     */
    public void addToInventaire(Boisson boisson) {
        inventaire.add(boisson);
    }

    /**
     * Retire une boisson de l'inventaire
     * 
     * @param boisson
     */
    public void removeFromInventaire(Boisson boisson) {
        inventaire.remove(boisson);
    }

    /**
     * @return La liste des clients interdits de consommation
     */
    public ArrayList<Humain> getListeNoire() {
        return listeNoire;
    }

    /**
     * Modifie la liste noire
     * 
     * @param ListeNoire
     */
    public void setListeNoire(ArrayList<Humain> ListeNoire) {
        listeNoire = ListeNoire;
    }

    /**
     * Ajoute un client a la liste noire
     * 
     * @param c
     */
    public static void addToListeNoire(Client c) {
        Bar.listeNoire.add(c);
    }

    /**
     * Retire un client de la liste noire
     * 
     * @param c
     */
    public static void removeFromListeNoire(Client c) {
        Bar.listeNoire.remove(c);
    }

    /**
     * Modifie le nom
     * 
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    
	
	// OCCUPANTS
    /**
     * affiche la liste des occupants du bar
     */
    public void displayOccupantsList() {
    	System.out.println("la liste des occupants du bar ma poulette");
    	for(int i=0;i < occupants.size();i++)
		{
			System.out.println(i+"- "+occupants.get(i).getPrenom());
		}
    }
    /**
     * affiche la liste des serveurs du bar
     */
    public void displayServeursList() {
    	System.out.println("la liste des serveurs du bar ma poulette");
    	for(int i=0;i < serveursList.size();i++)
		{
			System.out.println(i+"- "+serveursList.get(i).getPrenom());
		}
    }
    /**
     * @return La liste des occupants du bar
     */
    public ArrayList<Humain> getOccupants()								
    {
    	return occupants;
    }
    
    /**
     * Modifie la liste des occupants
     * 
     * @param Occupants
     */
    public void setOccupants(ArrayList<Humain> Occupants) {			// a� revoir l'utilite
        occupants = Occupants;
    }

    /**
     * Ajoute un humain a la liste des occupants du bar
     * 
     * @param humain
     */
    public static void addOccupant(Humain humain) {
        Bar.occupants.add(humain);
    }

    /**
     * Retire un humain de la liste des occupants du bar
     * 
     * @param humain
     */
    public static void removeOccupant(Humain humain) {
        occupants.remove(humain);
    }
    
    
    //SERVEURS
    /**
     * Ajoute un serveur a la liste des serveurs du bar
     * 
     * @param serveur
     */
    public static void addServeurs(Serveur serveur) {
        serveursList.add(serveur);
    }

    /**
     * Retire un serveur de la liste des serveurs du bar
     * 
     * @param serveur
     */
    public static void removeServeurs(Serveur serveur) {
        serveursList.remove(serveur);
    }
    
    // INVENTAIRE
    /**
     * Recuperation de l'inventaire depuis la db
     */
    public void loadInventaire()
    {
    	
    }
    
    /* methodes utiles*/
    /**
     * Affichage de la liste des tournois dans le bar
     */
    public void displayTournamentList()
	{ 
    	System.out.println("liste des tournois dans le bar") ;
    	for(int i=0;i < tournamentList.size();i++)
    	{
    		System.out.println(i+"- tournoi: "+tournamentList.get(i).getName()+"  date: "+tournamentList.get(i).getDayOfTournament()+
    				"  statut: "+tournamentList.get(i).getState());
    		
    	}
	}
	
	/**
	 * @return Un tournoi
	 */
	public Tournoi automaticTournament()			// creer un tournoi
	{
		Tournoi tournament= new Tournoi("Standard",5000,500,"la bataille des rois",automaticTeamList()); 
		return tournament;
	}
	
	/**
	 * Ajout de tournoi a la liste
	 */
	public void addTournament()	
	{
		tournamentList.add(automaticTournament());
	}
	
    // creation d'equipes
    /**
     * @return Une equipe
     */
    public Equipe createTeam()				// on cree une equipe
	{
		Equipe team= new Equipe("winners",automaticPlayerList());
		
		return team;
	}
    
    /**
     * 
     */
    public void addTeam() 				// a voir au niveau de la classe equipe ou tournoi
    {
    	
    }
	/**
	 * @return Une liste d'equipes
	 */
	public ArrayList<Equipe> automaticTeamList()// on ajoute une equipe a� la liste des equipes
	{
		ArrayList<Equipe> teamList =new ArrayList<Equipe>();
		for(int i = 0;i < 2;i++)
			teamList.add(createTeam());				// on ajoute les equipes crees dans la liste des equipes
		
		return teamList;
	}
	// inscription de joueurs
	
	/**
	 * 
	 */
	public void addPlayer()				// a voir au niveau de la classe equipe ou tournoi
	{
		
	}
	
	/**
	 * @return Une liste de joueurs
	 */
	public ArrayList<Humain> automaticPlayerList()
	{
		int nb =0;
		Random r= new Random();
		ArrayList<Humain> playerList= new ArrayList<Humain>();
		do {
			
			if(!playerList.contains(clientList.get(nb)))
				playerList.add(clientList.get(nb));
			if(!playerList.contains(serveursList.get(nb)))
				playerList.add(serveursList.get(nb));
		}while(playerList.size() < 2);
		
		return playerList;
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bar;

import java.util.ArrayList;
import java.util.Random;

import tournoi.Equipe;
import tournoi.Tournoi;

/**
 *
 * @author USER
 */
public class Bar {

    private static float caisse = 100000;
    private String nom;
    private Patronne patronne;
    private Barman barman;
    private int capaciteMax= 16;								// capacité maximale du bar
    private int nbTables= 4;									// nombre de tables dans le bar
    public  ArrayList<Boisson> inventaire = new ArrayList<>();
    private ArrayList<Humain> listeNoire = new ArrayList<>();
    private ArrayList<Humain> occupants = new ArrayList<>();
    private static ArrayList<Serveur> Serveurs = new ArrayList<>();
    private static ArrayList<Tournoi> tournamentList = new ArrayList<Tournoi>(); // liste des tournois qui se sont déroulés dans le bar
    
    public Bar(String nom, Patronne patronne) {
        this.nom = nom;
        this.patronne = patronne;
    }
    public Bar(String nom, Patronne patronne,Barman barman, ArrayList<Boisson> inventaire,ArrayList<Humain> occupants)
    {
    	this.nom= nom;
    	this.patronne= patronne;
    	this.barman= barman;
    	this.inventaire= inventaire;
    	this.occupants= occupants;
    }
    
    public int getCapaciteMax() {
		return capaciteMax;
	}
	public void setCapaciteMax(int capaciteMax) {
		this.capaciteMax = capaciteMax;
	}
	public int getNbTables() {
		return nbTables;
	}
	public void setNbTables(int nbTables) {
		this.nbTables = nbTables;
	}
	public ArrayList<Boisson> getInventaire() {
        return inventaire;
    }

    public  Barman getBarman() {
        return barman;
    }

    public static ArrayList<Serveur> getServeurs() {
        return Serveurs;
    }

    public static Serveur getOneServeur() {
        Random rand = new Random(); 
        return Serveurs.get(rand.nextInt(Serveurs.size()));
    }

    public static float getCaisse() {
        return caisse;
    }

    public void setInventaire(ArrayList<Boisson> Inventaire) {       // à revoir l'utilité
        inventaire = Inventaire;
    }

    public static void setCaisse(float caisse) {
        Bar.caisse = caisse;
    }

    public void addToInventaire(Boisson boisson) {
        this.inventaire.add(boisson);
    }

    public void removeFromInventaire(Boisson boisson) {
        this.inventaire.remove(boisson);
    }

    public ArrayList<Humain> getListeNoire() {
        return listeNoire;
    }

    public void setListeNoire(ArrayList<Humain> ListeNoire) {
        this.listeNoire = ListeNoire;
    }

    public void addToListeNoire( Humain h) {
        this.listeNoire.add(h);
    }

    public void removeFromListeNoire(Humain h) {
        this.listeNoire.remove(h);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    
	
	// OCCUPANTS
    public void displayOccupants() {										// on affiche la liste des occupants du bar
    	System.out.println("la liste des occupants du bar ma poulette");
    	for(int i=0;i < this.occupants.size();i++)
    		System.out.println(this.occupants.get(i));
    }
    
    public ArrayList<Humain> getOccupants()								
    {
    	return this.occupants;
    }
    public void setOccupants(ArrayList<Humain> Occupants) {			// à revoir l'utilité
        this.occupants = Occupants;
    }
    
    
    //SERVEURS
    public static void addServeurs(Serveur serveur) {
        Serveurs.add(serveur);
    }

    public static void removeServeurs(Serveur serveur) {
        Serveurs.remove(serveur);
    }
    // INVENTAIRE
    public void loadInventaire()				// on récupère l'inventaire de la db
    {
    	
    }
    /* méthodes utiles*/
    public void displayTournamentList()
	{ 
    	System.out.println("liste des tournois dans le bar") ;
    	for(int i=0;i < tournamentList.size();i++)
    		System.out.println(tournamentList.get(i).getName());
	}
	public void startTournament() 			// commencer un tournoi
	{
		
	}
	public Tournoi automaticTournament()			// créer un tournoi
	{
		Tournoi tournament= new Tournoi("Standard",5000,500,"la bataille des rois",automaticTeamList());
		
		return tournament;
	}
	public void addTournament()	// méthode d'ajout de tournoi à liste
	{
		tournamentList.add(automaticTournament());
	}
    // creation d'équipes
    public Equipe createTeam()				// on crée une équipe
	{
		Equipe team= new Equipe("winners",automaticPlayerList());
		
		return team;
	}
    public void addTeam() 				// à voir au niveau de la classe equipe ou tournoi
    {
    	
    }
	public ArrayList<Equipe> automaticTeamList()// on ajoute une équipe à la liste des équipes
	{
		ArrayList<Equipe> teamList =new ArrayList<Equipe>();
		for(int i = 0;i < 2;i++)
			teamList.add(createTeam());				// on ajoute les équipes crées dans la liste des équipes
		
		return teamList;
	}
	// inscription de joueurs
	
	public void addPlayer()				// à voir au niveau de la classe equipe ou tournoi
	{
		
	}
	public ArrayList<Humain> automaticPlayerList()
	{
		int nb =0;
		ArrayList<Humain> playerList= new ArrayList<Humain>();
		do {
			nb= (int)Math.random()* playerList.size();
			if((occupants.get(nb).getClass().getName() != "Barman") && (occupants.get(nb).getClass().getName() != "Fournisseur")&& (occupants.get(nb).getClass().getName() != "Patronne"))
				playerList.add(occupants.get(nb));
		}while(playerList.size() < 2);
		
		return playerList;
	}
}

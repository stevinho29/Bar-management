/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bar;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author USER
 */
public class Bar {

    private static float caisse = 100000;
    private String nom;
    private Patronne patronne;
    private static Barman barman;
    public static ArrayList<Boisson> Inventaire = new ArrayList<>();
    public ArrayList<Humain> ListeNoire = new ArrayList<>();
    public ArrayList<Humain> Occupants = new ArrayList<>();
    public static ArrayList<Serveur> Serveurs = new ArrayList<>();

    public Bar(String nom, Patronne patronne) {
        this.nom = nom;
        this.patronne = patronne;
    }

    public ArrayList<Boisson> getInventaire() {
        return Inventaire;
    }

    public static Barman getBarman() {
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

    public void setInventaire(ArrayList<Boisson> Inventaire) {
        Bar.Inventaire = Inventaire;
    }

    public static void setCaisse(float caisse) {
        Bar.caisse = caisse;
    }

    public void addToInventaire(Boisson boisson) {
        Bar.Inventaire.add(boisson);
    }

    public void removeFromInventaire(Boisson boisson) {
        Bar.Inventaire.remove(boisson);
    }

    public ArrayList<Humain> getListeNoire() {
        return ListeNoire;
    }

    public void setListeNoire(ArrayList<Humain> ListeNoire) {
        this.ListeNoire = ListeNoire;
    }

    public void addToListeNoire( Humain h) {
        this.ListeNoire.add(h);
    }

    public void removeFromListeNoire(Humain h) {
        this.ListeNoire.remove(h);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Humain> getOccupants() {
        return Occupants;
    }

    public void setOccupants(ArrayList<Humain> Occupants) {
        this.Occupants = Occupants;
    }

    public static void addServeur(Serveur serveur) {
        Serveurs.add(serveur);
    }

    public static void removeServeur(Serveur serveur) {
        Serveurs.remove(serveur);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bar;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Boisson {
    private String nom;
    private int quantite;
    private float prix;
    private boolean alcoolise;
    private static ArrayList carte = new ArrayList();

    public Boisson(String nom, int quantite, float prix, boolean alcoolise) {
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
        this.alcoolise = alcoolise;
        carte.add(this);
    }

    public static ArrayList getCarte() {
        return Boisson.carte;
    }

    public String getNom() {
        return nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public float getPrix() {
        return prix;
    }

    public boolean isAlcoolise() {
        return alcoolise;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setAlcoolise(boolean alcoolise) {
        this.alcoolise = alcoolise;
    }
    
    @Override
    protected Boisson clone(){
        return new Boisson(nom, quantite, prix, alcoolise);
    }
    
    
}

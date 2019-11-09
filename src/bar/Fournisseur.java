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
public class Fournisseur extends Humain {
    
    private float prixCommande = 0;
    private ArrayList<Boisson> stockFournisseur = new ArrayList<>();
    private ArrayList<Boisson> commandeBoissons = new ArrayList<>();

    public Fournisseur(String prenom, String surnom, int porteMonnaie, int cotePopularite, String criSignificatif) {
        super(prenom, surnom, porteMonnaie, cotePopularite, criSignificatif);
    }
    
    public float calculerPrix(ArrayList<Boisson> listeBoissons){
        listeBoissons.forEach((boisson) -> {
            if(stockFournisseur.contains(boisson)){// si boisson présente en stock, augmenter prix commande selon prix de vente fournisseur
                prixCommande += boisson.getQuantite() * stockFournisseur.get(stockFournisseur.indexOf(boisson)).getPrix();
                commandeBoissons.add(boisson);
            }
        });
        return  prixCommande;
    }
    
    public void livrerBoissons(){
        commandeBoissons.forEach((boisson) -> {
            //malus de la quantite fournie sur le stock
            stockFournisseur.get(stockFournisseur.indexOf(boisson)).setQuantite(stockFournisseur.get(stockFournisseur.indexOf(boisson)).getQuantite()-boisson.getQuantite());
        });
        //récupération du paiement
        this.setPorteMonnaie(porteMonnaie + prixCommande);
        prixCommande = 0;
    }
}

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
public class Barman extends Humain {
    
    private Bar barEnCharge;

    public Barman(String prenom, String surnom, int porteMonnaie, int cotePopularite, String criSignificatif) {
        super(prenom, surnom, porteMonnaie, cotePopularite, criSignificatif);
    }
    
    public void vendreBoisson(Boisson boisson, int quantite, Humain bayeur, Humain beneficiaire){
        if(Bar.Inventaire.contains(boisson)){
            Boisson boissonDuBar = Bar.Inventaire.get(Bar.Inventaire.indexOf(boisson));
            if (boissonDuBar.getQuantite() >= quantite) {// si il y a assez de boisson dans le stock
                float coutTotal = boissonDuBar.getPrix() * quantite;
                if (bayeur.getPorteMonnaie() >= coutTotal) {// si celui qui offre la boisson a assez d'argent pour payer sa commande
                    bayeur.setPorteMonnaie(bayeur.getPorteMonnaie() - coutTotal);// retirer le cout de son portemonnaie
                    beneficiaire.setContenuVerre(quantite);//servir la quantite nécessaire dans le verre du bénéficiaire
                    beneficiaire.setBoissonVerre(boisson);//indiquer la boisson servie dans le verre
                }else{// sinon pas assez d'argent
                    System.out.println("Vous n'avez pas assez pour acheter " + quantite + " Litres de " + boisson.getNom());
                }
            }else{// sinon pas assez de boisson
                System.out.println("Nous n'avons pas assez de " + boissonDuBar.getNom() + ". Il n'en reste que " + boissonDuBar.getQuantite() + " Litres.");
            }
        }else{
            System.out.println("Il n'y a pas cette boisson dans notre bar !!");
        }
    }
    
    public void commanderBoissons(Fournisseur fournisseur){
        float prix = 0;
        ArrayList<Boisson> commande = new ArrayList<>();
        Bar.Inventaire.forEach((boisson) -> {
            if(boisson.getQuantite() < 20){
                Boisson boissonACommander = boisson.clone();
                commande.add(boissonACommander);
            }
        });
        prix = fournisseur.calculerPrix(commande);
        if(prix < Bar.getCaisse()){
            Bar.setCaisse(Bar.getCaisse() - prix);
            fournisseur.livrerBoissons();
        }
    }

    @Override
    public void boire() {//Uniquement de l'eau
        if(this.boissonVerre.getNom().equals("EAU") && (!this.boissonVerre.isAlcoolise()))
            super.boire();
    }

    @Override
    public void presentMyself() {
        super.presentMyself();
        System.out.println("Coco");
    }

    @Override
    public void parler(String message) {
        super.parler(message + " coco");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bar;

/**
 *
 * @author USER
 */
public class Serveur extends Humain {

    public Serveur(String prenom, String surnom, int porteMonnaie, int cotePopularite, String criSignificatif) {
        super(prenom, surnom, porteMonnaie, cotePopularite, criSignificatif);
    }
    
    @Override
    public void boire() {//Uniquement de l'eau
        if(this.boissonVerre.getNom().equals("EAU") && (!this.boissonVerre.isAlcoolise()))
            super.boire();
    }
    
    public void servirClient(Boisson boisson, int quantite, Humain clientADebiter, Humain clientAServir) {
        Bar.getBarman().vendreBoisson(boisson, quantite, clientADebiter, clientAServir);
    }
    
}

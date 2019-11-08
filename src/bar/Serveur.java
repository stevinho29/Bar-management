/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bar;

import java.util.ArrayList;

import tournoi.Utilisateur;

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
        getBar().getBarman().vendreBoisson(boisson, quantite, clientADebiter, clientAServir);
    }
    // on récupère le bar dans lequel le serveur se trouve
    public Bar getBar()
    {
    	Bar bar=null;
    	ArrayList<Bar> barlist= Utilisateur.getBarList();
    		for(int i= 0 ;i <barlist.size();i++ )
    		{
    			if(barlist.get(i).getOccupants().contains(this))
    				bar= barlist.get(i);
    		}
    	return bar;
    }
    
}

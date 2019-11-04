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
public class ServeurFemme extends Serveur{
    
    int coefficientCharme;
    
    public ServeurFemme(String prenom, String surnom, int porteMonnaie, int cotePopularite, String criSignificatif, int coefficientCharme) {
        super(prenom, surnom, porteMonnaie, cotePopularite, criSignificatif);
        this.coefficientCharme = coefficientCharme;
    }
    
}

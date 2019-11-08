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
public class ServeurHomme extends Serveur {
    
    private int tailleBiceps;

    public ServeurHomme(String prenom, String surnom, int porteMonnaie, int cotePopularite, String criSignificatif, int tailleBiceps) {
        super(prenom, surnom, porteMonnaie, cotePopularite, criSignificatif);
        this.tailleBiceps = tailleBiceps;
    }
    
}

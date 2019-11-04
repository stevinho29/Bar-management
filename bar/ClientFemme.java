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
public class ClientFemme extends Client {
    
    private Bijoux bijou; 
    
    public ClientFemme(Boisson boissonFavorite, Boisson boissonDeSecours, int niveauAlcoolemie, String prenom, String surnom, int porteMonnaie, int cotePopularite, String criSignificatif, Bijoux bijou) {
        super(boissonFavorite, boissonDeSecours, niveauAlcoolemie, prenom, surnom, porteMonnaie, cotePopularite, criSignificatif);
        this.bijou = bijou;
    }

    public Bijoux getBijou() {
        return bijou;
    }

    public void setBijou(Bijoux bijou) {
        this.bijou = bijou;
    }

    public ClientHomme devenirHomme(Couleur tshirt) {
        return new ClientHomme(boissonFavorite, boissonDeSecours, niveauAlcoolemie, prenom, surnom, cotePopularite, cotePopularite, criSignificatif, tshirt);
    }

    @Override
    public void parler(String message) {//message adressé à tous
        if (this.niveauAlcoolemie > 10)
            super.parler(message + " mon mignon");
        else
            super.parler(message);
    }
    
}

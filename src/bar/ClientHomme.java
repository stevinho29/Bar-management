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
public class ClientHomme extends Client {
    
    private Couleur couleurTShirt;

    public ClientHomme(Boisson boissonFavorite, Boisson boissonDeSecours, int niveauAlcoolemie, String prenom, String surnom, int porteMonnaie, int cotePopularite, String criSignificatif, Couleur tshirt) {
        super(boissonFavorite, boissonDeSecours, niveauAlcoolemie, prenom, surnom, porteMonnaie, cotePopularite, criSignificatif);
        this.couleurTShirt = tshirt;
    }

    public Couleur getCouleurTShirt() {
        return couleurTShirt;
    }

    public void setCouleurTShirt(Couleur couleurTShirt) {
        this.couleurTShirt = couleurTShirt;
    }
    
    public ClientFemme devenirFemme(Bijoux bijou) {
        return new ClientFemme(boissonFavorite, boissonDeSecours, niveauAlcoolemie, prenom, surnom, cotePopularite, cotePopularite, criSignificatif, bijou);
    }

    @Override
    public void parler(String message) {//message adressé à tous
        if (this.niveauAlcoolemie > 10)
           super.parler(message + " Poupée");
        else
            super.parler(message);
    }
    
}

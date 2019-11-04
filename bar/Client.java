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
public class Client extends Humain {
    
    protected Boisson boissonFavorite;
    protected Boisson boissonDeSecours;
    protected int niveauAlcoolemie;

    public Client(Boisson boissonFavorite, Boisson boissonDeSecours, int niveauAlcoolemie, String prenom, String surnom, int porteMonnaie, int cotePopularite, String criSignificatif) {
        super(prenom, surnom, porteMonnaie, cotePopularite, criSignificatif);
        this.boissonFavorite = boissonFavorite;
        this.boissonDeSecours = boissonDeSecours;
        this.niveauAlcoolemie = niveauAlcoolemie;
    }

    public Boisson getBoissonFavorite() {
        return boissonFavorite;
    }

    public Boisson getBoissonDeSecours() {
        return boissonDeSecours;
    }

    public int getNiveauAlcoolemie() {
        return niveauAlcoolemie;
    }

    public void setBoissonFavorite(Boisson boissonFavorite) {
        this.boissonFavorite = boissonFavorite;
    }

    public void setBoissonDeSecours(Boisson boissonDeSecours) {
        this.boissonDeSecours = boissonDeSecours;
    }

    public void setNiveauAlcoolemie(int niveauAlcoolemie) {
        this.niveauAlcoolemie = niveauAlcoolemie;
    }
    
    public void getDrinks(Humain humain, int quantite) { // se faire offrir un verre par quelqu'un __ toujours sa boisson favorite
        humain.offerDrinks(boissonFavorite, quantite, this);
    }
    
    public void otherPresentation() {// se présenter autrement
        System.out.println(criSignificatif + "!!!!!");
        System.out.println("Officiellement je suis, " + prenom + "; on m'appelle aussi " + surnom + ". Il ne me reste plus que " + porteMonnaie + " euros en poche.");
    }

    @Override
    public void boire() {
        int contenuInitial = this.contenuVerre;
        super.boire();
        if(contenuInitial != this.contenuVerre && this.boissonVerre.isAlcoolise())// NiveauAlcoolemie augmenté seulement si boisson alcoolisée
            this.setNiveauAlcoolemie(this.getNiveauAlcoolemie() +1);
    }

    public void payer(int quantite) {
        super.payer(boissonFavorite, quantite);
    }
    
}


/**
 * Décrivez votre classe Client ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Client extends Humain {
    
    protected String boissonFavorite;
    protected String boissonDeSecours;
    protected int niveauAlcoolemie;

    public Client(String boissonFavorite, String boissonDeSecours, int niveauAlcoolemie, String prenom, String surnom, int porteMonnaie, int cotePopularite, String criSignificatif) {
        super(prenom, surnom, porteMonnaie, cotePopularite, criSignificatif);
        this.boissonFavorite = boissonFavorite;
        this.boissonDeSecours = boissonDeSecours;
        this.niveauAlcoolemie = niveauAlcoolemie;
    }

    public String getBoissonFavorite() {
        return boissonFavorite;
    }

    public String getBoissonDeSecours() {
        return boissonDeSecours;
    }

    public int getNiveauAlcoolemie() {
        return niveauAlcoolemie;
    }

    public void setBoissonFavorite(String boissonFavorite) {
        this.boissonFavorite = boissonFavorite;
    }

    public void setBoissonDeSecours(String boissonDeSecours) {
        this.boissonDeSecours = boissonDeSecours;
    }

    public void setNiveauAlcoolemie(int niveauAlcoolemie) {
        this.niveauAlcoolemie = niveauAlcoolemie;
    }
    
    public void getDrinks(Humain humain, Boisson boisson, int quantite, Barman barman) { // se faire offrir un verre par quelqu'un
        humain.offerDrinks(boisson, quantite, barman, this);
    }
    
    public void otherPresentation() {// se présenter autrement
        System.out.println(criSignificatif + "!!!!!");
        System.out.println("Officiellement je suis, " + prenom + "; on m'appelle aussi " + surnom + ". Il ne me reste plus que " + porteMonnaie + " euros en poche.");
    }

    @Override
    public void boire() {
        int contenuInitial = this.contenuVerre;
        super.boire();
        if(contenuInitial != this.contenuVerre)
            this.setNiveauAlcoolemie(this.getNiveauAlcoolemie() +1);// ne prend pas en compte le fait que la boisson soit alcoolisée ou pas
    }
    
}
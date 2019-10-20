
/**
 * Décrivez votre classe Client ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Client extends Humain implements Homme, Femme{
    
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
    
    public void getDrinks() // se faire offrir un verre
    {
        
    }
    public void otherPresentation() {// se présenter autrement
        System.out.println(criSignificatif + "!!!!!");
        System.out.println("Moi, " + prenom + " aussi appelé " + surnom + ". Il ne me reste plus que " + porteMonnaie + " euros en poche.");
    }
    @Override
    public void caracteristiqueHomme() {}

    @Override
    public void caracteristiqueFemme() {}
    
}
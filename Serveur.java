
/**
 * Décrivez votre classe Serveur ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Serveur extends Humain implements Homme, Femme{

    public Serveur(String prenom, String surnom, int porteMonnaie, int cotePopularite, String criSignificatif) {
        super(prenom, surnom, porteMonnaie, cotePopularite, criSignificatif);
    }
    
    @Override
    public void caracteristiqueHomme() {}

    @Override
    public void caracteristiqueFemme() {}
    
}

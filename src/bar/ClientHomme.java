package bar;

/**
 * <b>ClientHomme est la classe representant un client homme.</b><br>
 * Un client homme est caracterise par :
 * <ul>
 * <li>Un prenom</li>
 * <li>Un surnom</li>
 * <li>Un porte-monnaie</li>
 * <li>Une cote de popularite</li>
 * <li>Un cri significatif</li>
 * <li>Le contenu de son verre</li>
 * <li>La boisson presente dans son verre</li>
 * <li>Une boisson favorite </li>
 * <li>Une boisson de secours</li>
 * <li>Un niveau d'alcoolemie</li>
 * <li>Une couleur de t-shirt</li>
 * </ul>
 * 
 * @author Josias SEMANOU
 * @version 1.0
 */
public class ClientHomme extends Client {
    
    /**
     * La couleur du t-shirt porte par le client homme
     */
    private Couleur couleurTShirt;
    
    /**
     * Constructeur de ClientHomme
     * 
     * @param boissonFavorite
     * @param boissonDeSecours
     * @param niveauAlcoolemie
     * @param prenom
     * @param surnom
     * @param porteMonnaie
     * @param cotePopularite
     * @param criSignificatif
     * @param tshirt
     */
    public ClientHomme(Boisson boissonFavorite, Boisson boissonDeSecours, int niveauAlcoolemie, String prenom, String surnom, float porteMonnaie, int cotePopularite, String criSignificatif, Couleur tshirt) {
        super(boissonFavorite, boissonDeSecours, niveauAlcoolemie, prenom, surnom, porteMonnaie, cotePopularite, criSignificatif);
        this.couleurTShirt = tshirt;
    }

    /**
     * @return La couleur du t-shirt porte par le client
     */
    public Couleur getCouleurTShirt() {
        return couleurTShirt;
    }

    /**
     * Modifie la couleur du t-shirt porte par le client
     * 
     * @param couleurTShirt
     */
    public void setCouleurTShirt(Couleur couleurTShirt) {
        this.couleurTShirt = couleurTShirt;
    }
    
    /**
     * Transforme un client en cliente
     * 
     * @param bijou
     * @return Une cliente femme
     */
    public ClientFemme devenirFemme(Bijoux bijou) {
        return new ClientFemme(boissonFavorite, boissonDeSecours, niveauAlcoolemie, prenom, surnom, cotePopularite, cotePopularite, criSignificatif, bijou);
    }

    /**
     * Quand le client parle
     * 
     * @see bar.Humain#parler(java.lang.String)
     */
    @Override
    public void parler(String message) {//message adresse Ã  tous
        if (this.niveauAlcoolemie > 10)
           super.parler(message + " Poupée");
        else
            super.parler(message);
    }
    
    /**
     * Retourne une chaine de caractere caracterisant le client
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "\nJe suis " + prenom + " aussi appele " + surnom + ". Il me reste " + porteMonnaie 
                + " euros en poche qui partiront surement en verres de " + boissonFavorite.getNom() + ". "
                + criSignificatif + " !!!! Je porte un t-shirt " + couleurTShirt;
    }
    
}

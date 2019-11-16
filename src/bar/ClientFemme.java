package bar;

/**
 * <b>ClientFemme est la classe representant une cliente.</b><br>
 * Une cliente est caracterisee par :
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
 * <li>Un bijou</li>
 * </ul>
 * 
 * @author Josias SEMANOU
 * @version 1.0
 */
public class ClientFemme extends Client {
    
    /**
     * Le bijou que porte la cliente
     */
    private Bijoux bijou;
    
    /**
     * Constructeur de ClientFemme
     * 
     * @param boissonFavorite
     * @param boissonDeSecours
     * @param niveauAlcoolemie
     * @param prenom
     * @param surnom
     * @param porteMonnaie
     * @param cotePopularite
     * @param criSignificatif
     * @param bijou
     */
    public ClientFemme(Boisson boissonFavorite, Boisson boissonDeSecours, int niveauAlcoolemie, String prenom, String surnom, float porteMonnaie, int cotePopularite, String criSignificatif, Bijoux bijou) {
        super(boissonFavorite, boissonDeSecours, niveauAlcoolemie, prenom, surnom, porteMonnaie, cotePopularite, criSignificatif);
        this.bijou = bijou;
    }

    /**
     * @return Le bijou porte par la cliente
     */
    public Bijoux getBijou() {
        return bijou;
    }

    /**
     * Modifie le bijou porte par la cliente
     * @param bijou
     */
    public void setBijou(Bijoux bijou) {
        this.bijou = bijou;
    }

    /**
     * Transforme une cliente en client
     * 
     * @param tshirt
     * @return Un client homme
     */
    public ClientHomme devenirHomme(Couleur tshirt) {
        return new ClientHomme(boissonFavorite, boissonDeSecours, niveauAlcoolemie, prenom, surnom, cotePopularite, cotePopularite, criSignificatif, tshirt);
    }

    /**
     * Quand la cliente parle
     * 
     * @see bar.Humain#parler(java.lang.String)
     */
    @Override
    public void parler(String message) {
        if (this.niveauAlcoolemie > 10)
            super.parler(message + " mon mignon");
        else
            super.parler(message);
    }
    
    /**
     * Retourne une chaine de caractere caracterisant la cliente
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "\nJe suis " + prenom + " aussi appele " + surnom + ". Il me reste " + porteMonnaie 
                + " euros en poche qui partiront surement en verres de " + boissonFavorite.getNom() + ". "
                + criSignificatif + " !!!! Je porte comme bijou un(e) " + bijou;
    }
    
}

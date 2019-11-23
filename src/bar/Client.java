package bar;

/**
 * <b>Client est la classe representant un client.</b><br>
 * Un client est caracterise par :
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
 * </ul>
 * 
 * @author Josias SEMANOU
 * @version 1.0
 */
public abstract class Client extends Humain {
    
    /**
     * La boisson favorite du client
     */
    protected Boisson boissonFavorite;
    
    /**
     * La boisson de secours du client
     */
    protected Boisson boissonDeSecours;
    
    /**
     * Le niveau d'alcoolemie du client
     */
    protected int niveauAlcoolemie;

    /**
     * Constructeur de Client
     * 
     * @param boissonFavorite
     * @param boissonDeSecours
     * @param niveauAlcoolemie
     * @param prenom
     * @param surnom
     * @param porteMonnaie
     * @param cotePopularite
     * @param criSignificatif
     */

    public Client(Boisson boissonFavorite, Boisson boissonDeSecours, int niveauAlcoolemie, String prenom, String surnom, float porteMonnaie, int cotePopularite, String criSignificatif) {
        super(prenom, surnom, porteMonnaie, cotePopularite, criSignificatif);
        this.boissonFavorite = boissonFavorite;
        this.boissonDeSecours = boissonDeSecours;
        this.niveauAlcoolemie = niveauAlcoolemie;
    }

    /**
     * @return La boisson favorite du client
     */
    public Boisson getBoissonFavorite() {
        return boissonFavorite;
    }

    /**
     * @return La boisson de secours du client
     */
    public Boisson getBoissonDeSecours() {
        return boissonDeSecours;
    }

    /** 
     * @return Le niveau d'alcoolemie du client
     */
    public int getNiveauAlcoolemie() {
        return niveauAlcoolemie;
    }

    /**
     * Modifie la boisson favorite du client
     * 
     * @param boissonFavorite
     */
    public void setBoissonFavorite(Boisson boissonFavorite) {
        this.boissonFavorite = boissonFavorite;
    }

    /**
     * Modifie la boisson de secours du client
     * 
     * @param boissonDeSecours
     */
    public void setBoissonDeSecours(Boisson boissonDeSecours) {
        this.boissonDeSecours = boissonDeSecours;
    }

    /**
     * Modifie le niveau d'alcoolemie du client
     * 
     * @param niveauAlcoolemie
     */
    public void setNiveauAlcoolemie(int niveauAlcoolemie) {
        this.niveauAlcoolemie = niveauAlcoolemie;
    }
    
    /**
     * Se faire offrir un verre par quelqu'un 
     * Toujours sa boisson favorite
     * 
     * @param humain
     * @param quantite
     */
    public void getDrinks(Humain humain, int quantite,Bar bar) {
        humain.offerDrinks(boissonFavorite, quantite, humain,bar);
    }
    
    /**
     * Pour se presenter autrement
     */
    public void otherPresentation() {
        System.out.println(criSignificatif + "!!!!!");
        System.out.println("Officiellement je suis, " + prenom + "; on m'appelle aussi " + surnom + ". Il ne me reste plus que " + porteMonnaie + " euros en poche.");
    }

    /**
     * Boire le contenu de son verre
     * 
     * @see bar.Humain#boire()
     */
    @Override
    public void boire() {
        int contenuInitial = this.contenuVerre;
        super.boire();
        if(contenuInitial != this.contenuVerre && this.boissonVerre.isAlcoolise())// NiveauAlcoolemie augmente seulement si boisson alcoolisee
            this.setNiveauAlcoolemie(this.getNiveauAlcoolemie() +1);
    }

    /**
     * Se payer une boisson a boire
     * 
     * @param quantite d
     */
    public void payer(int quantite,Bar bar) {
        super.payer(boissonFavorite, quantite, bar);
    }
    
}

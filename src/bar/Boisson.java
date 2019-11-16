package bar;

/**
 * <b>Boisson est la classe representant une boisson.</b><br>
 * Une boisson est caracterisee par :
 * <ul>
 * <li>Un nom</li>
 * <li>Une quantite</li>
 * <li>Un prix de vente</li>
 * <li>Un prix d'achat</li>
 * <li>Un etat, alcoolisee ou pas</li>
 * </ul>
 * 
 * @author Josias SEMANOU
 * @version 1.0
 */
public class Boisson {
    
    /**
     * Le nom de la boisson
     */
    private String nom;
    
    /**
     * La quantite disponible de boisson
     */
    private int quantite;
    
    /**
     * Le prix de vente de la boisson
     */
    private float prixVente;
    
    /**
     * Le prix d'achat de la boisson
     */
    private float prixAchat;
    
    /**
     * L'etat de la boisson : alcoolisee ou pas
     */
    private boolean alcoolise;

    /**
     * Contructeur de Boisson
     * 
     * @param nom
     * @param quantite
     * @param prixVente
     * @param alcoolise
     */
    public Boisson(String nom, int quantite, float prixVente, boolean alcoolise) {
        this.nom = nom;
        this.quantite = quantite;
        this.prixVente = prixVente;
        this.prixAchat = prixVente - 1;// le prix d'achat chez le fournisseur est inferieur de 1$ au prix de vente dans le bar
        this.alcoolise = alcoolise;
    }

    /**
     * @return Le nom de la boisson
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return La quantite de la boisson
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * @return Le prix de vente de la boisson
     */
    public float getPrixVente() {
        return prixVente;
    }

    /**
     * @return Le prix d'achat de la boisson
     */
    public float getPrixAchat() {
        return prixAchat;
    }

    /**
     * @return L'etat de la boisson : alcoolisee, ou non
     */
    public boolean isAlcoolise() {
        return alcoolise;
    }

    /**
     * Modifie le nom de la boisson
     * 
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Modifie la quantite de la boisson
     * 
     * @param quantite
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /**
     * Modifie le prix de vente de la boisson
     * 
     * @param prixVente
     */
    public void setPrixVente(float prixVente) {
        this.prixVente = prixVente;
    }

    /**
     * Modifie le prix d'achat de la boisson
     * 
     * @param prixAchat
     */
    public void setPrixAchat(float prixAchat) {
        this.prixAchat = prixAchat;
    }

    /**
     * Modifie l'etat de la boisson
     * 
     * @param alcoolise
     */
    public void setAlcoolise(boolean alcoolise) {
        this.alcoolise = alcoolise;
    }

    /** 
     * Retourne une chaine de caractere decrivant la boisson
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String alcool = (alcoolise? "alcoolisee, ": "non alcoolisee, ");
        return "\n" + nom + ": boisson " + alcool + quantite + " litres en stock, "
                + prixVente + "$ le litre.";
    }
    
    
}

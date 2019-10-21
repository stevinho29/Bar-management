
/**
 * Enumeration Boisson - écrire ici la description de l'énumération
 *
 * @author (votre nom)
 * @version (numéro de version ou date)
 */
public class Boisson{
    private String nom;
    private int quantite;
    private float prix;
    private boolean alcoolise;

    public Boisson(String nom, int quantite, float prix, boolean alcoolise) {
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
        this.alcoolise = alcoolise;
    }

    public String getNom() {
        return nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public float getPrix() {
        return prix;
    }

    public boolean isAlcoolise() {
        return alcoolise;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setAlcoolise(boolean alcoolise) {
        this.alcoolise = alcoolise;
    }
    
    
}

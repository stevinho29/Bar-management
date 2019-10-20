
/**
 * Décrivez votre classe Humain ici.
 *
 * @author (Steve ndemanou)
 * @version (13/10/2019)
 */
public abstract class Humain {
    
    protected String prenom;
    protected String surnom;
    protected float porteMonnaie;
    protected int cotePopularite;
    protected String criSignificatif;

    public Humain(String prenom, String surnom, int porteMonnaie, int cotePopularite, String criSignificatif) {
        this.prenom = prenom;
        this.surnom = surnom;
        this.porteMonnaie = porteMonnaie;
        this.cotePopularite = cotePopularite;
        this.criSignificatif = criSignificatif;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSurnom() {
        return surnom;
    }

    public float getPorteMonnaie() {
        return porteMonnaie;
    }

    public int getCotePopularite() {
        return cotePopularite;
    }

    public String getCriSignificatif() {
        return criSignificatif;
    }

    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    public void setPorteMonnaie(int porteMonnaie) {
        this.porteMonnaie = porteMonnaie;
    }

    public void setCotePopularite(int cotePopularite) {
        this.cotePopularite = cotePopularite;
    }

    public void setCriSignificatif(String criSignificatif) {
        this.criSignificatif = criSignificatif;
    }
    
    public void  parler(String message) { //discuter avec des gens 
        System.out.println(message);
    }
    
    public void boire() { // boire un verre
    }
    
    public void payer() {// payer sa note
    }
    
    public void offerDrinks() {// offrir un verre à quelqu'un
    }
    
    public void presentMyself() {
        System.out.println("Je suis " + prenom + " aussi appelé " + surnom + ".");
        System.out.println("Il me reste " + porteMonnaie + " euros en poche. Et je crie souvent '" + criSignificatif + "' ! ");
    }
}

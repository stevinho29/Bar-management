
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
    protected int contenuVerre = 0;

    public Humain(String prenom, String surnom, int porteMonnaie, int cotePopularite, String criSignificatif) {
        this.prenom = prenom;
        this.surnom = surnom;
        this.porteMonnaie = porteMonnaie;
        this.cotePopularite = cotePopularite;
        this.criSignificatif = criSignificatif;
    }

    public Humain(String prenom, String surnom) {
        this.prenom = prenom;
        this.surnom = surnom;
        this.porteMonnaie = 50;
        this.cotePopularite = 0;
        this.criSignificatif = "Youhooo";
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

    public int getContenuVerre() {
        return contenuVerre;
    }

    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    public void setPorteMonnaie(float porteMonnaie) {
        this.porteMonnaie = porteMonnaie;
    }

    public void setCotePopularite(int cotePopularite) {
        this.cotePopularite = cotePopularite;
    }

    public void setContenuVerre(int contenuVerre) {
        this.contenuVerre = contenuVerre;
    }

    public void setCriSignificatif(String criSignificatif) {
        this.criSignificatif = criSignificatif;
    }
    
    public void  parler(String message) { //discuter avec des gens 
        System.out.println(message);
    }
    
    public void boire() { // boire un verre
        if (contenuVerre > 5)
            contenuVerre -= 5;
        else if (contenuVerre > 0)
            contenuVerre = 0;
        else
            System.out.println("Ah, mon verre est vide !!");
    }
    
    public void payer(Boisson boisson, int quantite, Barman barman) {// payer un verre
        barman.vendreBoisson(boisson, quantite, this);
    }
    
    public void offerDrinks(Boisson boisson, int quantite, Barman barman, Humain humain) {// offrir un verre à quelqu'un
        barman.vendreBoisson(boisson, quantite, humain);
    }
    
    public void presentMyself() {
        System.out.println("Je suis " + prenom + " aussi appelé " + surnom + ".");
        System.out.println("Il me reste " + porteMonnaie + " euros en poche. Et je crie souvent '" + criSignificatif + "' ! ");
    }
}

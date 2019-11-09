/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bar;

/**
 *
 * @author USER
 */
public abstract class Humain {
    
    protected String prenom;
    protected String surnom;
    protected float porteMonnaie;
    protected int cotePopularite;
    protected String criSignificatif;
    protected int contenuVerre = 0;
    protected Boisson boissonVerre;

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

    public Boisson getBoissonVerre() {
        return boissonVerre;
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

    public void setBoissonVerre(Boisson boissonVerre) {
        this.boissonVerre = boissonVerre;
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
    
    public void payer(Boisson boisson, int quantite) {// payer un verre pour soi-même
        Bar.getOneServeur().servirClient(boisson, quantite, this, this);
    }
    
    public void offerDrinks(Boisson boisson, int quantite, Humain ami) {// offrir un verre à quelqu'un
        Bar.getOneServeur().servirClient(boisson, quantite, this, ami);
    }
    
    public void presentMyself() {
        System.out.println("Je suis " + prenom + " aussi appelé " + surnom + ".");
        System.out.println("Il me reste " + porteMonnaie + " euros en poche. Et je crie souvent '" + criSignificatif + "' ! ");
    }
}

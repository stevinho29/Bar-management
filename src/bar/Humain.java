package bar;

import java.util.ArrayList;

import tournoi.Utilisateur;

/**
 * <b>Humain est la classe representant un humain.</b><br>
 * Un huamin est caracterise par :
 * <ul>
 * <li>Un prenom</li>
 * <li>Un surnom</li>
 * <li>Un porte-monnaie</li>
 * <li>Une cote de popularite</li>
 * <li>Un cri significatif</li>
 * <li>Le contenu de son verre</li>
 * <li>La boisson presente dans son verre</li>
 * </ul>
 * 
 * @author Josias SEMANOU
 * @version 1.0
 */
public abstract class Humain {
    
    /**
     * Le prenom de l'humain
     */
    protected String prenom;
    
    /**
     * Le surnom de l'humain
     */
    protected String surnom;
    
    /**
     * Le porte-monnaie de l'humain
     */
    protected float porteMonnaie;
    
    /**
     * La cote de popularite de l'humain
     */
    protected int cotePopularite;
    
    /**
     * Le cri significatif de l'humain
     */
    protected String criSignificatif;
    
    /**
     * Le contenu du verre de l'humain
     */
    protected int contenuVerre = 0;
    
    /**
     * La boisson presente dans le verre de l'humain
     */
    protected Boisson boissonVerre;

    /**
     * Constructeur complet de Humain
     * 
     * @param prenom
     * @param surnom
     * @param porteMonnaie
     * @param cotePopularite
     * @param criSignificatif
     */
    public Humain(String prenom, String surnom, float porteMonnaie, int cotePopularite, String criSignificatif) {
        this.prenom = prenom;
        this.surnom = surnom;
        this.porteMonnaie = porteMonnaie;
        this.cotePopularite = cotePopularite;
        this.criSignificatif = criSignificatif;
    }

    /**
     * Constructeur simple de Humain
     * 
     * @param prenom
     * @param surnom
     */
    public Humain(String prenom, String surnom) {
        this.prenom = prenom;
        this.surnom = surnom;
        this.porteMonnaie = 50;
        this.cotePopularite = 0;
        this.criSignificatif = "Youhooo";
    }

    /**
     * @return Le prenom de l'humain
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @return Le surnom de l'humain 
     */
    public String getSurnom() {
        return surnom;
    }

    /**
     * @return Le porte-monnaie de l'humain
     */
    public float getPorteMonnaie() {
        return porteMonnaie;
    }

    /**
     * @return La cote de popularite de l'humain
     */
    public int getCotePopularite() {
        return cotePopularite;
    }

    /**
     * @return Le cri significatif de l'humain
     */
    public String getCriSignificatif() {
        return criSignificatif;
    }

    /**
     * @return Le contenu du verre de l'humain
     */
    public int getContenuVerre() {
        return contenuVerre;
    }

    /**
     * @return La boisson presente dans le verre de l'humain
     */
    public Boisson getBoissonVerre() {
        return boissonVerre;
    }

    /**
     * Modifie le surnom de l'humain
     * 
     * @param surnom
     */
    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    /**
     * Modifie le porte-monnaie de l'humain
     * @param porteMonnaie
     */
    public void setPorteMonnaie(float porteMonnaie) {
        this.porteMonnaie = porteMonnaie;
    }

    /**
     * Modifie la cote de popularite de l'humain
     * 
     * @param cotePopularite
     */
    public void setCotePopularite(int cotePopularite) {
        this.cotePopularite = cotePopularite;
    }

    /**
     * Modifie le contenu du verre de l'humain
     * 
     * @param contenuVerre
     */
    public void setContenuVerre(int contenuVerre) {
        this.contenuVerre = contenuVerre;
    }

    /**
     * Modifie le cri significatif de l'humain
     * 
     * @param criSignificatif
     */
    public void setCriSignificatif(String criSignificatif) {
        this.criSignificatif = criSignificatif;
    }

    /**
     * Modifie la boisson presente dans le verre de l'humain
     * 
     * @param boissonVerre
     */
    public void setBoissonVerre(Boisson boissonVerre) {
        this.boissonVerre = boissonVerre;
    }
    
    /**
     * Quand l'humain parle
     * 
     * @param message
     */
    public void  parler(String message) {
        System.out.println(message);
    }
    
    /**
     * Boire la boisson servie dans son verre
     * 
     */
    public void boire() {
        if (contenuVerre > 5)
            contenuVerre -= 5;
        else if (contenuVerre > 0)
            contenuVerre = 0;
        else
            System.out.println(prenom + ": Ah, mon verre est vide !!");
    }
    
    /**
     * Payer un verre pour soi-meme
     * 
     * @param boisson
     * @param quantite
     */
    public void payer(Boisson boisson, int quantite) {
        getBar().getOneServeur().servirClient(boisson, quantite, this, this);
        
    }
    
    /**
     * Offrir un verre a quelqu'un
     * 
     * @param boisson
     * @param quantite
     * @param ami
     */
    public void offerDrinks(Boisson boisson, int quantite, Humain ami) {
        getBar().getOneServeur().servirClient(boisson, quantite, this, ami);
        cotePopularite += 5;// la cote de popularite evolue quand on offre un verre a quelqu'un
    }
    
    /**
     * Pour se presenter
     */
    public void presentMyself() {
        System.out.println("Je suis " + prenom + " MON SURNOM C'EST " + surnom + " COOL PAS VRAI ?");
        System.out.println("Il me reste " + porteMonnaie + " euros en poche. Et je crie souvent '" + criSignificatif + "' !!!!! ");
    }
    /**
     * Determine le bar dans lequel il se trouve
     * 
     * @return Le bar dans lequel il se trouve
     */
    public Bar getBar()
    {
    	Bar bar=null;
    	ArrayList<Bar> barlist= Utilisateur.getBarList();
    		for(int i= 0 ;i <barlist.size();i++ )
    		{
    			if(barlist.get(i).getOccupants().contains(this))
    				bar= barlist.get(i);
    		}
    	return bar;
    }
}

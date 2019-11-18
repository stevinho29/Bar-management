package bar;

import java.util.ArrayList;

import tournoi.*;

/**
 * <b>Barman est la classe representant un barman.</b><br>
 * Un barman est caracterise par :
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
public class Barman extends Humain {
    
    /**
     * Constructeur Barman
     * 
     * @param prenom
     * @param surnom
     * @param porteMonnaie
     * @param cotePopularite
     * @param criSignificatif
     */
    public Barman(String prenom, String surnom, float porteMonnaie, int cotePopularite, String criSignificatif) {
        super(prenom, surnom, porteMonnaie, cotePopularite, criSignificatif);
        Bar.addOccupant(this);
    }
    
    /**
     * Vendre de la boisson
     * 
     * @param boisson
     * @param quantite
     * @param bayeur
     * @param beneficiaire
     */
    public void vendreBoisson(Boisson boisson, int quantite, Humain bayeur, Humain beneficiaire,Bar bar){
        if(bar.getInventaire().contains(boisson)){
            Boisson boissonDuBar = bar.getInventaire().get(bar.getInventaire().indexOf(boisson));
            if (boissonDuBar.getQuantite() >= quantite) {// si il y a assez de boisson dans le stock
                float coutTotal = boissonDuBar.getPrixVente()* quantite;
                if(bayeur.getClass().getSimpleName().equals("Patronne")){//la patronne ne paie pas
                    boissonDuBar.setQuantite(boissonDuBar.getQuantite() - quantite);//retirer la quantite necessaire du stock
                    beneficiaire.setContenuVerre(beneficiaire.getContenuVerre() + quantite);//servir la quantite necessaire dans le verre du beneficiaire
                    beneficiaire.setBoissonVerre(boisson);//indiquer la boisson servie dans le verre
                    System.out.println("Voilà " + quantite + " Litres de " + boisson.getNom() + " pour vous Client " 
                            + beneficiaire.getPrenom() + " ! De la part de notre Patronne " + bayeur.getPrenom());
                }else if (bayeur.getPorteMonnaie() >= coutTotal) {// si celui qui offre la boisson a assez d'argent pour payer sa commande
                    bayeur.setPorteMonnaie(bayeur.getPorteMonnaie() - coutTotal);// retirer le cout de son portemonnaie
                    Bar.setCaisse(bar.getCaisse()+coutTotal);// ajouter ce montantà la caisse
                    boissonDuBar.setQuantite(boissonDuBar.getQuantite() - quantite);//retirer la quantite necessaire du stock
                    beneficiaire.setContenuVerre(beneficiaire.getContenuVerre() + quantite);//servir la quantite necessaire dans le verre du beneficiaire
                    beneficiaire.setBoissonVerre(boisson);//indiquer la boisson servie dans le verre
                    System.out.println("Voilà " + quantite + " Litres de " + boisson.getNom() + " pour vous Client " 
                            + beneficiaire.getPrenom() + " !");
                }else{// sinon pas assez d'argent
                    System.out.println("Client " + bayeur.getPrenom() + ", vous n'avez pas assez pour acheter " + quantite + " Litres de " 
                            + boisson.getNom() + ", ça coûte " + coutTotal + "$");
                }
            }else{// sinon pas assez de boisson
                System.out.println("Nous n'avons pas assez de " + boissonDuBar.getNom() + ". Il n'en reste que " + boissonDuBar.getQuantite() + " Litres.");
            }
        }else{
            System.out.println("Il n'y a pas cette boisson dans notre bar !!");
        }
    }
    
    /**
     * Commande de boissons pour remplir celles qui sont �puis�es
     * 
     * @param fournisseur
     */
    public void commanderBoissons(Fournisseur fournisseur,Bar bar){
        float prix = 0;
        ArrayList<Boisson> commande = new ArrayList<>();
        bar.getInventaire().forEach((boisson) -> {
            if(boisson.getQuantite() < 20){
                commande.add(boisson);
            }
        });
        prix = fournisseur.calculerPrix(commande);
        if(prix < bar.getCaisse()){
            Bar.setCaisse(bar.getCaisse() - prix);
            fournisseur.livrerBoissons();
        }
    }
    
   

    /**
     * Se payer de la boisson 
     * 
     * @see bar.Humain#payer(bar.Boisson, int)
     */
    @Override
    public void payer(Boisson boisson, int quantite,Bar bar) {
        setContenuVerre(getContenuVerre() + quantite);//servir la quantite necessaire dans son verre
        setBoissonVerre(boisson);//indiquer la boisson servie dans le verre
        parler("Voilà " + quantite + " Litres de " + boisson.getNom() + " pour moi le Barman !");
        // Il ne paye pas :  pas de debit sur son compte
    }

    /** 
     * Boire la boisson servie dans son verre
     * Uniquement les boissons non alcoolisees
     * 
     * @see bar.Humain#boire()
     */
    @Override
    public void boire() {
        if(!this.boissonVerre.isAlcoolise())
            super.boire();
    }

    /** 
     * Se presenter
     * 
     * @see bar.Humain#presentMyself()
     */
    @Override
    public void presentMyself() {
        System.out.println(toString());
    }

    /** 
     * Parler
     * 
     * @see bar.Humain#parler(java.lang.String)
     */
    @Override
    public void parler(String message) {
        super.parler("Barman : " + message + " coco");
    }

    /** 
     * Retourne une chaine de caractere caracterisant le barman 
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return criSignificatif + ". Je suis " + prenom + " le barman. Mais tu peux aussi m'appeler " + surnom + ".\n"
                + "J'ai encore " + porteMonnaie + " $ en poche. Coco...";
    }
    
}

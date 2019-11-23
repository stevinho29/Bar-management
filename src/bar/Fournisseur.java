package bar;

import java.util.ArrayList;

import tournoi.Utilisateur;

/**
 * <b>Fournisseur est la classe representant un fournisseur.</b><br>
 * Un fournisseur est caracterise par :
 * <ul>
 * <li>Un prenom</li>
 * <li>Un surnom</li>
 * <li>Un porte-monnaie</li>
 * <li>Une cote de popularite</li>
 * <li>Un cri significatif</li>
 * <li>Le contenu de son verre</li>
 * <li>La boisson presente dans son verre</li>
 * <li>Le prix de la commande a livrer actuellement</li>
 * <li>La quantite livree a chaque commande</li>
 * <li>La liste de toutes les boissons qu'il peut fournir</li>
 * <li>La liste des boissons en cours de commande</li>
 * </ul>
 * 
 * @author Josias SEMANOU
 * @version 1.0
 */
public class Fournisseur extends Humain {
    
    /**
     * Le prix de la commande a livrer actuellement par le fournisseur
     */
    private float prixCommande = 0;
    
    /**
     * La quantite livree a chaque commande chez le fournisseur
     */
    private int quantiteParCommande = 100;
    
    /**
     * La liste de toutes les boissons que peut fournir le fournisseur
     */
    private ArrayList<Boisson> stockFournisseur = new ArrayList<>();
    
    /**
     * La liste des boissons en cours de commande chez le fournisseur
     */
    private ArrayList<Boisson> commandeBoissons;

    /**
     * Constructeur de Fournisseur
     * 
     * @param prenom
     * @param surnom
     * @param porteMonnaie
     * @param cotePopularite
     * @param criSignificatif
     */
    public Fournisseur(String prenom, String surnom, float porteMonnaie, int cotePopularite, String criSignificatif,Bar bar) {
        super(prenom, surnom, porteMonnaie, cotePopularite, criSignificatif);
        stockFournisseur = bar.getInventaire();
    }
    
    /**
     * Calcul du prix d'une commande de boisson
     * 
     * @param listeBoissons
     * @return Le prix de la commande de boisson
     */
    public float calculerPrix(ArrayList<Boisson> listeBoissons){
        commandeBoissons = new ArrayList<>();
        listeBoissons.forEach((boisson) -> {
            if(stockFournisseur.contains(boisson)){// si boisson presente en stock, augmenter prix commande selon prix d'achat fournisseur
                prixCommande += quantiteParCommande * (boisson.getPrixAchat());
                commandeBoissons.add(boisson);
            }
        });
        return  prixCommande;
    }
    
    /**
     * Livraison de la boisson
     */
    public void livrerBoissons(){
        commandeBoissons.forEach((boisson) -> {
            //malus de la quantite fournie sur le stock
            boisson.setQuantite(boisson.getQuantite() + quantiteParCommande);
            parler("Voila " + quantiteParCommande + " Litres de " + boisson.getNom() + " pour votre bar !");
        });
        //recuperation du paiement
        if (prixCommande == 0)
            parler("Votre stock est au complet !");
        else
            parler("Ca vous coutera " + prixCommande + "$ !");
        this.setPorteMonnaie(porteMonnaie + prixCommande);
        prixCommande = 0;
    }
    
    /**
     * Retourne une chaine de caractere caracterisant le fournisseur
     * 
     * @see bar.Humain#parler(java.lang.String)
     */
    @Override
    public void parler(String message) {
        super.parler("Fournisseur : " +message);
    }

}

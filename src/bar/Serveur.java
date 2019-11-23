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
public class Serveur extends Humain {

    /**
     * Constructeur de Serveur
     * 
     * @param prenom
     * @param surnom
     * @param porteMonnaie
     * @param cotePopularite
     * @param criSignificatif
     */
    public Serveur(String prenom, String surnom, float porteMonnaie, int cotePopularite, String criSignificatif) {
        super(prenom, surnom, porteMonnaie, cotePopularite, criSignificatif);
    }

    /** 
     * Boire la boisson servie dans son verre
     * Uniquement de l'eau
     * 
     * @see bar.Humain#boire()
     */
    @Override
    public void boire() {
        if(this.boissonVerre.getNom().equals("EAU") && (!this.boissonVerre.isAlcoolise()))
            super.boire();
    }
    
    /**
     * Servir de la boisson a la demande d'un client
     * A lui-meme ou un autre
     * 
     * @param boisson
     * @param quantite
     * @param clientADebiter
     * @param clientAServir
     */
    public void servirClient(Boisson boisson, int quantite, Humain clientADebiter, Humain clientAServir,Bar bar) {
        bar.getBarman().vendreBoisson(boisson, quantite, clientADebiter, clientAServir,bar);
    }
}

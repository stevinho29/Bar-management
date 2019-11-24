package bar;

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
 * <li>Une taille de biceps</li>
 * </ul>
 * 
 * @author Josias SEMANOU
 * @version 1.0
 */
public class ServeurHomme extends Serveur {
    
    /**
     * La taille des biceps de l'humain
     */
    private int tailleBiceps;

    /**
     * Constructeur de ServeurHomme
     * 
     * @param prenom
     * @param surnom
     * @param porteMonnaie
     * @param cotePopularite
     * @param criSignificatif
     * @param tailleBiceps
     */
    public ServeurHomme(String prenom, String surnom, float porteMonnaie, int cotePopularite, String criSignificatif, int tailleBiceps) {
        super(prenom, surnom, porteMonnaie, cotePopularite, criSignificatif);
        this.tailleBiceps = tailleBiceps;
    }
    
    /**
     * Servir de la boisson a la demande d'un client
     * A lui-meme ou un autre
     * 
     * @see bar.Serveur#servirClient(bar.Boisson, int, bar.Humain, bar.Humain)
     */
    @Override
    public void servirClient(Boisson boisson, int quantite, Humain clientADebiter, Humain clientAServir,Bar bar) {
        bar.getBarman().vendreBoisson(boisson, quantite, clientADebiter, clientAServir,bar);
    }

    /**
     * Retourne une chaine de caractere caracterisant le serveur
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "\nJe suis " + prenom + ", un des serveurs de cet etablissement, encore appele " + surnom + ".\n"
                + criSignificatif + " ! Mes biceps mesurent " + tailleBiceps + "cm.";
    }
    
}

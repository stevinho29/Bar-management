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
 * <li>Un coefficient de charme</li>
 * </ul>
 * 
 * @author Josias SEMANOU
 * @version 1.0
 */
public class ServeurFemme extends Serveur{
    
    /**
     * Le coefficient de charme de la serveuse
     */
    int coefficientCharme;
    
    /**
     * Constructeur de ServeurFemme
     * 
     * @param prenom
     * @param surnom
     * @param porteMonnaie
     * @param cotePopularite
     * @param criSignificatif
     * @param coefficientCharme
     */
   
    public ServeurFemme(String prenom, String surnom, float porteMonnaie, int cotePopularite, String criSignificatif, int coefficientCharme) {
        super(prenom, surnom, porteMonnaie, cotePopularite, criSignificatif);
        this.coefficientCharme = coefficientCharme;
    }

    /**
     * Retourne une chaine de caractere caracterisant la serveuse
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "\nJe suis " + prenom + ", une des serveuses de cet etablissement, mais appelez-moi " + surnom + ".\n"
                + criSignificatif + " ! Je suis " + coefficientCharme + " fois plus jolie que la normale.";
    }
    
    /**
     * Servir de la boisson a la demande d'un client
     * A lui-meme ou un autre
     * 
     * @see bar.Serveur#servirClient(bar.Boisson, int, bar.Humain, bar.Humain)
     */
    @Override
    public void servirClient(Boisson boisson, int quantite, Humain clientADebiter, Humain clientAServir,Bar bar) {
        if (clientADebiter.getClass().getSimpleName().equals("ClientHomme") && coefficientCharme > 50) {
            quantite *= 2;// la quantite demandee double lorsque la serveuse est charmante
            System.out.println("Comme je suis servis par la magnifique " + prenom + " je vais prendre " + quantite + " litres.");
        }
        bar.getBarman().vendreBoisson(boisson, quantite, clientADebiter, clientAServir,bar);
    }
    
}

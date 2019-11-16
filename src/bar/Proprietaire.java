package bar;

/**
 * @author Josias SEMANOU
 * @version 1.0
 */
public interface Proprietaire {
	
    /**
     * Recuperation de l'argent de la caisse
     * 
     */
    public void recupererArgentCaisse();
    
    /**
     * Mise sur liste noire d'un client
     * 
     * @param c
     */
    public void mettreSurListeNoire(Client c);
    
    /**
     * Exclusion d'un client
     * 
     * @param c
     */
    public void exclure(Client c);
    
}

package bar;

import java.util.ArrayList;

import tournoi.*;


/**
 * <b>Patronne est la classe representant la patronne.</b><br>
 * La patronne est caracterisee par :
 * <ul>
 * <li>Un prenom</li>
 * <li>Un surnom</li>
 * <li>Un porte-monnaie</li>
 * <li>Une cote de popularite</li>
 * <li>Un cri significatif</li>
 * <li>Le contenu de son verre</li>
 * <li>La boisson presente dans son verre</li>
 * <li>Une boisson favorite </li>
 * <li>Une boisson de secours</li>
 * <li>Un niveau d'alcoolemie</li>
 * <li>Un bijou</li>
 * </ul>
 * 
 * @author Josias SEMANOU
 * @version 1.0
 */
public class Patronne extends ClientFemme implements Proprietaire{
    
    public Patronne(Boisson boissonFavorite, Boisson boissonDeSecours, int niveauAlcoolemie, String prenom, String surnom, float porteMonnaie, int cotePopularite, String criSignificatif, Bijoux bijou) {
        super(boissonFavorite, boissonDeSecours, niveauAlcoolemie, prenom, surnom, porteMonnaie, cotePopularite, criSignificatif, bijou);
    }
    
    /**
     * Retirer un client de la liste noire du bar
     * 
     * @param client
     */
    public void unBlackList(Client client) {
        Bar.removeFromListeNoire(client);
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
     * Retourne une chaine de caractere caracterisant la patronne
     * 
     * @see bar.ClientFemme#toString()
     */
    @Override
    public String toString() {
        return "\n" + criSignificatif + ". Je suis " + prenom + " la patronne. Seuls les habitues peuvent m'appeler " + surnom + ".";
    }
    
    /**
     * Recuperation des ressources presentes dans la caisse
     * 
     * @see bar.Proprietaire#recupererArgentCaisse()
     */
    @Override
    public void recupererArgentCaisse() {// Elle recupere toujours la moitie des ressources presentes dans la Caisse
        this.porteMonnaie += (getBar().getCaisse()/2);
        Bar.setCaisse(getBar().getCaisse()/2);
    }
    
    /**
     * Mettre un client sur liste noire du bar
     * 
     * @param client
     * @see bar.Proprietaire#mettreSurListeNoire(bar.Client)
     */
    @Override
    public void mettreSurListeNoire(Client c) {
        if (c != this) {
            Bar.addToListeNoire(this);
        }else
            System.out.println("En tant que Patronne je ne peut etre blacklistee");
    }
    
    /**
     * Faire sortir un client du bar
     * 
     * @param client
     * @see bar.Proprietaire#exclure(bar.Client)
     */
    @Override
    public void exclure(Client c) {
        if (c != this) {
            Bar.removeOccupant(c);
        }else
            System.out.println("En tant que Patronne je ne peut etre exclue de mon Bar");
    }
    
    /**
     * 
     */
    public void annonceTournament(Tournoi tournoi)
    {
     System.out.println("début du tournoi "+tournoi.getTournamentPoster()+" le prix du vainqueur sera de"+tournoi.getWinPrice());
     
     tournoi.setState(TournamentState.en_cours);
     
    }
    /**
     * Determine le bar dans lequel elle est patronne
     * 
     * @return Le bar dans lequel elle est patronne
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

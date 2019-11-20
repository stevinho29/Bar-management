package tournoi;

import bar.*;
/**
 * <b>Joueur est la classe generique permettant d'instancier des joueurs pour le tournoi.</b><br>
 * Un joueur est caracterisee par :
 * <ul>
 * <li>Un joueur</li>
 * <li>L'expertise du joueur</li>
 * </ul>
 * 
 * @author Steve NDEMANOU
 * @version 1.0
 */
public class Joueur<P> {
    
    /**
     * Le joueur
     */
	private P  player;
    
    /**
     * L'expertise du joueur
     */
	private PlayerLevel level;
	
	/* accesseurs et mutateurs */
    /**
     * @return L'expertise du joueur
     */
	public PlayerLevel getLevel() {
		return level;
	}

    /**
     * Modifie l'expertise du joueur
     * 
     * @param level
     */
	public void setLevel(PlayerLevel level) {
		this.level = level;
	}
    /**
     * @return Le joueur
     */
	public P getPlayer() {
		return this.player;
	}

    /**
     * Modifie le joueur
     * 
     * @param player
     */
	public void setJoueurClient(P player) {
		this.player = player;
	}
	
	/* constructeur(s) */
	
    /**
     * Constructeur Joueur
     * 
     * @param player
     */
	public Joueur(P player)
	{
		this.player = player; // on inscrit un client deja existant dans le bar en tant que joueur 
	}
	
	
	
	
}

package tournoi;

import bar.*;

public class Joueur<P> {  				// classe générique permettant d'instancier ds joueurs pour le tournoi

	private P  player;					// un joueur
	private PlayerLevel level;			// expertise du joueur
	
	/* accesseurs et mutateurs */
	public PlayerLevel getLevel() {
		return level;
	}
	public void setLevel(PlayerLevel level) {
		this.level = level;
	}
	public P getPlayer() {
		return this.player;
	}
	public void setJoueurClient(P player) {
		this.player = player;
	}
	
	/* constructeur(s) */
	public Joueur(P player)
	{
		this.player = player; // on inscrit un client deja existant dans le bar en tant que joueur 
	}
	
	
	
	
}

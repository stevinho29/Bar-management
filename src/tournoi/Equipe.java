package tournoi;

import java.util.ArrayList;

import bar.*;
/**
 * <b>Equipe est la classe representant une equipe.</b><br>
 * Une equipe est caracterisee par :
 * <ul>
 * <li>Un nom</li>
 * <li>Une liste de joueur composant l'equipe</li>
 * <li>Le score de la partie</li>
 * <li>Le gain de l'equipe</li>
 * </ul>
 * 
 * @author Steve NDEMANOU
 * @version 1.0
 */
public class Equipe {
    
    /**
     * Le nom de l'equipe
     */
	private String teamName;
    
    /**
     * La liste des joueurs composants l'equipe
     */
	private static ArrayList<Humain> playerList = new ArrayList<Humain>();
    
    /**
     * Le score de la partie
     */
	private int score;
    
    /**
     * Le gain de l'equipe
     */
	private int gain;
	
	
    /**
     * @return Le nom de l'equipe
     */
	public String getTeamName() {
		return teamName;
	}

    /**
     * Modifie le nom de l'equipe
     * 
     * @param teamName
     */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

    /**
     * @return La liste des joueurs composants l'equipe
     */
	public ArrayList<Humain> getPlayerList() {
		return playerList;
	}

    /**
     * Modifie la liste des joueurs composants l'equipe
     * 
     * @param playerList
     */
	public void setPlayerList(ArrayList<Humain> PlayerList) {
		this.playerList = playerList;
	}

    /**
     * @return Le score de la partie
     */
	public int getScore() {
		return score;
	}

    /**
     * Modifie le score de la partie
     * 
     * @param score
     */
	public void setScore(int score) {
		this.score = score;
	}
	
    /**
     * @return Le gain de l'equipe
     */
	public int getGain() {
		return gain;
	}

    /**
     * Modifie le gain de l'equipe
     * 
     * @param gain
     */
	public void setGain(int gain) {
		this.gain = gain;
	}
	
    /**
     * Constructeur Equipe
     */
	public Equipe()
	{}
	
    /**
     * Constructeur Equipe
     * 
     * @param name
     * @param playerList
     */
	public Equipe(String name, ArrayList<Humain> playerList )
	{
		this.teamName= name;
		this.playerList= playerList;
		
	}
}

package tournoi;

import java.util.ArrayList;

import bar.*;

public class Equipe {

	private String teamName;										  // nom de l'equipe
	private static ArrayList<Humain> playerList = new ArrayList<Humain>();  // liste des joueurs composants l'équipe
	private int score;												  // score de la partie
	private int gain;												  // gain de l'équipe
	
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public ArrayList<Humain> getPlayerList() {
		return playerList;
	}
	public void setPlayerList(ArrayList<Humain> PlayerList) {
		this.playerList = playerList;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getGain() {
		return gain;
	}
	public void setGain(int gain) {
		this.gain = gain;
	}
	
	public Equipe(String name,ArrayList<Humain> playerList )
	{
		this.teamName= name;
		this.playerList= playerList;
		
	}
}

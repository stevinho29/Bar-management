package tournoi;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import bar.Humain;

public class Tournoi {

	private String name;											// nom du tournoi
	private int winPrice; 											// prix du gagnant
	private int participationCost;									// prix de participation
	private String tournamentPoster;								// affiche du tournoi
	private TournamentState state;									// statut du tournoi
	private LocalDate TournamentCreationDate;						// data à laquelle le tournoi a été crée
	private LocalDate dayOfTournament;								// date à laquelle aura lieu le tournoi
	private ArrayList<Equipe> teamList= new ArrayList<Equipe>();	// liste des équipes qui y participent
	
	/*accesseurs et mutateurs*/
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWinPrice() {
		return winPrice;
	}
	public void setWinPrice(int winPrice) {
		this.winPrice = winPrice;
	}
	public int getParticipationCost(){
		return participationCost;
	}
	public void setParticipationCost(int participationCost){
		this.participationCost = participationCost;
	}
	public String getTournamentPoster(){
		return tournamentPoster;
	}
	public void setTournamentPoster(String tournamentPoster) {
		this.tournamentPoster = tournamentPoster;
	}
	
	public LocalDate getTournamentCreationDate() {
		return TournamentCreationDate;
	}
	public TournamentState getState() {
		return state;
	}
	public void setState(TournamentState state) {
		this.state = state;
	}
	public LocalDate getDayOfTournament() {
		return dayOfTournament;
	}
	public void setDayOfTournament(LocalDate dayOfTournament) {
		this.dayOfTournament = dayOfTournament;
	}
	
	public ArrayList<Equipe> getTeamList() {
		return teamList;
	}
	public void setTeamList(ArrayList<Equipe> teamList) {
		this.teamList = teamList;
	}
	/* constructeur(s) */
	public Tournoi(String name,int winprice,int participationCost,String tournamentPoster,ArrayList<Equipe> teamList) // constructeur de tournois automatique 
	{
		LocalDate currentTime = LocalDate.now();
		this.name= name;
		this.participationCost= participationCost;
		this.winPrice= winprice;
		this.tournamentPoster= tournamentPoster;
		this.TournamentCreationDate= LocalDateTime.now().toLocalDate();
		this.state = TournamentState.à_venir;
		this.dayOfTournament= LocalDate.of(currentTime.getYear()+1, currentTime.getMonth(), currentTime.getDayOfMonth());;
		this.teamList= teamList;
	}
	/* méthodes utiles*/
	
	public void displayTeamList()
	{
		System.out.println("la liste des équipes");
		for(int i= 0;i < teamList.size();i++)
		{
			System.out.println("équipe "+i+"- "+teamList.get(i).getTeamName());
			ArrayList<Humain> playerList= teamList.get(i).getPlayerList();
			for(int j=0;j < playerList.size();j++)
				System.out.println("joueur "+j+": "+playerList.get(j).getPrenom());
		}
	}
	
}

package tournoi;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import bar.Humain;
/**
 * <b>Tournoi est la classe representant un tournoi.</b><br>
 * Un tournoi est caracterisee par :
 * <ul>
 * <li>Un nom</li>
 * <li>Le prix du gagnant</li>
 * <li>Le prix de participation</li>
 * <li>L'affiche du tournoi</li>
 * <li>Le statut du tournoi</li>
 * <li>La date a  laquelle le tournoi a ete cree</li>
 * <li>La date a  laquelle aura lieu le tournoi</li>
 * <li>La liste des equipes qui y participent</li>
 * </ul>
 * 
 * @author Steve NDEMANOU
 * @version 1.0
 */
public class Tournoi {
    
    /**
     * Le nom du tournoi
     */
	private String name;
    
    /**
     * Le prix du gagnant
     */
	private int winPrice;
    
    /**
     * Le prix de participation
     */
	private int participationCost;
    
    /**
     * L'affiche du tournoi
     */
	private String tournamentPoster;
    
    /**
     * Le statut du tournoi
     */
	private TournamentState state;
    
    /**
     * La date a  laquelle le tournoi a ete cree
     */
	private LocalDate TournamentCreationDate;
    
    /**
     * La date a  laquelle aura lieu le tournoi
     */
	private LocalDate dayOfTournament;
    
    /**
     * La liste des equipes qui y participent
     */
	private ArrayList<Equipe> teamList= new ArrayList<Equipe>();
	
	/*accesseurs et mutateurs*/

	
    /**
     * @return Le nom du tournoi
     */
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
    /**
     * @return Le prix du gagnant
     */
	public int getWinPrice() {
		return winPrice;
	}
	public void setWinPrice(int winPrice) {
		this.winPrice = winPrice;
	}
	
    /**
     * @return Le prix de participation
     */
	public int getParticipationCost(){
		return participationCost;
	}
	public void setParticipationCost(int participationCost){
		this.participationCost = participationCost;
	}
	
    /**
     * @return L'affiche du tournoi
     */
	public String getTournamentPoster(){
		return tournamentPoster;
	}
	public void setTournamentPoster(String tournamentPoster) {
		this.tournamentPoster = tournamentPoster;
	}

	
    /**
     * @return La date de creation du tournoi
     */
	public LocalDate getTournamentCreationDate() {
		return TournamentCreationDate;
	}
	
    /**
     * @return Le statut du tournoi
     */
	public TournamentState getState() {
		return state;
	}
	public void setState(TournamentState state) {
		this.state = state;
	}
	
    /**
     * @return La date a laquelle aura lieu le tournoi
     */
	public LocalDate getDayOfTournament() {
		return dayOfTournament;
	}
	public void setDayOfTournament(LocalDate dayOfTournament) {
		this.dayOfTournament = dayOfTournament;
	}

	
    /**
     * @return a liste des equipes
     */
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
		this.state = TournamentState.a_venir;
		this.dayOfTournament= LocalDate.of(currentTime.getYear()+1, currentTime.getMonth(), currentTime.getDayOfMonth());;
		this.teamList= teamList;
	}
	/* methodes utiles*/
	
	public void displayTeamList()
	{
		System.out.println("la liste des equipes");
		for(int i= 0;i < teamList.size();i++)
		{
			System.out.println("equipe "+i+"- "+teamList.get(i).getTeamName());
			ArrayList<Humain> playerList= teamList.get(i).getPlayerList();
			for(int j=0;j < playerList.size();j++)
				System.out.println("joueur "+j+": "+playerList.get(j).getPrenom());
		}
	}
	
}

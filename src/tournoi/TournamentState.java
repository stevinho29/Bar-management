package tournoi;

public enum TournamentState {

	//Objets directement construits
	 passe("passe"), 			// statut du tournoi
	  en_cours ("en cours"), 	// 
	  a_venir("a venir");		// 

	 
	  
	  private String  state ;
	  
	   
	  //Constructeur
	  private TournamentState (String state){
	    
	    this.state = state;
	  }
	   
	  public void getState(){
	    System.out.println(this.state);
	  }
	   
	  public String toString(){
	    return state;
	  }
}

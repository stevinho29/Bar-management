package tournoi;

public enum TournamentState {

	//Objets directement construits
	 passé("passé"), 			// statut du tournoi
	  en_cours ("en cours"), 	// 
	  à_venir("à venir");		// 

	 
	  
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

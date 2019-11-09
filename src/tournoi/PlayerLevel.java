package tournoi;

public enum PlayerLevel {

	//Objets directement construits
	  débutant("débutant"), 	// niveau
	  novice ("novice"), 		// 
	  débrouillaird("débrouillard"),		// figure carreau
	  moyen("moyen"),		
	  bon("bon"),
	  expert("expert"); 
	   
	  
	  private String  level ;
	  
	   
	  //Constructeur
	  private PlayerLevel (String level){
	    
	    this.level = level;
	  }
	   
	  public void getLevel(){
	    System.out.println(this.level);
	  }
	   
	  public String toString(){
	    return level;
	  }
}

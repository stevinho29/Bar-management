package bataille;

public enum NumberOfCard {

	//Objets directement construits
	  Jeu32(32), 	// un jeu de 32 cartes
	  Jeu52 (52);   // un jeu de 32 cartes
	  
	  private int  nbreCarte ;
	  
	   
	  //Constructeur
	  NumberOfCard(int nbreCarte){
	    
	    this.nbreCarte = nbreCarte;
	  }
	   
	  public int getNbCartes(){
	    return this.nbreCarte;
	  }

	   
	  public String toString(){
	    return "le jeu comporte "+nbreCarte+" cartes";
	  }
	   
	 
}

package bataille;

public enum Figure {

	//Objets directement construits
	  treffle("trefle"), 	// figure treffle
	  pique ("pique"), 		// figure pique
	  carreau("carreau"),		// figure carreau
	  coeur("coeur"); 		// figuer coeur
	 
	  
	  private String  figure ;
	  
	   
	  //Constructeur
	  private Figure (String figure){
	    
	    this.figure = figure;
	  }
	   
	  public void getFigure(){
	    System.out.println(this.figure);
	  }
	   
	  public String toString(){
	    return figure;
	  }
	   
}

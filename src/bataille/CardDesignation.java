package bataille;

public enum CardDesignation {
	
	//Objets directement construits
	  un(1,"AS"), 	
	  deux(2,"2"), 
	  trois(3,"3"),
	  quatre(4,"4"),
	  cinq(5,"5"),
	  six(6,"6"),
	  sept(7,"7"),
	  huit(8,"8"),
	  neuf(9,"9"),
	  dix(10,"10"),
	  onze(11,"Valet"),
	  douze(12,"Dame"),
	  treize(13,"Roi");
	  
	  
	  private Integer cardPower ;
	  private String cardDesignation;
	   
	  //Constructeur
	  CardDesignation(int cardPower, String cardDesignation){
	    
	    this.cardPower = cardPower;
	    this.cardDesignation= cardDesignation;
	  }
	   
	  public Integer getCardPower(){  // puissance de la carte
	    return this.cardPower;
	  }
	  public String getCardDesignation(){  // puissance de la carte
		    return this.cardDesignation;
		  }
	   
	  public String toString(){  // description de l'enumération( override de toString)
	    return "numéro"+ cardDesignation;
	  }

}

package bataille;

/**
 * <b>CardDesignation est la classe representant la designation d'une carte.</b><br>
 * Elle est carcterisee par :
 * <ul>
 * <li>La puissance de la carte</li>
 * <li>La designation de la carte</li>
 * </ul>
 * 
 * @author Steve NDEMANOU
 * @version 1.0
 */
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

	/**
	 * La puissance de la carte
	 */
	private Integer cardPower ;
	
	/**
     * La designation de la carte
     */
	private String cardDesignation;
	
	/**
	 * Constructeur CardDesignation
	 * 
	 * @param cardPower
	 * @param cardDesignation
	 */
	CardDesignation(int cardPower, String cardDesignation){

		this.cardPower = cardPower;
		this.cardDesignation= cardDesignation;
	}
	
    /**
     * @return La puissance de la carte
     */
	public Integer getCardPower(){
		return this.cardPower;
	}
	
    /**
     * @return La designation de la carte
     */
	public String getCardDesignation(){
		return this.cardDesignation;
	}
	
    /** 
     * Description de l'enumeration
     * 
     * @see java.lang.Object#toString()
     */
    @Override
	public String toString(){
		return "numero "+ cardDesignation;
	}

}

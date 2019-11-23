package bataille;

/**
 * <b>NumberOfCard est la classe representant le nombre de cartes.</b><br>
 * Elle est carcterisee par :
 * <ul>
 * <li>Un nombre de cartes</li>
 * </ul>
 * 
 * @author Steve NDEMANOU
 * @version 1.0
 */
public enum NumberOfCard {

	//Objets directement construits
	Jeu32(32), 	// un jeu de 32 cartes
	Jeu52 (52);   // un jeu de 32 cartes
	
	/**
	 * Le nombre de cartes
	 */
	private int  nbreCarte ;

	/**
	 * Constructeur de NumberOfCard
	 * 
	 * @param nbreCarte
	 */
	NumberOfCard(int nbreCarte){

		this.nbreCarte = nbreCarte;
	}
	
	/**
     * @return Le nombre de cartes
     */
	public int getNbCartes(){
		return this.nbreCarte;
	}
	
	/** 
     * Description du nombre de cartes
     * 
     * @see java.lang.Object#toString()
     */
	@Override
	public String toString(){
		return "le jeu comporte "+nbreCarte+" cartes";
	}


}

package bataille;

/**
 * <b>Figure est la classe representant une figure.</b><br>
 * Figure est carcterisee par :
 * <ul>
 * <li>Un nom</li>
 * </ul>
 * 
 * @author Steve NDEMANOU
 * @version 1.0
 */
public enum Figure {

	//Objets directement construits
	treffle("trefle"), 	// figure treffle
	pique ("pique"), 		// figure pique
	carreau("carreau"),	// figure carreau
	coeur("coeur"); 		// figure coeur

	/**
	 * Le nom de la figure
	 */
	private String  figure ;

	/**
	 * Constructeur de Figure
	 * 
	 * @param figure
	 */
	private Figure (String figure){
		this.figure = figure;
	}

	/**
     * @return Le nom de la figure
     */
	public void getFigure(){
		System.out.println(this.figure);
	}
	
	/** 
     * Description de l'enumeration
     * 
     * @see java.lang.Object#toString()
     */
	@Override
	public String toString(){
		return figure;
	}

}

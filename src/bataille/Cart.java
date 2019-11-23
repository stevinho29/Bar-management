package bataille;

/**
 * <b>Cart est la classe representant une carte.</b><br>
 * Elle est carcterisee par :
 * <ul>
 * <li>La figure</li>
 * <li>La designation de la carte</li>
 * </ul>
 * 
 * @author Steve NDEMANOU
 * @version 1.0
 */
public class Cart implements Comparable<Object> {

	/**
	 * La figure
	 */
	private Figure figure;
	
	/**
	 * La designation de la carte
	 */
	private CardDesignation number;
	
    /**
     * @return La figure
     */
	public Figure getFigure() {
		return figure;
	}

    /**
     * Modifie la figure
     * 
     * @param figure
     */
	public void setFigure(Figure figure) {
		this.figure = figure;
	}
	
    /**
     * @return La designation de la carte
     */
	public CardDesignation getNumber() {
		return number;
	}
	
    /**
     * Modifie la designation de la carte
     * 
     * @param number
     */
	public void setNumber(CardDesignation number) {
		this.number = number;
	}

    /**
     * Constructeur par defaut de Cart
     * 
     */
	public Cart() 								 // constructeur par defaut
	{
		this.number= CardDesignation.un;  			//par defaut une carte vaut 1
		this.figure= Figure.carreau;			// par defaut une carte arbore la figure carreau
	}

    /**
     * Constructeur de Cart
     * 
     * @param number
     * @param figure
     */
	public Cart(CardDesignation number, Figure figure)
	{
		this.number= number;
		this.figure= figure;
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Cart element= (Cart) o;
		return this.number.getCardPower().compareTo(element.number.getCardPower());
	}
	
	
}

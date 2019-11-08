package bataille;



public class Cart implements Comparable<Object> {

	//private Integer number; // nombre compris entre 0 et 13
	private Figure figure;
	private CardDesignation number;
	
	
	public Figure getFigure() {
		return figure;
	}

	public void setFigure(Figure figure) {
		this.figure = figure;
	}

	public CardDesignation getNumber() {
		return number;
	}

	public void setNumber(CardDesignation number) {
		this.number = number;
	}

	public Cart() 								 // constructeur par défaut
	{
		this.number= CardDesignation.un;  			//par défaut une carte vaut 1
		this.figure= Figure.carreau;			// par défaut une carte arbore la figure carreau
	}
	public Cart(CardDesignation number,Figure figure) // overload de constructeur
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

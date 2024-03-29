package bataille;

import java.util.ArrayList;

/**
 * <b>Pack est la classe representant un pack de cartes.</b><br>
 * Pack est carcterisee par :
 * <ul>
 * <li>Un jeu de 32 cartes</li>
 * <li>Un jeu de 52 cartes</li>
 * <li>Un paquet de cartes</li>
 * <li>Une carte</li>
 * </ul>
 * 
 * @author Steve NDEMANOU
 * @version 1.0
 */
public class Pack  {

	private NumberOfCard number32 ;
	private NumberOfCard number52 ;
	private ArrayList<Cart> pack= new ArrayList<Cart>(); // on defini une collection (un paquet de carte)
	private Cart cart = new Cart(); 					 // on instancie une carte de notre jeu
	
	/**
     * @return Le jeu de 32 cartes
     */
	public NumberOfCard getNumber32() {
		return number32;
	}
	
    /**
     * Modifie le jeu de 32 cartes
     * 
     * @param number32
     */
	public void setNumber32(NumberOfCard number32) {
		this.number32 = number32;
	}
	
	/**
     * @return Le jeu de 52 cartes
     */
	public NumberOfCard getNumber52() {
		return number52;
	}
	
    /**
     * Modifie le jeu de 52 cartes
     * 
     * @param number52
     */
	public void setNumber52(NumberOfCard number52) {
		this.number52 = number52;
	}
	
	/**
     * @return Le pack
     */
	public ArrayList<Cart> getPack() {
		return pack;
	}
	
    /**
     * Modifie le pack
     * 
     * @param pack
     */
	public void setPack(ArrayList<Cart> pack) {
		this.pack = pack;
	}
	
	/**
     * @return Une carte
     */
	public Cart getCart() {
		return cart;
	}
	
    /**
     * Modifie la carte
     * 
     * @param cart
     */
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	/**
	 * Constructeur de Pack
	 * 
	 * @param number
	 */
	public Pack(int number)
	{
		if(number == 32)
			populatePack32(this.pack);  // on remplit l'arrayList  lors de la création d'une instance de Pack
		else
			populatePack52(this.pack);
	}
	
	/**
     * Remplissage de la liste des cartes pour un jeu de 32 cartes
     */
	public void populatePack32(ArrayList<Cart> pack) 
	{
		pack.add(new Cart(CardDesignation.un,Figure.carreau));  //1
		pack.add(new Cart(CardDesignation.un,Figure.coeur));  //1
		pack.add(new Cart(CardDesignation.un,Figure.treffle));  //1
		pack.add(new Cart(CardDesignation.un,Figure.pique));  //1
		
		pack.add(new Cart(CardDesignation.sept,Figure.carreau));  //7
		pack.add(new Cart(CardDesignation.sept,Figure.coeur));  //7
		pack.add(new Cart(CardDesignation.sept,Figure.treffle));  //7
		pack.add(new Cart(CardDesignation.sept,Figure.pique));  //7
		
		pack.add(new Cart(CardDesignation.huit,Figure.carreau));  //8
		pack.add(new Cart(CardDesignation.huit,Figure.coeur));  //8
		pack.add(new Cart(CardDesignation.huit,Figure.treffle));  //8
		pack.add(new Cart(CardDesignation.huit,Figure.pique));  //8
		
		pack.add(new Cart(CardDesignation.neuf,Figure.carreau));  //9
		pack.add(new Cart(CardDesignation.neuf,Figure.coeur));  //9
		pack.add(new Cart(CardDesignation.neuf,Figure.treffle));  //9
		pack.add(new Cart(CardDesignation.neuf,Figure.pique));  //9
		
		pack.add(new Cart(CardDesignation.dix,Figure.carreau));  //10
		pack.add(new Cart(CardDesignation.dix,Figure.coeur));  //10
		pack.add(new Cart(CardDesignation.dix,Figure.treffle));  //10
		pack.add(new Cart(CardDesignation.dix,Figure.pique));  //10
		
		pack.add(new Cart(CardDesignation.onze,Figure.carreau));  //11
		pack.add(new Cart(CardDesignation.onze,Figure.coeur));  //11
		pack.add(new Cart(CardDesignation.onze,Figure.treffle));  //11
		pack.add(new Cart(CardDesignation.onze,Figure.pique));  //11
		
		pack.add(new Cart(CardDesignation.douze,Figure.carreau));  //12
		pack.add(new Cart(CardDesignation.douze,Figure.coeur));  //12
		pack.add(new Cart(CardDesignation.douze,Figure.treffle));  //12
		pack.add(new Cart(CardDesignation.douze,Figure.pique));  //12
		
		pack.add(new Cart(CardDesignation.treize,Figure.carreau));  //13
		pack.add(new Cart(CardDesignation.treize,Figure.coeur));  //13
		pack.add(new Cart(CardDesignation.treize,Figure.treffle));  //13
		pack.add(new Cart(CardDesignation.treize,Figure.pique));  //13
		
	}
	
	/**
     * Remplissage de la liste des cartes pour un jeu de 52 cartes
     */
	public void populatePack52(ArrayList<Cart>pack)
	{
		
		pack.add(new Cart(CardDesignation.un,Figure.carreau));  //1
		pack.add(new Cart(CardDesignation.un,Figure.coeur));  //1
		pack.add(new Cart(CardDesignation.un,Figure.treffle));  //1
		pack.add(new Cart(CardDesignation.un,Figure.pique));  //1
		
		pack.add(new Cart(CardDesignation.deux,Figure.carreau));  //2
		pack.add(new Cart(CardDesignation.deux,Figure.coeur));  //2
		pack.add(new Cart(CardDesignation.deux,Figure.carreau));  //2	
		pack.add(new Cart(CardDesignation.deux,Figure.pique));  //2
		
		
		pack.add(new Cart(CardDesignation.trois,Figure.carreau));  //3
		pack.add(new Cart(CardDesignation.trois,Figure.coeur));  //3
		pack.add(new Cart(CardDesignation.trois,Figure.treffle));  //3
		pack.add(new Cart(CardDesignation.trois,Figure.pique));  //3
		
		pack.add(new Cart(CardDesignation.quatre,Figure.carreau));  //4
		pack.add(new Cart(CardDesignation.quatre,Figure.coeur));  //4
		pack.add(new Cart(CardDesignation.quatre,Figure.treffle));  //4
		pack.add(new Cart(CardDesignation.quatre,Figure.pique));  //4
		
		pack.add(new Cart(CardDesignation.cinq,Figure.carreau));  //5
		pack.add(new Cart(CardDesignation.cinq,Figure.coeur));  //5
		pack.add(new Cart(CardDesignation.cinq,Figure.treffle));  //5
		pack.add(new Cart(CardDesignation.cinq,Figure.pique));  //5
		
		pack.add(new Cart(CardDesignation.six,Figure.carreau));  //6
		pack.add(new Cart(CardDesignation.six,Figure.coeur));  //6
		pack.add(new Cart(CardDesignation.six,Figure.treffle));  //6
		pack.add(new Cart(CardDesignation.six,Figure.carreau));  //6
		
		pack.add(new Cart(CardDesignation.sept,Figure.carreau));  //7
		pack.add(new Cart(CardDesignation.sept,Figure.coeur));  //7
		pack.add(new Cart(CardDesignation.sept,Figure.treffle));  //7
		pack.add(new Cart(CardDesignation.sept,Figure.pique));  //7
		
		pack.add(new Cart(CardDesignation.huit,Figure.carreau));  //8
		pack.add(new Cart(CardDesignation.huit,Figure.coeur));  //8
		pack.add(new Cart(CardDesignation.huit,Figure.treffle));  //8
		pack.add(new Cart(CardDesignation.huit,Figure.pique));  //8
		
		pack.add(new Cart(CardDesignation.neuf,Figure.carreau));  //9
		pack.add(new Cart(CardDesignation.neuf,Figure.coeur));  //9
		pack.add(new Cart(CardDesignation.neuf,Figure.treffle));  //9
		pack.add(new Cart(CardDesignation.neuf,Figure.pique));  //9
		
		pack.add(new Cart(CardDesignation.dix,Figure.carreau));  //10
		pack.add(new Cart(CardDesignation.dix,Figure.coeur));  //10
		pack.add(new Cart(CardDesignation.dix,Figure.treffle));  //10
		pack.add(new Cart(CardDesignation.dix,Figure.pique));  //10
		
		pack.add(new Cart(CardDesignation.onze,Figure.carreau));  //11
		pack.add(new Cart(CardDesignation.onze,Figure.coeur));  //11
		pack.add(new Cart(CardDesignation.onze,Figure.treffle));  //11
		pack.add(new Cart(CardDesignation.onze,Figure.pique));  //11
		
		pack.add(new Cart(CardDesignation.douze,Figure.carreau));  //12
		pack.add(new Cart(CardDesignation.douze,Figure.coeur));  //12
		pack.add(new Cart(CardDesignation.douze,Figure.treffle));  //12
		pack.add(new Cart(CardDesignation.douze,Figure.pique));  //12
		
		pack.add(new Cart(CardDesignation.treize,Figure.carreau));  //13
		pack.add(new Cart(CardDesignation.treize,Figure.coeur));  //13
		pack.add(new Cart(CardDesignation.treize,Figure.treffle));  //13
		pack.add(new Cart(CardDesignation.treize,Figure.pique));  //13
		
	}
	
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bar;

/**
 *
 * @author USER
 */
public enum Bijoux {
    couronne("COURONNE"),
    boucle("BOUCLE"),
    diademe("DIADÈME"),
    bague("BAGUE"),
    solitaire("SOLITAIRE"),
    bracelet("BRACELET"),
    collier("COLLIER"),
    predentif("PENDENTIF"),
    broche("BROCHE"),
    divers("DIVERS"),
    amulette("AMULETTE"),
    chaine("CHAÎNE"),
    chapelet("CHAPELET"),
    medaillon("MÉDAILLON"),
    montre("MONTRE");
    
    private String bijou;
	
	private Bijoux(String bijou)
	{
		this.bijou= bijou;
	}
	public String getBijou()
	{
		return this.bijou;
	}
	
	
}

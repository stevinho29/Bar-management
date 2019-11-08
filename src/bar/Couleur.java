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
public enum Couleur {
    bleu("BLEU"),
    noir("NOIR"),
    blanc("BLANC"),
    rouge("ROUGE"),
    jaune("JAUNE"),
    orange("ORANGE"),
    vert("VERT"),
    violet("VIOLET");
    
    private String color;
	
	private Couleur(String color)
	{
		this.color= color;
	}
	public String getColor()
	{
		return this.color;
	}
}

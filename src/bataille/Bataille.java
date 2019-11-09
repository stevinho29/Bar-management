package bataille;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Bataille {
	public static void start() {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in); // instance de la classe Scanner
		
		
		// fonctionnalités à rajouter:
		/*
		 * 	passer le jeu à tout  moment  
		 *  jouer contre l'ordinateur OK
		 *  jouer contre un autre joueur OK 
		 */		
	   
	do{	
		Pack pack= null;
		char typeChoix[] = {'x','y','n','c'}; 	 // tableau contenant les choix possibles de l'utilisteur
		char choix = 0; 						 	 // variable de choix utilisée dans le jeu
	    	    
	    
		System.out.println("Bienvenue sur l'interface du jeu de la bataille");
		System.out.println("Pour la navigation dans le jeu les commandes sont les suivantes \n arreter la partie : x \n confirmer : y \n refuser: n \n afficher les commandes de navigation : c ");
		do { // préambule
			try {
			System.out.println(" voulez-vous commencer une partie ? :");
			choix =sc.nextLine().charAt(0);  // on récupère le permier caractère
			}catch(Exception e)
			{
				System.out.println(e.getMessage()+"\n");
			}
			if(choix == 'c') // on affiche les commandes de navigation
				System.out.println("Pour la navigation dans le jeu les commandes sont les suivantes \n arreter la partie : x \n confirmer : y \n refuser: n \n afficher les commandes de navigation : c ");
			
		}while(!Arrays.toString(typeChoix).contains(String.valueOf(choix)) && (choix != 'x') && (choix !='y'));
		
		do { // on commence le jeu 
			
			 do { // sélection du nombre de cartes du jeu
				 try {
					System.out.println("un jeu de 32 ou de 52 ?: \n 32 : y \n 52 : n");
					choix =sc.nextLine().charAt(0);  // on récupère le permier caractère
				 }catch(Exception e)
				 {
					 System.out.println(e.getMessage());
				 }
			 	}while(!Arrays.toString(typeChoix).contains(String.valueOf(choix)) && choix != 'x' && choix != 'y' && choix != 'n');
		        
			 	/////////////////////////////////////////////////////////////////////////////////////
			 		pack= selectPack(pack,choix);
			 	/////////////////////////////////////////////////////////////////////////////////////	
		        
		      do { // sélection du mode de jeu ( vs player or  vs bot)
		    	  try {
						System.out.println("contre un bot ou real player ?: \n bot : y \n player : n");
						choix =sc.nextLine().charAt(0);  // on récupère le permier caractère
		    	  }catch(Exception e)
		    	  {
		    		  System.out.println(e.getMessage());
		    	  }
				 }while(!Arrays.toString(typeChoix).contains(String.valueOf(choix)) && choix != 'x' && choix != 'y' && choix != 'n');
		      	 
		      	/////////////////////////////////////////////////////////////////////////////////
		          selectMode(pack,choix);
		          
		        /////////////////////////////////////////////////////////////////////
		        	
			}while(!Arrays.toString(typeChoix).contains(String.valueOf(choix)) && choix != 'x');
	
		System.out.println("fin du jeu à bientot\n\n");
	}while(true);
	
	}
	
	
public static Pack getPack(int nb) 					 // on génère le paquet de carte
{
	Pack pack= new Pack(nb);
	Collections.shuffle(pack.getPack());			 // on mélange les cartes de son jeu
	
	return pack;
	
}
public static void selectMode(Pack pack,char choix)
{
	if(choix == 'y') // contre le bot
    {
		versusBot(pack,pack.getPack().size());
    }
	else
		versusPlayer(pack,pack.getPack().size());
}
public static Pack selectPack(Pack pack ,char choix)
{
	int nbCartes= 0;						 // nombre de cartes dans le jeu
	
	if(choix == 'y') // un jeu de 32 CARTES
    {
    	
    	nbCartes= NumberOfCard.Jeu32.getNbCartes(); 
    	pack= getPack(nbCartes);
    	System.out.println("c'est parti pour un jeu de 32 cartes");
    	return pack;
    }
    else // un jeu de 52 CARTES
    {
    	nbCartes= NumberOfCard.Jeu52.getNbCartes();   				// nombre de cartes dans le jeu
    	pack= getPack(nbCartes);
    	System.out.println("c'est parti pour un jeu de 52 cartes");
    	return pack;
    }
}
public static void versusBot(Pack pack,int nbCartes)
{
	Scanner sc = new Scanner(System.in); // instance de la classe Scanner
		
	int carte=0;							 // carte sélectionnée
	final ArrayList<Integer> t1 = new ArrayList<Integer>(); 				 // tableau 1
	int  firstPlayerResult= 0; 				 // nombre de points du 1er joueur
    int  secondPlayerResult= 0;				 // nombre de points du second joueur
	int retenu= 0;							 // quand il y'a bataille
    int middle = nbCartes/2 ;
    
    for(int i= 0;i < middle;i++ )
    {
    	do {	
    			try {
	        	System.out.println("choisissez une carte parmis vos "+ (middle - t1.size())+" cartes restantes: ");
	        	carte= sc.nextInt(); 					  // on récupère la saisie du joueur
    			}catch(Exception e)
    			{
    				System.out.println(e.getMessage());
    			}
	        	if(t1.contains(Integer.valueOf(carte)))
	        		System.out.println("Cette carte a déja été sélectionnée");
	        	else
	        		System.out.println("vous avez choisi la carte "+ pack.getPack().get(carte).getNumber().getCardDesignation()+" de "+pack.getPack().get(carte).getFigure());
    		}while(t1.contains(Integer.valueOf(carte))); // tant que la carte sélectionnée a déja été selectionnée
    	t1.add(carte);  							 // on sauvegarde la carte sélectionnée pour le prochain tour
    	
    	//System.out.println("valeur du tableau de rentention "+ t1.get(i));
    	
    		if(pack.getPack().get(carte).getNumber().getCardPower() > pack.getPack().get(carte+middle).getNumber().getCardPower())
    		{
    			if(retenu == 0)
    				firstPlayerResult+= 1; 
    			else
    				{
    					firstPlayerResult += retenu ;
    					retenu = 0;
    				}
    		}
    		else if(pack.getPack().get(carte).getNumber().getCardPower() < pack.getPack().get(carte+middle).getNumber().getCardPower())
    		{
    			if(retenu == 0)
    				secondPlayerResult+= 1; 
    			else
    				{
    					secondPlayerResult += retenu ;
    					retenu = 0;
    				}
    		}
    		else
    		{
    			System.out.println("il y'a bataille, jouez un tour de plus "); 
    			retenu++;
    		}
    		//pack.getPack().remove(carte);  // on supprime la carte tirée de la 1ere moitié
    		//pack.getPack().remove(carte+middle);  // on supprime la carte tirée de la 1ere moitié
    	
    }
    
    if(firstPlayerResult > secondPlayerResult)
    {
    	System.out.println("le gagnant est le joueur numéro 1 avec "+ firstPlayerResult+" points");
    	System.out.println(" le joueur numéro 2 a "+ secondPlayerResult+" points");
    }
    else if (firstPlayerResult < secondPlayerResult)
    {
    	System.out.println("le gagnant est le joueur numéro 2 avec "+ secondPlayerResult+" points");
    	System.out.println(" le joueur numéro 1 a "+ firstPlayerResult+" points");
    }
    else
    	System.out.println(" Vous terminez à égalité");
}

public static void versusPlayer(Pack pack,int nbCartes)
{
	Scanner sc = new Scanner(System.in); // instance de la classe Scanner
	
	int carte1=0;							 // carte joueur 1 sélectionnée
	int carte2=0;							 // carte joueur 2 sélectionnée
	final ArrayList<Integer> t1 = new ArrayList<Integer>(); 				 // tableau 1
	final ArrayList<Integer> t2 = new ArrayList<Integer>(); 				 // tableau 1
	int  firstPlayerResult= 0; 				 // nombre de points du 1er joueur
    int  secondPlayerResult= 0;				 // nombre de points du second joueur
	int retenu= 0;							 // quand il y'a bataille
	int middle = nbCartes/2 ;
	
	for(int i= 0;i < middle;i++ )
    {
		////////////////////////////////////// joueur 2 ///////////////////////////////////////////
		do {	
			try{
			    	System.out.println("1 er joueur choisissez une carte parmis vos "+ (middle - t1.size())+" cartes restantes: ");
			    	carte1= sc.nextInt(); 					  // on récupère la saisie du joueur
			}catch(Exception e)
			{
				    System.out.println(e.getMessage());
			}
	    	if(t1.contains(Integer.valueOf(carte1)))
	    		System.out.println("Cette carte a déja été sélectionnée");
	    	else
	    		System.out.println("vous avez choisi la carte "+ pack.getPack().get(carte1).getNumber().getCardDesignation()+" de "+pack.getPack().get(carte1).getFigure());
		}while(t1.contains(Integer.valueOf(carte1))); // tant que la carte sélectionnée a déja été selectionnée
	t1.add(carte1);  							      // on sauvegarde la carte sélectionnée pour le prochain tour
	
	    ////////////////////////////////////// joueur 2 ///////////////////////////////////////////
	do {	
		try{
		        System.out.println("2 eme joueur choisissez une carte parmis vos "+ (middle - t2.size())+" cartes restantes: ");
		    	carte2= sc.nextInt(); 					  // on récupère la saisie du joueur
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
	    	if(t2.contains(Integer.valueOf(carte2)))
	    		System.out.println("Cette carte a déja été sélectionnée");
	    	else
	    		System.out.println("vous avez choisi la carte "+ pack.getPack().get(carte2).getNumber().getCardDesignation()+" de "+pack.getPack().get(carte2).getFigure());
		}while(t2.contains(Integer.valueOf(carte2))); // tant que la carte sélectionnée a déja été selectionnée
   t2.add(carte2);  							 // on sauvegarde la carte sélectionnée pour le prochain tour
    
	//System.out.println("valeur du tableau de rentention "+ t1.get(i));
	
		if(pack.getPack().get(carte1).getNumber().getCardPower() > pack.getPack().get(carte2+middle).getNumber().getCardPower())
		{
			if(retenu == 0)
				firstPlayerResult+= 1; 
			else
				{
					firstPlayerResult += retenu ;
					retenu = 0;
				}
		}
		else if(pack.getPack().get(carte1).getNumber().getCardPower() < pack.getPack().get(carte2+middle).getNumber().getCardPower())
		{
			if(retenu == 0)
				secondPlayerResult+= 1; 
			else
				{
					secondPlayerResult += retenu ;
					retenu = 0;
				}
		}
		else
		{
			System.out.println("il y'a bataille, jouez un tour de plus "); 
			retenu++;
		}
		//pack.getPack().remove(carte);         // on supprime la carte tirée de la 1ere moitié
		//pack.getPack().remove(carte+middle);  // on supprime la carte tirée de la 1ere moitié
	
	    }

		if(firstPlayerResult > secondPlayerResult)
		{
			System.out.println("le gagnant est le joueur numéro 1 avec "+ firstPlayerResult+" points");
			System.out.println(" le joueur numéro 2 a "+ secondPlayerResult+" points");
		}
		else if (firstPlayerResult < secondPlayerResult)
		{
			System.out.println("le gagnant est le joueur numéro 2 avec "+ secondPlayerResult+" points");
			System.out.println(" le joueur numéro 1 a "+ firstPlayerResult+" points");
		}
		else
			System.out.println(" Vous terminez à égalité");
	}

}
	
		


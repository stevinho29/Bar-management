package bataille;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * <b>Bataille est la classe representant une bataille.</b><br>
 * 
 * @author Steve NDEMANOU
 * @version 1.0
 */
public class Bataille {
	private static Scanner sc = new Scanner(System.in); // instance de la classe Scanner
	public  void start() {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in); // instance de la classe Scanner


		// fonctionnalites a� rajouter:
		/*
		 * 	passer le jeu a� tout  moment  
		 *  jouer contre l'ordinateur OK
		 *  jouer contre un autre joueur OK 
		 */		

		//do{	
		Pack pack= null;
		char typeChoix[] = {'x','y','n','c'}; 	 // tableau contenant les choix possibles de l'utilisteur
		char choix = 0; 						 // variable de choix utilisee dans le jeu


		System.out.println("Bienvenue sur l'interface du jeu de la bataille");
		System.out.println("Pour la navigation dans le jeu les commandes sont les suivantes \n arreter la partie : x \n confirmer : y \n refuser: n \n afficher les commandes de navigation : c ");
		do { // preambule	
			try {
				System.out.println(" voulez-vous commencer une partie ? :");
				choix =sc.nextLine().charAt(0);  // on recupa�re le permier caracta�re
			}catch(Exception e)
			{
				System.out.println(e.getMessage()+"\n");
			}
			if(choix == 'c') // on affiche les commandes de navigation
				System.out.println("Pour la navigation dans le jeu les commandes sont les suivantes \n arreter la partie : x \n confirmer : y \n refuser: n \n afficher les commandes de navigation : c ");

		}while(!Arrays.toString(typeChoix).contains(String.valueOf(choix)) && (choix != 'x') && (choix !='y'));
		if(choix == 'y')
		{
				do { // on commence le jeu 
		
					do { // selection du nombre de cartes du jeu
						try {
							System.out.println("un jeu de 32 ou de 52 ?: \n 32 : y \n 52 : n");
							choix =sc.nextLine().charAt(0);  // on recupere le permier caractere
						}catch(Exception e)
						{
							System.out.println(e.getMessage());
						}
					}while(!Arrays.toString(typeChoix).contains(String.valueOf(choix)) && choix != 'x' && choix != 'y' && choix != 'n');
					
					if( choix != 'x')
					{
						/////////////////////////////////////////////////////////////////////////////////////
						pack= selectPack(pack,choix);
						/////////////////////////////////////////////////////////////////////////////////////	
			
						do { // selection du mode de jeu ( vs player or  vs bot)
							try {
								System.out.println("contre un bot ou real player ?: \n bot : y \n player : n");
								choix =sc.nextLine().charAt(0);  // on recupa�re le permier caracta�re
							}catch(Exception e)
							{
								System.out.println(e.getMessage());
							}
						}while(!Arrays.toString(typeChoix).contains(String.valueOf(choix)) && choix != 'x' && choix != 'y' && choix != 'n');
			
						if(choix != 'x')
						/////////////////////////////////////////////////////////////////////////////////
						selectMode(pack,choix);
			
						/////////////////////////////////////////////////////////////////////
					}
		
				}while(!Arrays.toString(typeChoix).contains(String.valueOf(choix)) && choix != 'x');
		
				System.out.println("Bataille terminee\n\n");
		}
	//}while(choix != 'x');

	}
    
    /**
     * Generation du paquet de cartes
     * 
     * @param nb Le nombre de cartes
     */
	public static Pack getPack(int nb) 					 // on genere le paquet de carte
	{
		Pack pack= new Pack(nb);
		Collections.shuffle(pack.getPack());			 // on melange les cartes de son jeu

		return pack;

	}
	
	/**
     * Selection du mode de jeu
     * 
     * @param pack
     * @param choix
     */
	public static void selectMode(Pack pack,char choix)
	{
		if(choix == 'y') // contre le bot
		{
			versusBot(pack,pack.getPack().size());
		}
		else
			versusPlayer(pack,pack.getPack().size());
	}
	
	/**
     * Selection du pack de 32 ou 52 cartes
     * 
     * @param pack
     * @param choix
     */
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
	
	/**
     * Gestion du jeu contre la machine
     * 
     * @param pack
     * @param nbCartes
     */
	public static void versusBot(Pack pack,int nbCartes)
	{

		boolean bool;
		int carte=0;							 // carte selectionnee
		final ArrayList<Integer> t1 = new ArrayList<Integer>(); 				 // tableau 1
		int  firstPlayerResult= 0; 				 // nombre de points du 1er joueur
		int  secondPlayerResult= 0;				 // nombre de points du second joueur
		int retenu= 0;							 // quand il y'a bataille
		int middle = nbCartes/2 ;

		for(int i= 0;i < middle;i++ )
		{
			do {	bool= false;
				try {
					System.out.println("choisissez une carte parmis vos "+ (middle - t1.size())+" cartes restantes: ");
					carte= sc.nextInt(); 					  // on recupa�re la saisie du joueur
					if(carte >= 16)
						throw new IndexOutOfBoundsException();
				}catch(IndexOutOfBoundsException e)
				{
					System.out.println("cette carte n'existe pas... pique en une autre");
					sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
					bool= true;
				}catch(Exception e)
				{
					System.out.println(e.getMessage());
					sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
					bool= true;
				}
				if(!bool)
				{
					if(t1.contains(Integer.valueOf(carte)))
					{
						System.out.println("Cette carte a deja ete selectionnee");
						bool=true;
					}
					else
						System.out.println("vous avez choisi la carte "+ pack.getPack().get(carte).getNumber().getCardDesignation()+" de "+pack.getPack().get(carte).getFigure());
				}
			}while(bool); // tant que la carte selectionnee a deja ete selectionnee
			t1.add(carte);  							 // on sauvegarde la carte selectionnee pour le prochain tour

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
			//pack.getPack().remove(carte);  // on supprime la carte tiree de la 1ere moitie
			//pack.getPack().remove(carte+middle);  // on supprime la carte tiree de la 1ere moitie

		}

		if(firstPlayerResult > secondPlayerResult)
		{
			System.out.println("le gagnant est le joueur numero 1 avec "+ firstPlayerResult+" points");
			System.out.println(" le joueur numero 2 a "+ secondPlayerResult+" points");
		}
		else if (firstPlayerResult < secondPlayerResult)
		{
			System.out.println("le gagnant est le joueur numero 2 avec "+ secondPlayerResult+" points");
			System.out.println(" le joueur numero 1 a "+ firstPlayerResult+" points");
		}
		else
			System.out.println(" Vous terminez a� egalite");
	}
	
	/**
     * Gestion du jeu entre deux joueurs
     * 
     * @param pack
     * @param nbCartes
     */
	public static void versusPlayer(Pack pack,int nbCartes)
	{
		boolean bool;
		int carte1=0;							 // carte joueur 1 selectionnee
		int carte2=0;							 // carte joueur 2 selectionnee
		final ArrayList<Integer> t1 = new ArrayList<Integer>(); 				 // tableau 1
		final ArrayList<Integer> t2 = new ArrayList<Integer>(); 				 // tableau 1
		int  firstPlayerResult= 0; 				 // nombre de points du 1er joueur
		int  secondPlayerResult= 0;				 // nombre de points du second joueur
		int retenu= 0;							 // quand il y'a bataille
		int middle = nbCartes/2 ;

		for(int i= 0;i < middle;i++ )
		{
			////////////////////////////////////// joueur 1 ///////////////////////////////////////////
			do {	
				bool= false;
			try {
				System.out.println("Joueur 1 choisissez une carte parmis vos "+ (middle - t1.size())+" cartes restantes: ");
				carte1= sc.nextInt(); 					  // on recupa�re la saisie du joueur
				if(carte1 >= 16)
					throw new IndexOutOfBoundsException();
			}catch(IndexOutOfBoundsException e)
			{
				System.out.println("cette carte n'existe pas... pique en une autre");
				sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
				bool= true;
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
				sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
				bool= true;
			}
			if(!bool)
			{
				if(t1.contains(Integer.valueOf(carte1)))
				{
					System.out.println("Cette carte a deja ete selectionnee");
					bool=true;
				}
				else
					System.out.println("vous avez choisi la carte "+ pack.getPack().get(carte1).getNumber().getCardDesignation()+" de "+pack.getPack().get(carte1).getFigure());
			}
		}while(bool); // tant que la carte selectionnee a deja ete selectionnee
		t1.add(carte1);  							 // on sauvegarde la carte selectionnee pour le prochain tour

			////////////////////////////////////// joueur 2 ///////////////////////////////////////////
			do {	
				bool= false;
			try {
				System.out.println("Joueur 2 choisissez une carte parmis vos "+ (middle - t2.size())+" cartes restantes: ");
				carte2= sc.nextInt(); 					  // on recupa�re la saisie du joueur
				if(carte2 >= 16)
					throw new IndexOutOfBoundsException();
			}catch(IndexOutOfBoundsException e)
			{
				System.out.println("cette carte n'existe pas... pique en une autre");
				sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
				bool= true;
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
				sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
				bool= true;
			}
			if(!bool)
			{
				if(t2.contains(Integer.valueOf(carte2)))
				{
					System.out.println("Cette carte a deja ete selectionnee");
					bool=true;
				}
				else
					System.out.println("vous avez choisi la carte "+ pack.getPack().get(middle + carte2).getNumber().getCardDesignation()+" de "+pack.getPack().get(middle + carte2).getFigure());
			}
		}while(bool); // tant que la carte selectionnee a deja ete selectionnee
		t1.add(carte2);  							 // on sauvegarde la carte selectionnee pour le prochain tour

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
			//pack.getPack().remove(carte);         // on supprime la carte tiree de la 1ere moitie
			//pack.getPack().remove(carte+middle);  // on supprime la carte tiree de la 1ere moitie

		}

		if(firstPlayerResult > secondPlayerResult)
		{
			System.out.println("le gagnant est le joueur numero 1 avec "+ firstPlayerResult+" points");
			System.out.println(" le joueur numero 2 a "+ secondPlayerResult+" points");
		}
		else if (firstPlayerResult < secondPlayerResult)
		{
			System.out.println("le gagnant est le joueur numero 2 avec "+ secondPlayerResult+" points");
			System.out.println(" le joueur numero 1 a "+ firstPlayerResult+" points");
		}
		else
			System.out.println(" Vous terminez a� egalite");
	}

}




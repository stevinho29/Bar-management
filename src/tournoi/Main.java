package tournoi;							
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import bar.*;

public class Main {

	private static Utilisateur user= new Utilisateur();		// une instance d'utilisateur
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// programme principal  //
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in); // instance de la classe Scanner
		
	//do {
			char typeChoix[] = {'x','y','n','c'}; 	 // tableau contenant les choix possibles de l'utilisteur
			int  typeSelection[] = {1,2}; 	 // tableau contenant les choix(valeurs entières) possibles de l'utilisteur
			char choix = 0; 						 	 // variable de choix(caractère) utilisée dans le jeu
		    int  selection =0;							// variable de choix(entier) utilisée dans le jeu			    
		    Bar bar;
			System.out.println("Bonjour et Bienvenue sur notre plateforme de gestion du bar du futur");
			System.out.println("un tas de surprises et des actions folles vous attendent... donc accrochez-vous");
			
			
			
			do { // préambule
				try {
					System.out.println("à ce niveau vous avez deux choix:\n 1: soit vous entrez dans un des bar que nous possédons,\n 2: soit vous créez le votre");
					selection =sc.nextInt();  // on récupère le permier caractère
					
				}catch(InputMismatchException e)
				{
					System.out.println(e.getMessage()+"\n");
					sc.nextLine(); 								// on replace la tete de lecture au début de la ligne suivant afin d'éviter qu'elle ne soit avalée
				}
				if(selection == 1) // on affiche les commandes de navigation
				{
					boolean bool;
					System.out.println("RAVI QUE VOUS NOUS FASSIEZ CONFIANCE ");
					System.out.println("tout d'abord on va te montrer la liste des bars disponibles");
					displayBarlist();
					do{
						 bool= false;
					 try{
							System.out.println("fais ton choix: ");
							selection =sc.nextInt();  // on récupère le permier caractère
						}catch(InputMismatchException e)
						{
							System.out.println(e.getMessage()+"\n");
							sc.nextLine(); 								// on replace la tete de lecture au début de la ligne suivante afin d'éviter qu'elle ne soit avalée
							bool= true;
						}
					}while(bool);
					do{     											// à la sortie de ce do while j'ai forcément récupéré le bar dans le quel il veut entrer
						 
						 if(bool == true)
						 {
							 
						  try{
							  System.out.println("ce bar n'existe pas……refais la selection");
							  selection =sc.nextInt();  // on récupère le permier caractère
							  bar= Utilisateur.getBarList().get(selection);
							  bool= false;
						  	}catch(Exception e){
						  		System.out.println(e.getMessage());
						  		bool =true;
						  }
						 }
						 else	// ne s'exécute qu'une seule fois si tout est bon on sort du while sinn 
						 {
							 try{
								  bar= Utilisateur.getBarList().get(selection);
							  	}catch(Exception e){
							  		System.out.println(e.getMessage());
							  		bool =true;
							  } 
						 }
					}
					while(bool);
					System.out.println("c'est donc au "+Utilisateur.getBarList().get(selection).getNom()+" que tu veux entrer…… Bon choix ");
					System.out.println("Devine quoi…… le videur c'est un de nos potes tu rentres et tu sors comme tu veux on a géré");
					System.out.println("tu y es………ooh putain c'est une bombe……les serveuses sont à craquer\n……des tournois de cartes\n……la patronne qui offre des tournées………\n"
							+ "décides-toi Mec……\nVoici une liste de ce que tu peux faire ");
					System.out.println("1:causer avec une serveuse/serveur"
							+ "2:prendre un verre"
							+ "3:participer à un tournoi"
							+ "4:soyons fous……créer ton propre tournoi ");
				}
				else if(selection == 2)
				{
					System.out.println("Vous voulez donc créer un bar à  votre image!!……………\n nous allons donc vous posez une série de question afin de réaliser votre souhait "
							+ "cela prendra une minute tout au plus ");
				}
				
			}while(!Arrays.toString(typeSelection).contains(String.valueOf(selection)) && (selection != 1) && (choix != 2));
			
		//}while();
		
	}
	
	public static void displayBarlist()
	{
		user.displayBarList();
	}

}

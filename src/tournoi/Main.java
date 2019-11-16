package tournoi;							
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import bar.Bar;
import bar.Barman;
import bar.Boisson;
import bar.Client;
import bar.Humain;
import bar.Serveur;
import bataille.Bataille;

public class Main {

	private static Utilisateur user= new Utilisateur();		// une instance d'utilisateur
	private static char typeChoix[] = {'x','y','n','c'}; 	 // tableau contenant les choix possibles de l'utilisteur
	private static int  typeSelection[] = {1,2}; 	 // tableau contenant les choix(valeurs entières) possibles de l'utilisteur
	private static char choix = 0; 						 	 // variable de choix(caractère) utilisée dans le jeu
    private static int  selection =0;							// variable de choix(entier) utilisée dans le jeu			    
    private static Bar bar = null;
    private static Client client= null;
    private static boolean bool;
    private static Bataille game= new Bataille();
    @SuppressWarnings("resource") 
	private static Scanner sc = new Scanner(System.in); // instance de la classe Scanner
	public static void main(String[] args) throws TournamentStateException,AllowedPlayerException {
		// TODO Auto-generated method stub

		// programme principal  //
		
		
		
	//do {
			
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
					System.out.println("Devine quoi…… le videur c'est un de nos potes, tu rentres et tu sors comme tu veux on a géré");
					
					// selecetion du personnage (client)
					
					selectMyPerso(bar);
					
					// on entre dans le bar
					do {
						try {
						System.out.println("tu y es………ooh putain c'est une bombe……les serveuses sont à craquer\n……des tournois de cartes\n……la patronne qui offre des tournées………\n"
								+ "décides-toi Mec……\nVoici une liste de ce que tu peux faire ");
						System.out.println("1:causer avec une serveuse/serveur\n"
								+ "2:prendre un verre\n"
								+ "3:participer à un tournoi\n"
								+ "4:soyons fous……créer ton propre tournoi\n");
						selection= sc.nextInt();
						}catch( InputMismatchException e)
						{
							bool= true;
							sc.nextLine(); 								// on replace la tete de lecture au début de la ligne suivante afin d'éviter qu'elle ne soit avalée
							System.out.println(e.getMessage());
						}
						
					}while((selection != 1) && (selection != 2) &&(selection != 3) && (selection != 4) && (bool= true));
				
					switch(selection) {
						case(1):
								talkToServeurs(bar);
							break;
						case(2):
								takeAshot(bar);
							break;
						case(3):
							    startTournament(bar);	
							break;
						case(4):
								createTournament(bar);
							break;
						}
				}
				else if(selection == 2)
				{
					System.out.println("Vous voulez donc créer un bar à votre image!!……………\n nous allons donc vous posez une série de question afin de réaliser votre souhait "
							+ "cela prendra une minute tout au plus ");
				}
				
			}while(!Arrays.toString(typeSelection).contains(String.valueOf(selection)) && (selection != 1) && (choix != 2));
			
		//}while();
		
	}
	
	public static void displayBarlist()
	{
		user.displayBarList();
	}
	public static void talkToServeurs(Bar bar)
	{
		Serveur serveur= null;
	
			do{
				
				 bool= false;
			 try{
				 System.out.println("Bon voici la liste des serveurs et serveuses du bar");
					for(int i=0;i <bar.getServeurs().size();i++)
					{
						System.out.println((i)+"-"+bar.getServeurs().get(i).getSurnom());
					}
					System.out.println("fais ton choix");
					selection= sc.nextInt();
					
				}catch(InputMismatchException e)
				{
					System.out.println(e.getMessage()+"\n");
					sc.nextLine(); 								// on replace la tete de lecture au début de la ligne suivante afin d'éviter qu'elle ne soit avalée
					bool= true;
				}
			}while(bool);
			do{     											// à la sortie de ce do while j'ai forcément récupéré un serveur disponible
				 
				 if(bool == true)
				 {
					 
				  try{
					  System.out.println("désolé cette serveuse/serveur existe pas…… appelles-en une/un autre");
					  selection =sc.nextInt();  // on récupère le permier caractère
					  serveur= bar.getServeurs().get(selection);
					  bool= false;
				  	}catch(Exception e){
				  		System.out.println(e.getMessage());
				  		bool =true;
				  }
				 }
				 else	// ne s'exécute qu'une seule fois si tout est bon on sort du while sinn 
				 {
					 try{
						 serveur= bar.getServeurs().get(selection);
					  	}catch(Exception e){
					  		System.out.println(e.getMessage());
					  		bool =true;
					  } 
				 }
			}
			while(bool);
		
			// on fait parler le/la serveur/se
		    System.out.println("et voici "+serveur.getSurnom()+" pour te servir");
		    serveur.presentMyself();
		    serveur.parler("que puis-je faire pour toi?");
		    
	}
    public static void selectMyPerso(Bar bar)
    {
    	do{
			
			 bool= false;
		 try{
			 System.out.println("Bon voici la liste des clients que tu peux incarner");
				for(int i=0;i <bar.getClientList().size();i++)
				{
					System.out.println((i)+"-"+bar.getClientList().get(i));
				}
				System.out.println("fais ton choix");
				selection= sc.nextInt();
				
			}catch(InputMismatchException e)
			{
				System.out.println(e.getMessage()+"\n");
				sc.nextLine(); 								// on replace la tete de lecture au début de la ligne suivante afin d'éviter qu'elle ne soit avalée
				bool= true;
			}
		}while(bool);
		do{     											// à la sortie de ce do while j'ai forcément récupéré une boisson disponible
			 
			 if(bool == true)
			 {
				 
			  try{
				  System.out.println("désolé ce client a quitté le bar …… sélectionnes-en une/un autre");
				  selection =sc.nextInt();  // on récupère le permier caractère
				  client= bar.getClientList().get(selection);
				  bool= false;
			  	}catch(Exception e){
			  		System.out.println(e.getMessage());
			  		bool =true;
			  }
			 }
			 else	// ne s'exécute qu'une seule fois si tout est bon on sort du while sinn 
			 {
				 try{
					 client= bar.getClientList().get(selection);
				  	}catch(Exception e){
				  		System.out.println(e.getMessage());
				  		bool =true;
				  } 
			 }
		}
		while(bool);
		
		System.out.println("Nickel tu seras donc "+ client.getPrenom()+" surnommé " +client.getSurnom());
    }
	public static void takeAshot(Bar bar)


	{
		Barman barman= bar.getBarman();
		Boisson boisson= null;
		System.out.println("Bon le barman s'appelle"+barman.getSurnom() +"il est hyper sympa");
		barman.presentMyself();
		barman.parler("salut mon petit pote je te présente les boissons ok!!!");
		
		do{
			
			 bool= false;
		 try{
			 System.out.println("Bon voici la liste des boissons que je peux te proposer");
				for(int i=0;i <bar.getInventaire().size();i++)
				{
					System.out.println((i)+"-"+bar.getInventaire().get(i));
				}
				System.out.println("fais ton choix");
				selection= sc.nextInt();
				
			}catch(InputMismatchException e)
			{
				System.out.println(e.getMessage()+"\n");
				sc.nextLine(); 								// on replace la tete de lecture au début de la ligne suivante afin d'éviter qu'elle ne soit avalée
				bool= true;
			}
		}while(bool);
		do{     											// à la sortie de ce do while j'ai forcément récupéré une boisson disponible
			 
			 if(bool == true)
			 {
				 
			  try{
				  System.out.println("désolé cette boisson existe pas…… commandes-en une/un autre");
				  selection =sc.nextInt();  // on récupère le permier caractère
				  boisson= bar.getInventaire().get(selection);
				  bool= false;
			  	}catch(Exception e){
			  		System.out.println(e.getMessage());
			  		bool =true;
			  }
			 }
			 else	// ne s'exécute qu'une seule fois si tout est bon on sort du while sinn 
			 {
				 try{
					 boisson= bar.getInventaire().get(selection);
				  	}catch(Exception e){
				  		System.out.println(e.getMessage());
				  		bool =true;
				  } 
			 }
		}
		while(bool);
		barman.vendreBoisson(boisson, boisson.getQuantite(), client, client);
	}
	
	/**
	 * Commencer le tournoi
	 */
	public static void startTournament(Bar bar) 

	{
		Tournoi tournoi= null;
		do{
			
			 bool= false;
		 try{
			 System.out.println("Bon voici la liste des tournois du bar");
				bar.displayTournamentList();
				System.out.println("fais ton choix");
				selection= sc.nextInt();
				
			}catch(InputMismatchException e)
			{
				System.out.println(e.getMessage()+"\n");
				sc.nextLine(); 								// on replace la tete de lecture au début de la ligne suivante afin d'éviter qu'elle ne soit avalée
				bool= true;
			}
		}while(bool);
		do{     											// à la sortie de ce do while j'ai forcément récupéré une tournoi disponible
			 
			 if(bool == true)
			 {
				 
			  try{
				  System.out.println("désolé ce tournoi existe pas ou est deja passé…… sélectionnes-en une/un autre");
				  selection =sc.nextInt();  // on récupère le permier caractère
				  tournoi= bar.getTournamentList().get(selection);
				  bool= false;
			  	}catch(Exception e){
			  		System.out.println(e.getMessage());
			  		bool =true;
			  }
			 }
			 else	// ne s'exécute qu'une seule fois si tout est bon on sort du while sinn 
			 {
				 try{
					 tournoi= bar.getTournamentList().get(selection);
					 if(tournoi.getState()== TournamentState.passé)
						 throw  new TournamentStateException();
				  	}catch(Exception e){
				  		System.out.println(e.getMessage());
				  		bool =true;
				  } 
			 }
		}
		while(bool);
		bar.getPatronne().annonceTournament(tournoi);				// la patronne annonce le tournoi
		// on affiche la liste des équipes
		tournoi.displayTeamList();
		// début du jeu de la bataille
		game.start();
		// on clot le tournoi
		tournoi.setState(TournamentState.passé);
		//affichage des résultats
		
	}

	public static void createTournament(Bar bar)
	{
		int counter=0;
		String name;
		int winprice;
		int participationCost;
		String tournamentPoster;
		ArrayList<Equipe> teamList;
		ArrayList<Humain> playerList= null;
		Humain player;
		System.out.println("here we go pour la creation de ton tournoi");
		System.out.println("de manière séquentielle on va te poser des quetions qui nous permettront de créer et d'organiser ton tournoi"
				+ "ca va etre un petit peu long donc accroche toi");
		do {
			bool= false;
			try{
				System.out.println("nom du tournoi ");
				name= sc.nextLine();
			}catch(InputMismatchException e)
			{
				System.out.println(e.getMessage()+"\n");
				sc.nextLine(); 								// on replace la tete de lecture au début de la ligne suivante afin d'éviter qu'elle ne soit avalée
				bool= true;
			}
		}while(bool);
		do {
			bool= false;
			try{
				System.out.println("prix du gagnant ");
				winprice= sc.nextInt();
			}catch(InputMismatchException e)
			{
				System.out.println(e.getMessage()+"\n");
				sc.nextInt(); 								// on replace la tete de lecture au début de la ligne suivante afin d'éviter qu'elle ne soit avalée
				bool= true;
			}
		}while(bool);
		do {
			bool= false;
			try{
				System.out.println("cout de participation ");
				participationCost= sc.nextInt();
			}catch(InputMismatchException e)
			{
				System.out.println(e.getMessage()+"\n");
				sc.nextInt(); 								// on replace la tete de lecture au début de la ligne suivante afin d'éviter qu'elle ne soit avalée
				bool= true;
			}
		}while(bool);
		do {
			bool= false;
			try{
				System.out.println("nom du tournoi ");
				tournamentPoster= sc.nextLine();
			}catch(InputMismatchException e)
			{
				System.out.println(e.getMessage()+"\n");
				sc.nextLine(); 								// on replace la tete de lecture au début de la ligne suivante afin d'éviter qu'elle ne soit avalée
				bool= true;
			}
		}while(bool);
		System.out.println("tu vas maintenant former les équipes en sélectionnant parmis les occupants du bar... allez on y va");
		
		
		do{
			
			 bool= false;
		 try{
			 	bar.displayOccupantsList();
				System.out.println("fais ton choix");
				selection= sc.nextInt();
				
			}catch(InputMismatchException e)
			{
				System.out.println(e.getMessage()+"\n");
				sc.nextLine(); 								// on replace la tete de lecture au début de la ligne suivante afin d'éviter qu'elle ne soit avalée
				bool= true;
			}
		}while(bool);
		do{     											// à la sortie de ce do while j'ai forcément récupéré une tournoi disponible
			 
			 if(bool == true)
			 {
				 
			  try{
				  System.out.println("désolé ce tournoi existe pas ou est deja passé…… sélectionnes-en une/un autre");
				  selection =sc.nextInt();  // on récupère le permier caractère
				  player= bar.getOccupants().get(selection);
				  bool= false;
			  	}catch(Exception e){
			  		System.out.println(e.getMessage());
			  		bool =true;
			  }
			  
			  
			 }
			 else	// ne s'exécute qu'une seule fois si tout est bon on sort du while sinn 
			 {
				 try{
					 player= bar.getOccupants().get(selection);
					 if(player.getClass().getName() == "Barman" || player.getClass().getName() == "Patronne" )
						 throw  new AllowedPlayerException();
					 
					 for(int i=0;i < playerList.size();i++)
					  {
						  if((playerList.get(i).getClass().getName() == "ServeurHomme") || (playerList.get(i).getClass().getName() == "ServeurFemme"))
							  counter++;
					  }
					 if(counter == 7)
						  bool= true;  // ou alors je throw une nouvelle exception mais flemme 
					 
				  	}catch(Exception e){
				  		System.out.println(e.getMessage());
				  		bool =true;
				  } 
			 }
		}
		while(bool);
		
	}
}

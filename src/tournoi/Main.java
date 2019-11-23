package tournoi;							
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import bar.Bar;
import bar.Barman;
import bar.Bijoux;
import bar.Boisson;
import bar.Client;
import bar.Couleur;
import bar.Humain;
import bar.Patronne;
import bar.Serveur;
import bataille.Bataille;
/**
 * <b>Main est la classe principale du tournoi.</b><br>
 * Elle est caracterisee par :
 * <ul>
 * <li>Une instance d'utilisateur</li>
 * <li>Un tableau contenant les choix possibles de l'utilisteur</li>
 * <li>Un tableau contenant les sexes possibles</li>
 * <li>Un tableau contenant les choix (valeurs entieres) possibles de l'utilisteur</li>
 * <li>Une variable de choix (caractere) utilisee dans le jeu</li>
 * <li>Une variable de choix(entier) utilisee dans le jeu	</li>
 * <li>Un bar</li>
 * <li>Un client</li>
 * <li>Une instance d'utilisateur</li>
 * <li>Une bataille</li>
 * <li>Une instance d'utilisateur</li>
 * <li>L'expertise du joueur</li>
 * <li>Une instance d'utilisateur</li>
 * <li>L'expertise du joueur</li>
 * </ul>
 * 
 * @author Steve NDEMANOU
 * @version 1.0
 */
public class Main {

	/**
	 * L'instance d'utilisateur
	 */
	private static Utilisateur user= new Utilisateur();

	/**
	 * Le tableau contenant les choix possibles de l'utilisteur
	 */
	private static char typeChoix[] = {'x','y','n','c'};

	/**
	 * Le tableau contenant les sexes possibles
	 */
	private static char sexe[]= {'M','F'};

	/**
	 * Le tableau contenant les choix(valeurs entieres) possibles de l'utilisteur
	 */
	private static int  typeSelection[] = {1,2}; 	 // 

	/**
	 * La variable de choix(caractere) utilisee dans le jeu
	 */
	private static char choix = 0;

	/**
	 * La variable de choix (entier) utilisee dans le jeu
	 */
	private static int  selection =0;

	/**
	 * Le bar
	 */
	private static Bar bar = new Bar();

	/**
	 * Le client
	 */
	private static Client client= null;
	private static boolean bool;

	/**
	 * La bataille
	 */
	private static Bataille game= new Bataille();
	@SuppressWarnings("resource") 
	private static Scanner sc = new Scanner(System.in); // instance de la classe Scanner

	/**
	 * Methode principale
	 * 
	 * @throws TournamentStateException
	 * @throws AllowedPlayerException
	 * @throws NotEnoughServeurException
	 * @throws AlreadyChoosedException
	 * @throws NotAllowedValueException
	 */
	public static void main(String[] args) throws TournamentStateException, AllowedPlayerException, NotEnoughServeurException, AlreadyChoosedException, NotAllowedValueException {
		// TODO Auto-generated method stub

		// programme principal  //
		do {

			System.out.println("Bonjour et Bienvenue sur notre plateforme de gestion du bar du futur");
			System.out.println("un tas de surprises et des actions folles vous attendent... donc accrochez-vous");



			do { // preambule
				try {
					System.out.println("A ce niveau vous avez deux choix:\n 1: soit vous entrez dans un des bar que nous possedons,\n 2: soit vous creez le votre");
					selection =sc.nextInt();  // on recupere le permier caractere

				}catch(InputMismatchException e)
				{
					System.out.println(e.getMessage()+"\n");
					sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivant afin d'eviter qu'elle ne soit avalee
				}
				if(selection == 1) // on affiche les commandes de navigation
				{

					System.out.println("RAVI QUE VOUS NOUS FASSIEZ CONFIANCE ");
					System.out.println("tout d'abord nous allons te montrer la liste des bars disponibles");
					displayBarlist();
					do{
						bool= false;
						try{
							System.out.println("fais ton choix: ");
							selection =sc.nextInt();  // on recupere le permier caractere
						}catch(InputMismatchException e)
						{
							System.out.println(e.getMessage()+"\n");
							sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
							bool= true;
						}
					}while(bool);
					do{     											// A la sortie de ce do while j'ai forcement recupere le bar dans le quel il veut entrer

						if(bool == true)
						{

							try{
								System.out.println("ce bar n'existe pas !! refais la selection");
								selection =sc.nextInt();  // on recupere le permier caractere
								bar= user.getBarList().get(selection);
								bool= false;
							}catch(Exception e){
								System.out.println(e.getMessage());
								bool =true;
							}
						}
						else	// ne s'execute qu'une seule fois si tout est bon on sort du while sinn 
						{
							try{
								bar= user.getBarList().get(selection);
							}catch(Exception e){
								System.out.println(e.getMessage());
								bool =true;
							} 
						}
					}
					while(bool);

					System.out.println("c'est donc au "+user.getBarList().get(selection).getNom()+" que tu veux entrer !! Bon choix ");
					System.out.println("Devine quoi ?? le videur c'est un de nos potes, tu rentres et tu sors comme tu veux on a gere");

					// selecetion du personnage (client)

					selectMyPerso(bar);

					// on entre dans le bar
					do {
						try {
							System.out.println("tu y es!!! ooh mince c'est une bombe!!les serveuses sont a  craquer !!\n des tournois de cartes !!\\nla patronne qui offre des tournees!!!\n"
									+ "decides-toi Mec!!\nVoici une liste de ce que tu peux faire ");
							System.out.println("1:causer avec une serveuse/serveur\n"
									+ "2:prendre un verre\n"
									+ "3:participer a  un tournoi\n"
									+ "4:soyons fous!!creer ton propre tournoi\n"
									+ "5:embaucher un/une nouveau/nouvelle serveur/serveuse\n"
									+ "6:attirer un nouveau client");
							selection= sc.nextInt();
						}catch( InputMismatchException e)
						{
							bool= true;
							sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
							System.out.println(e.getMessage());
						}

					}while((selection != 1) && (selection != 2) &&(selection != 3) && (selection != 4) && (selection != 5) && (selection != 6) &&(bool= true));
					sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee

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
					case(5):
						hireNewServer(bar);
					break;
					case(6):
						attractNewClient(bar);
					break;
					}
				}
				else if(selection == 2)
				{
					sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee

					System.out.println("Vous voulez donc creer un bar a  votre image!!!!!!!\n nous allons donc vous posez une serie de question afin de realiser votre souhait "
							+ "cela prendra une minute tout au plus ");
					createBar();
				}

			}while(!Arrays.toString(typeSelection).contains(String.valueOf(selection)) && (selection != 1) && (selection != 2));

		}while(true);

	}

	/**
	 * Affiche la liste des bars
	 */
	public static void displayBarlist()
	{
		user.displayBarList();
	}

	/**
	 * Gere l'interaction avec les serveurs
	 */
	public static void talkToServeurs(Bar bar)
	{
		Serveur serveur= null;

		do{

			bool= false;
			try{
				System.out.println("Bon voici la liste des serveurs et serveuses du bar");
				for(int i=0;i <bar.getServeursList().size();i++)
				{
					System.out.println((i)+"-"+bar.getServeursList().get(i).getSurnom());
				}
				System.out.println("fais ton choix");
				selection= sc.nextInt();

			}catch(InputMismatchException e)
			{
				System.out.println(e.getMessage()+"\n");
				sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
				bool= true;
			}
		}while(bool);
		do{     											// A la sortie de ce do while j'ai forcement recupere un serveur disponible

			if(bool == true)
			{

				try{
					System.out.println("desole cette serveuse/serveur n'existe pas !! appelles-en une/un autre");
					selection =sc.nextInt();  // on recupere le permier caractere
					serveur= bar.getServeursList().get(selection);
					bool= false;
				}catch(InputMismatchException e)
				{
					System.out.println("saisie incorrecte");
					sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
					bool= true;
				}catch(Exception e){
					System.out.println(e.getMessage());
					bool =true;
				}
			}
			else	// ne s'execute qu'une seule fois si tout est bon on sort du while sinn 
			{
				try{
					serveur= bar.getServeursList().get(selection);
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

	/**
	 * Gere la selection des persos incarnables
	 */
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
				sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
				bool= true;
			}
		}while(bool);
		do{     											// A la sortie de ce do while j'ai forcement recupere une boisson disponible

			if(bool == true)
			{

				try{
					System.out.println("desole ce client a quitte le bar !! selectionnes-en une/un autre");
					selection =sc.nextInt();  // on recupere le permier caractere
					client= bar.getClientList().get(selection);
					bool= false;
				}catch(InputMismatchException e)
				{
					System.out.println("saisie incorrecte");
					sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
					bool= true;
				}catch(Exception e){
					System.out.println(e.getMessage());
					bool =true;
				}
			}
			else	// ne s'execute qu'une seule fois si tout est bon on sort du while sinn 
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

		System.out.println("Nickel tu seras donc "+ client.getPrenom()+" surnomme " +client.getSurnom());
	}

	/**
	 * Gere la commande d'une boisson
	 */
	public static void takeAshot(Bar bar)
	{
		Barman barman= bar.getBarman();
		Boisson boisson= null;
		System.out.println("Bon le barman s'appelle"+barman.getSurnom() +"il est hyper sympa");
		barman.presentMyself();
		barman.parler("salut mon petit pote je te presente les boissons ok!!!");

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
				sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
				bool= true;
			}
		}while(bool);
		do{     											// A la sortie de ce do while j'ai forcement recupere une boisson disponible

			if(bool == true)
			{

				try{
					System.out.println("desole cette boisson existe pas!! commandes-en une/un autre");
					selection =sc.nextInt();  // on recupere le permier caractere
					boisson= bar.getInventaire().get(selection);
					bool= false;
				}catch(Exception e){
					System.out.println(e.getMessage());
					bool =true;
				}
			}
			else	// ne s'execute qu'une seule fois si tout est bon on sort du while sinn 
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
		barman.vendreBoisson(boisson, boisson.getQuantite(), client, client,bar);
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
				sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
				bool= true;
			}
		}while(bool);
		do{     											// A la sortie de ce do while j'ai forcement recupere une tournoi disponible

			if(bool == true)
			{

				try{
					System.out.println("desole ce tournoi existe pas ou est deja passe!! selectionnes-en une/un autre");
					selection =sc.nextInt();  // on recupere le permier caractere
					tournoi= bar.getTournamentList().get(selection);
					bool= false;
				}catch(InputMismatchException e)
				{
					System.out.println("saisie incorrecte");
					sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
					bool= true;
				}catch(Exception e){
					System.out.println(e.getMessage());
					bool =true;
				}
			}
			else	// ne s'execute qu'une seule fois si tout est bon on sort du while sinn 
			{
				try{
					tournoi= bar.getTournamentList().get(selection);
					if(tournoi.getState()== TournamentState.passe)
						throw  new TournamentStateException();
				}catch(Exception e){
					System.out.println(e.getMessage());
					bool =true;
				} 
			}
		}
		while(bool);
		System.out.println("****************ANNONCE***************");
		bar.getPatronne().annonceTournament(tournoi);				// la patronne annonce le tournoi
		// on affiche la liste des equipes
		tournoi.displayTeamList();
		// debut du jeu de la bataille
		game.start();
		// on clot le tournoi
		tournoi.setState(TournamentState.passe);
		//affichage des resultats

	}

	/**
	 * Gere l'embauche d'un nouveau serveur
	 */
	public static void hireNewServer(Bar bar)
	{
		Serveur serveur=null;
		String serveurName="";
		String serveurSurname="";
		String cri="";
		// saisie du nom du client
		do {
			bool= false;
			try{
				System.out.println("nom du/de (la) serveur/serveuse: ");
				serveurName= sc.nextLine();
			}catch(InputMismatchException e)
			{
				System.out.println("saisie incorrecte...essaie encore");
				//sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
				bool= true;
			}
		}while(bool);
		// saisie du surnom du client
		do {
			bool= false;
			try{
				System.out.println("surnom du/de (la) serveur/serveuse: ");
				serveurSurname= sc.nextLine();
			}catch(InputMismatchException e)
			{
				System.out.println("saisie incorrecte...essaie encore");
				//sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
				bool= true;
			}
		}while(bool);
		// saisie du cri de rage de la patronne
		do {
			bool= false;
			try{
				System.out.println("cri du/de (la) serveur/serveuse: ");
				cri= sc.nextLine();
			}catch(InputMismatchException e)
			{
				System.out.println("saisie incorrecte...essaie encore");
				//sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
				bool= true;
			}
		}while(bool);
		System.out.println("nous avons enregistre les donnees du nouveau serveur a embaucher... par contre il faudra en virer un"
				+ "on va te presenter la liste des serveurs actuels");
		do {
			bool= false;
			try {
				System.out.println("quel est le sexe du client: \n M: male \n F: femelle");
				choix= sc.nextLine().charAt(0);
				if(choix == 'F')
				{
					do {
						bool= false;
						try{

							bar.displayServeursList(); 				// on affiche la liste des serveurs du bar
							selection=sc.nextInt();
							serveur= bar.getServeursList().get(selection);
							if(selection > bar.getServeursList().size())
								throw new Exception();
						}catch(InputMismatchException e)
						{
							System.out.println("saisie incorrecte...essaie encore ");
							sc.nextLine();
							bool =true;
						}catch(Exception e)
						{
							System.out.println("ce serveur n'existe pas...ou a deja ete vire");
							sc.nextLine();
							bool =true;
						}
					}while(bool);  // bijou selectionne
					bar.getServeursList().set(selection,user.createServeurHomme(serveurName, serveurSurname, cri));	// on vire(supprime) l'ancien serveur
				}
				else if(choix == 'M')
				{
					do {
						bool= false;
						try{

							bar.displayServeursList(); 				// on affiche la liste des serveurs du bar
							selection=sc.nextInt();
							serveur= bar.getServeursList().get(selection);
							if(selection > bar.getServeursList().size())
								throw new Exception();
						}catch(InputMismatchException e)
						{
							System.out.println("saisie incorrecte...essaie encore ");
							sc.nextLine();
							bool =true;
						}catch(Exception e)
						{
							System.out.println("ce serveur n'existe pas...ou a deja ete vire");
							sc.nextLine();
							bool =true;
						}
					}while(bool);  // bijou selectionne
					bar.getServeursList().set(selection,user.createServeurFemme(serveurName, serveurSurname, cri));	// on vire(supprime) l'ancien serveur


				}
			}catch(InputMismatchException e)
			{
				sc.nextLine();
				bool =true;
			}
		}while(!Arrays.toString(sexe).contains(String.valueOf(sexe)) && (choix != 'M') && (choix != 'F') && (bool));
	}

	/**
	 * Gere la creation d'un nouveau client
	 */
	public static void attractNewClient(Bar bar)
	{
		String clientName="";
		String clientSurname="";
		String cri="";
		Couleur color=Couleur.violet;
		Bijoux bijou= Bijoux.broche;
		System.out.println("De plus en plus de client!!!! Nice");
		// saisie du nom du client
		do {
			bool= false;
			try{
				System.out.println("nom du client: ");
				clientName= sc.nextLine();
			}catch(InputMismatchException e)
			{
				System.out.println("saisie incorrecte...essaie encore");
				//sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
				bool= true;
			}
		}while(bool);
		// saisie du surnom du client
		do {
			bool= false;
			try{
				System.out.println("surnom du client: ");
				clientSurname= sc.nextLine();
			}catch(InputMismatchException e)
			{
				System.out.println("saisie incorrecte...essaie encore");
				//sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
				bool= true;
			}
		}while(bool);
		// saisie du cri de rage de la patronne
		do {
			bool= false;
			try{
				System.out.println("cri du client: ");
				cri= sc.nextLine();
			}catch(InputMismatchException e)
			{
				System.out.println("saisie incorrecte...essaie encore");
				//sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
				bool= true;
			}
		}while(bool);
		do {
			bool= false;
			try {
				System.out.println("quel est le sexe du client: \n M: male \n F: femelle");
				choix= sc.nextLine().charAt(0);
				if(choix == 'F')
				{
					do {
						bool= false;
						try{
							System.out.println("Quel bijou porte t-elle\n"
									+ " 1- perle\n "
									+ "2-collier\n "
									+ "3-pendantif\n "
									+ "4-gourmette");
							selection=sc.nextInt();
							if(selection !=1 && selection !=2 && selection !=3 && selection !=4)
								throw new NotAllowedValueException();
						}catch(InputMismatchException e)
						{
							System.out.println("saisie incorrecte...essaie encore ");
							sc.nextLine();
							bool =true;
						}catch(Exception e)
						{
							sc.nextLine();
							bool =true;
						}
					}while(bool);  // bijou selectionne
					switch(selection) {

					case(1):
						bijou= Bijoux.amulette;
					break;
					case(2):
						bijou= Bijoux.collier;
					break;
					case(3):
						bijou= Bijoux.diademe;
					break;
					case(4):
						bijou= Bijoux.bague;
					break;
					}
				}
				else if(choix == 'M')
				{
					do { 
						bool= false;
						try {
							System.out.println("Quelle est sa couleur de t-shirt\\n 1- bleu\\n 2-jaune\\n 3-rouge\\n 4-vert");
							selection=sc.nextInt();
							if(selection !=1 && selection !=2 && selection !=3 && selection !=4)
								throw new NotAllowedValueException();
						}catch(InputMismatchException e)
						{
							System.out.println("saisie incorrecte...essaie encore ");
							sc.nextLine();
							bool =true;
						}catch(Exception e)
						{
							sc.nextLine();
							bool =true;
						}
					}while(bool);		// couleur selectionnee

					switch(selection) {
					case(1):
						color= Couleur.bleu;
					break;
					case(2):
						color= Couleur.jaune;
					break;
					case(3):
						color= Couleur.rouge;
					break;
					case(4):
						color= Couleur.vert;
					break;

					}
				}
			}catch(InputMismatchException e)
			{
				sc.nextLine();
				bool =true;
			}
		}while(!Arrays.toString(sexe).contains(String.valueOf(sexe)) && (choix != 'M') && (choix != 'F') && (bool));
		if(choix =='F')
			bar.getOccupants().add(user.createClientHomme(clientName, clientSurname, cri, color));
		else
			bar.getOccupants().add(user.createClientFemme(clientName, clientSurname, cri, bijou));
	}

	/**
	 * Gere la creation d'un tournoi
	 */
	public static void createTournament(Bar bar)
	{
		int counter=0;

		String name="";
		String teamName="";
		int winprice=0;
		int participationCost=0;
		String tournamentPoster="";
		ArrayList<Equipe> teamList= new ArrayList<Equipe>();
		ArrayList<Humain> playerList= new ArrayList<Humain>();
		ArrayList<Humain> usefulList= new ArrayList<Humain>();
		Humain player;
		Equipe team= new Equipe();
		System.out.println("here we go pour la creation de ton tournoi");
		System.out.println("de maniere sequentielle on va te poser des quetions qui nous permettront de creer et d'organiser ton tournoi"
				+ "ca va etre un petit peu long donc accroche toi");
		// saisie du nom du tournoi
		do {
			bool= false;
			try{
				System.out.println("nom du tournoi: ");
				name= sc.nextLine();
			}catch(InputMismatchException e)
			{
				System.out.println("saisie incorrecte...essaie encore");
				//sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
				bool= true;
			}catch(Exception e)
			{
				sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
				bool= true;
			}
		}while(bool);

		// saisie du prix 
		do {
			bool= false;
			try{
				System.out.println("prix du gagnant: ");
				winprice= sc.nextInt();
				sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
			}catch(InputMismatchException e)
			{
				System.out.println("saisie incorrecte...essaie encore");
				sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
				bool= true;
			}
		}while(bool);
		// saisie du cout de participation
		do {
			bool= false;
			try{
				System.out.println("cout de participation: ");
				participationCost= sc.nextInt();
				sc.nextLine();					 			// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
			}catch(InputMismatchException e)
			{
				System.out.println("saisie incorrecte...essaie encore");
				sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
				bool= true;
			} 
		}while(bool);
		// saisie du poster du tournoi
		do {
			bool= false;
			try{
				System.out.println("poster du tournoi:");
				tournamentPoster= sc.nextLine();
				//tournamentPoster= sc.nextLine();
			}catch(InputMismatchException e)
			{
				System.out.println("saisie incorrecte...essaie encore");
				sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
				bool= true;
			}
		}while(bool);
		System.out.println("tu vas maintenant former les equipes en selectionnant parmis les occupants du bar... allez on y va");

		for(int k =0; k < 4;k++)
		{
			do {
				bool= false;
				try{

					System.out.println("nom de l'equipe: "+k+1);
					teamName= sc.nextLine();
				}catch(InputMismatchException e)
				{
					System.out.println("saisie incorrecte...essaie encore");
					sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
					bool= true;
				}
			}while(bool);
			System.out.println("le nom de cette equipe est :"+teamName);
			System.out.println(" selectionnes les joueurs de cette equipe parmis les occupants du bar... allez on y va");

			for(int i=0;i < 2;i++)
			{
				do{
					bool= false;
					try{
						bar.displayOccupantsList();
						System.out.println("fais ton choix");
						selection= sc.nextInt();

					}catch(InputMismatchException e)
					{
						System.out.println("saisie incorrecte...essaie encore");
						sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
						bool= true;
					}
				}while(bool);
				do{     											// A la sortie de ce do while j'ai forcement compose une equipe potable

					if(bool == true)
					{
						try{
							System.out.println(" selectionnes-en une/un autre");
							selection =sc.nextInt();  // on recupere le permier caractere
							player= bar.getOccupants().get(selection);
							System.out.println(player.getClass().getName());
							if(player.getClass().getName() == "bar.Barman" || player.getClass().getName() == "bar.Patronne" )
								throw  new AllowedPlayerException();
							if(playerList.contains(player))
								throw new AlreadyChoosedException();
							playerList.add(player);
							usefulList.add(player);
							for(int j=0; j < playerList.size(); j++) // on check s'il y a toujours un serveur/serveuse de disponible
							{
								if((playerList.get(j).getClass().getName() == "bar.ServeurHomme") || (playerList.get(j).getClass().getName() == "bar.ServeurFemme"))
									counter++;
							}
							if(counter == 7)
								throw new NotEnoughServeurException();  // ou alors je throw une nouvelle exception mais flemme
							bool= false;
						}catch(InputMismatchException e)
						{
							System.out.println("saisie incorrecte...essaie encore");
							sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
							bool =true;
						}catch(IndexOutOfBoundsException e)
						{
							System.out.println("ce client a quitte le bar selectionnes-en une/un autre");
							sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
							bool =true;
						}catch(Exception e){
							System.out.println(e.getMessage());
							sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
							bool =true;
						}


					}
					else	// ne s'execute qu'une seule fois si tout est bon on sort du while sinn 
					{
						try{
							player= bar.getOccupants().get(selection);
							System.out.println(player.getClass().getName());
							if(player.getClass().getName() == "bar.Barman" || player.getClass().getName() == "bar.Patronne" )
								throw  new AllowedPlayerException();
							if(playerList.contains(player))
								throw new AlreadyChoosedException();
							playerList.add(player);
							usefulList.add(player);
							for(int j=0; j < playerList.size(); j++) // on check s'il y a toujours un serveur/serveuse de disponible
							{
								if((playerList.get(j).getClass().getName() == "bar.ServeurHomme") || (playerList.get(j).getClass().getName() == "bar.ServeurFemme"))
									counter++;
							}
							if(counter == 7)
								throw new NotEnoughServeurException();  // ou alors je throw une nouvelle exception mais flemme 

						}catch(Exception e){
							System.out.println(e.getMessage());
							sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
							bool =true;
						} 
					}
				}
				while(bool);
				System.out.println("equipe complete");
			}// fin de la boucle for  on a une equipe complete 
			team.setTeamName(teamName); 	// on met a jour le nom de l'equipe
			System.out.println(usefulList.get(0));
			System.out.println(usefulList.get(1));
			team.setPlayerList(usefulList); // on met a jour la liste des joueurs d'une equipe;
			teamList.add(team);				// on rajoute l'equipe nouvellement constitue a la liste des equipes
			usefulList.clear(); 			// on vide la liste utile
		}// fin de la boucle for on a une liste de 4 equipes pour le tournoi
		System.out.println("liste des equipes complete");
		// on peut enfin creer un nouveau tournoi

		Tournoi tournoi = new Tournoi(name,winprice,participationCost,tournamentPoster,teamList); 



		bar.getTournamentList().add(tournoi);

		System.out.println("c'est bon ton tournoi perso a ete cree.");
	} 

	/**
	 * Gere la creation d'un bar
	 */
	public static void createBar()
	{

		String barName="";
		String barmaidName="";
		String barmaidSurname="";
		String bossName="";
		String bossSurname="";
		String cri="";
		ArrayList<Boisson> inventaire= user.automaticInventaire();
		ArrayList<Client> clientsList= user.automaticClientList();
		ArrayList<Serveur> serveurList= user.automaticServeursList();
		ArrayList<Humain> occupantsList= new ArrayList<Humain>();

		for(int i =0;i < serveurList.size();i++)
			occupantsList.add(i, serveurList.get(i));   			// par covariance des variables je peux peux stocker une variable fille dans une variable mere
		for(int i=0; i< clientsList.size();i++)
			occupantsList.add(i, clientsList.get(i));


		System.out.println("here we go pour la creation de ton bar");

		// saisie du nom du bar
		do {
			bool= false;
			try{
				System.out.println("nom du Bar: ");
				barName= sc.nextLine();
			}catch(InputMismatchException e)
			{
				System.out.println("saisie incorrecte...essaie encore");
				//sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
				bool= true;
			}
		}while(bool);
		// saisie du nom du barmaid
		do {
			bool= false;
			try{
				System.out.println("nom du Barman: ");
				barmaidName= sc.nextLine();
			}catch(InputMismatchException e)
			{
				System.out.println("saisie incorrecte...essaie encore");
				//sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
				bool= true;
			}
		}while(bool);
		// saisie du surnom du barmaid
		do {
			bool= false;
			try{
				System.out.println("surnom du Barman: ");
				barmaidSurname= sc.nextLine();
			}catch(InputMismatchException e)
			{
				System.out.println("saisie incorrecte...essaie encore");
				//sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
				bool= true;
			}
		}while(bool);
		// saisie du nom de patronne
		do {
			bool= false;
			try{
				System.out.println("nom de la patronne: ");
				bossName= sc.nextLine();
			}catch(InputMismatchException e)
			{
				System.out.println("saisie incorrecte...essaie encore");
				//sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
				bool= true;
			}
		}while(bool);
		// saisie du nom de patronne
		do {
			bool= false;
			try{
				System.out.println("surnom de la patronne: ");
				bossSurname= sc.nextLine();
			}catch(InputMismatchException e)
			{
				System.out.println("saisie incorrecte...essaie encore");
				//sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
				bool= true;
			}
		}while(bool);
		// saisie du cri de rage de la patronne
		do {
			bool= false;
			try{
				System.out.println("cri de la patronne: ");
				cri= sc.nextLine();
			}catch(InputMismatchException e)
			{
				System.out.println("saisie incorrecte...essaie encore");
				//sc.nextLine(); 								// on replace la tete de lecture au debut de la ligne suivante afin d'eviter qu'elle ne soit avalee
				bool= true;
			}
		}while(bool);


		Barman barmaid = user.createBarman(barmaidName,barmaidSurname);
		Patronne patronne= user.createPatronne(bossName,bossSurname,cri);
		occupantsList.add(patronne);
		occupantsList.add(barmaid);

		Bar myBar= new Bar(barName,patronne,barmaid,inventaire,serveurList,occupantsList,clientsList);
		user.getBarList().add(myBar);
		System.out.println("c'est bon, ton BAR perso a ete cree.");
	}

}

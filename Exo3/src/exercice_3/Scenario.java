package exercice_3;

import java.util.List;
import java.util.Date;
import java.util.Iterator;
import java.util.ArrayList;


//met le fichier config dans ton fichier src sinon ca foire.

//Bon, j'ai fait les classes et le config est bonne a priori(enfin change juste les trucs pas générique). J'ai ausi refait les db en ajoutant les trucs facultatifs
//par contre ici je galère j'ai pris l'exemple si dessous mais je débug la fonction depuis 3h(la il me demande une librairies appahe...) donc je pense que t'a
//interet a laisser tomber celle ci pour en trouver une qui marche. J'ai pas trop touché au fichier .xml il se peut que tu doive y toucher
//pour que ca concorde bien avec la db.

//C'est maintenant que ca devient drole
//http://www.tutorialspoint.com/hibernate/hibernate_examples.html
//J'ai utilisé ca pour cette partie

//Si tu veux test, tu dois foutre toutes les jar de ca http://sourceforge.net/projects/hibernate/files/hibernate4/4.1.7.Final/ en library
//! Ca marche pas.
import java.util.*;

public class Scenario {

	public static void main(String[] args) {
		TableManager tableManager = new TableManager();
		ClientManager clientManager = new ClientManager();
		DrinkManager drinkManager = new DrinkManager();

		Client client = tableManager.sitAtTable(3);

		if (client != null){
			// get the water drink
			Drink d = drinkManager.getDrinkById(2);

			// order a water
			System.out.println("Order one water");
			HashMap<Drink,Integer> orderDrinks =  new HashMap<Drink,Integer>();
			orderDrinks.put(d,1);
			clientManager.orderDrinks(client,orderDrinks);

			// get ticker
			System.out.println("Here is the ticket :");
			System.out.println("|------------------------------|");
			clientManager.issueTicket(client);
			System.out.println("|------------------------------|");

			// order a second water
			System.out.println("Order one water");
			orderDrinks =  new HashMap<Drink,Integer>();
			orderDrinks.put(d,1);
			clientManager.orderDrinks(client,orderDrinks);

			// pay 20$ and leave
			System.out.println("leave the table and pay 20$");
			clientManager.payTable(client, 20.0);
		}
	}


}

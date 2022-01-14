package App;

import java.util.Scanner;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.*;

public class CRUD {

	// Escaner
	static Scanner sc = new Scanner(System.in);
	
	// Main
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Biblioteca");
		MongoCollection<Document> coleccion = database.getCollection("Llibres");
		
		// CRUD
		int opc;
		do {
			// Menu
			System.out.println("--- MENU ---");
			System.out.println("1.- Mostrar tots els IDs i els Titols de la biblioteca");
			System.out.println("2.- Mostrar l'informació detallada d'un llibre a partir del seu ID");
			System.out.println("3.- Afegir un nou llibre a la biblioteca");
			System.out.println("4.- Modificar atributs d'un llibre a poartir del seu ID");
			System.out.println("5.- Esborrar un llibre a partir del seu ID");
			System.out.println();
			opc = Integer.parseInt(sc.nextLine());
			
			String id = "";
			
			switch (opc) {
			case 1:
				mostrarIdTitol(coleccion);
				break;
			case 2:
				System.out.println("Dime el ID del llibre a mostrar:");
				id = sc.nextLine();
				
				mostrarLlibre(coleccion, id);
				break;
			case 3:
				afegirLlibre(coleccion);
				break;
			case 4:
				System.out.println("Dime el ID del llibre a modificar:");
				id = id = sc.nextLine();
				
				System.out.println(id);
				
				modificarLlibre(coleccion, id);
				break;
			case 5:
				System.out.println("Dime el ID del llibre a esborrar:");
				id = id = sc.nextLine();
				
				esborrarLlibre(coleccion, id);
				break;
			default:
				break;
			}
		}while(opc != 6);
		
		// Fi de la connexió
		mongoClient.close();
	}
	
	// Metodos
	/** Read
	 * mostrarIdTitol(MongoCollection<Document>)
	 * 
	 * Parametres entrada: coleccion amb dades de la base agafades de la BBDD
	 * Parametres d'ixida: null
	 * 
	 * Mostra per la terminal tots els titols i el seu ID.
	*/
	public static void mostrarIdTitol(MongoCollection<Document> coleccion) {
		MongoCursor<Document> cursor = coleccion.find().iterator();
		while (cursor.hasNext()) {
			JSONObject obj = new JSONObject(cursor.next().toJson());
			System.out.println("ID: " + obj.getString("Id") + "	 Titol: " + obj.getString("Titol"));
		}
	}
	
	/** Read
	 * mostrarLlibre(MongoCollection<Document>, String)
	 * 
	 * Parametres d'entrada: coleccion amb dades de la base agafades de la BBDD, id del llibre a mostrar
	 * Parametres d'ixida: null
	 * 
	 * Mostra per la terminal tots els camps d'un llibre a partir del seu ID
	 */
	public static void mostrarLlibre(MongoCollection<Document> coleccion, String id) {
			Bson query = eq("Id", id);
			MongoCursor<Document> cursor = coleccion.find(query).iterator();;
			JSONObject obj = new JSONObject(cursor.next().toJson());
			System.out.println("ID: " + obj.getString("Id"));
			System.out.println("Titol: " + obj.getString("Titol"));
			System.out.println("Autor: " + obj.getString("Autor"));
			System.out.println("Any de naixement: " + obj.getString("Any_naixement"));
			System.out.println("Any de publicacio: " + obj.getString("Any_publicacio"));
			System.out.println("Editorial: " + obj.getString("Editorial"));
			System.out.println("Nombre de pagines: " + obj.getString("Nombre_pagines"));
			System.out.println();
	}
	
	/** Create
	 * afegirLlibre(MongoCollection<Document>)
	 * 
	 * Parametres d'entrada: coleccion amb dades de la base agafades de la BBDD
	 * Parametres d'ixida: null
	 * 
	 * Afegix a la BBDD un nou llibre
	 */
	public static void afegirLlibre(MongoCollection<Document> coleccion) {
		System.out.println("Titol del llibre:");
		String titol = sc.nextLine();
		System.out.println("Autor del lllibre:");
		String autor = sc.nextLine();
		System.out.println("Any de naiximent:");
		String anyNaiximent = sc.nextLine();
		System.out.println("Any de publicació:");
		String anyPublicacio = sc.nextLine();
		System.out.println("Editorial:");
		String editorial = sc.nextLine();
		System.out.println("Nombre de pagines:");
		String numPagines = sc.nextLine();
		
		Document doc = new Document();
		doc.append("Id", "15");
		doc.append("Titol", titol);
		doc.append("Autor", autor);
		doc.append("Any_naixement", anyNaiximent);
		doc.append("Any_publicacio", anyPublicacio);
		doc.append("Editorial", editorial);
		doc.append("Nombre_pagines", numPagines);
		
		coleccion.insertOne(doc);
	}
	
	/** Update
	 * modificarLlibre(MongoCollection<Document>, String)
	 * 
	 * Parametres d'entrada: coleccion amb dades de la base agafades de la BBDD, id del llibre a modirficar
	 * Parametres d'ixida: null
	 * 
	 * Modifica un llibre a partir del seu ID
	 */
	public static void modificarLlibre(MongoCollection<Document> coleccion, String id) {
		System.out.println("Quin camp vols modificar?");
		System.out.println("1.- Titol");
		System.out.println("2.- Autor");
		System.out.println("3.- Any de naiximent");
		System.out.println("4.- Any de publicació");
		System.out.println("5.- Editorial");
		System.out.println("6.- Nombre de pagines");
		System.out.println("7.- Ixir");
		int opc = Integer.parseInt(sc.nextLine());
		
		switch (opc) {
		case 1:
			System.out.println("Nou titol:");
			String titol = sc.nextLine();
			
			coleccion.updateOne(eq("Id", id), new Document("$set",
					new Document("Titol", titol)));
			break;
		case 2:
			System.out.println("Nou autor:");
			String autor = sc.nextLine();
			
			coleccion.updateOne(eq("Id", id), new Document("$set",
					new Document("Autor", autor)));
			break;
		case 3:
			System.out.println("Nou any de naiximent:");
			String anyNaiximent = sc.nextLine();
			
			coleccion.updateOne(eq("Id", id), new Document("$set",
					new Document("Any_naixement", anyNaiximent)));
			break;
		case 4:
			System.out.println("Nou any de opublicació:");
			String anyPubli = sc.nextLine();
			
			coleccion.updateOne(eq("Id", id), new Document("$set",
					new Document("Any_publicacio", anyPubli)));
			break;
		case 5:
			System.out.println("Nova editorial:");
			String editorial = sc.nextLine();
			
			coleccion.updateOne(eq("Id", id), new Document("$set",
					new Document("Editorial", editorial)));
			break;
		case 6:
			System.out.println("Nou nombre de pagines");
			String numPag = sc.nextLine();
			
			coleccion.updateOne(eq("Id", id), new Document("$set",
					new Document("Nombre_pagines", numPag)));
			break;
		default:
			break;
		}
	}
	
	/** Destroy
	 * esborrarLlibre(MongoCollection<Document>, String)
	 * 
	 * Parametres d'entrada: coleccion amb dades de la base agafades de la BBDD, id del llibre a esborrar
	 * Parametres d'ixida: null
	 * 
	 * Esborra un llibre a partir del seu ID
	 */
	public static void esborrarLlibre(MongoCollection<Document> coleccion, String id) {
		coleccion.deleteOne(eq("Id", id));		
	}
	

}

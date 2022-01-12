package app;

import java.util.Scanner;

import org.bson.Document;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.*;

public class CRUD {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("Proba");
		MongoCollection<Document> coleccion = database.getCollection("Users");
		
		// CRUD
		System.out.println("--- MENU ---");
		System.out.println("1.- Crear");
		System.out.println("2.- Leer");
		System.out.println("3.- Actualizar");
		System.out.println("4.- Eliminar");
		int opc = Integer.parseInt(sc.nextLine());
	
		switch (opc) {
		case 1:
			// Create
			create(coleccion);
			break;
		case 2:
			// Read
			read(coleccion);
			break;
		case 3:
			// Update
			update(coleccion);
			break;
		case 4:
			// Destroy
			destroy(coleccion);
			break;
		default:
			break;
		}
		
		mongoClient.close();
	}

	public static void create(MongoCollection<Document> coleccion){
		Document doc = new Document();
		doc.append("_nom", "Jorge");
		doc.append("_telefono", "333333333");
		doc.append("_Casa", "La Pobla Llarga");
		coleccion.insertOne(doc);
		
		//coleccion.insertMany(listaDocs);
	}
	
	public static void read(MongoCollection<Document> coleccion) {
		MongoCursor<Document> cursor = coleccion.find().iterator();
		while (cursor.hasNext()) {
			JSONObject obj = new JSONObject(cursor.next().toJson());
			System.out.println(obj.getString("_nom"));
		}
	}
	
	public static void update(MongoCollection<Document> coleccion) {
		System.out.println("Que campo quieres actualizar?");
		String campo = sc.nextLine();
		System.out.println("Que valor tiene actualmente?");
		String valor1 = sc.nextLine();
		System.out.println("Que valor tendra?");
		String valor2 = sc.nextLine();
		
		coleccion.updateOne(eq(campo, valor1), new Document("$set",
				new Document(campo, valor2)));
//				coleccion.updateMany(eq("formato", "WAV"), new Document("$set",
//				new Document("formato", "OGG")));
	}
	
	public static void destroy(MongoCollection<Document> coleccion) {
		System.out.println("Que campo quieres eliminar?");
		String campo = sc.nextLine();
		System.out.println("Que valor tiene?");
		String valor = sc.nextLine();
		
		coleccion.deleteOne(eq(campo, valor));
		//coleccion.deleteMany(eq("formato", "OGG"));
		coleccion.drop();

	}
}

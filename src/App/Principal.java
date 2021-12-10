package App;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.service.ServiceRegistry;

public class Principal implements Serializable{

	static Scanner sc = new Scanner(System.in);
	
	// main(String[]) 
	// contiene Menu
	public static void main(String[] args) {
		// Menu
		System.out.println("+---Menu---+");
		System.out.println("1.- Mostra tots els títols de la biblioteca.");
		System.out.println("2.- Mostra la informació detallada d'un llibre a partir del seu id.");
		System.out.println("3.- Afegir un nou llibre a la biblioteca.");
		System.out.println("4.- Modificar atributs d'un llibre a la biblioteca.");
		System.out.println("5.- Esborrar un llibre a partir del seu id.");
		int opc = Integer.parseInt(sc.nextLine());

		ArrayList<Llibre> llistaLlibres = guardarLlibres();
		
		switch (opc) {
		case 1:
			mostrarTitol(llistaLlibres);
			break;

		case 2:
			System.out.println("Dime el ID del llibre que vols vore: ");
			int id = Integer.parseInt(sc.nextLine());
			mostrarContingutLlibre(llistaLlibres.get(id));
			break;
		case 3:
			String[] datos = new String[6];
			System.out.println("+---Creant un Llibre nou---+");
			System.out.println("Dime el titol:");
			datos[0] = sc.nextLine();
			System.out.println("Dime el autor:");
			datos[1] = sc.nextLine();
			System.out.println("Dime el any de naiximent:");
			datos[2] = sc.nextLine();
			System.out.println("Dime el any de publicacio:");
			datos[3] = sc.nextLine();
			System.out.println("Dime la editorial:");
			datos[4] = sc.nextLine();
			System.out.println("Dime el nombre de pagines:");
			datos[5] = sc.nextLine();
			
			pujarLlibre(datos);
			break;
		case 4:
			actLlibre();
			break;
		case 5:
			borrarLlibre();
		default:
			break;
		}
	}

	// guardarLlibres()
	// Parametros entrada: res
	// Parametros eixida: ArayList d'objecte Llibre que conte cada llibre de la BBDD
	public static ArrayList<Llibre> guardarLlibres(){
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Llibre.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		// Recuperar llista d’objectes
		ArrayList<Llibre> llistaLlibres = new ArrayList();
		llistaLlibres = (ArrayList) session.createQuery("From Llibre").list();
		
		session.getTransaction().commit();
		session.close();
		
		return llistaLlibres;
	}
	
	// mostrarTitol(ArrayList<Llibre>)
	// Parametres entrada: ArrayList d'objecte Llibre que conte tots els llibres de la BBDD
	// Parametres eixida: res
	// Mostra per pantalla el titol de tots els llibres de la BBDD
	public static void mostrarTitol(ArrayList<Llibre> llistaTitols) {
		for (int i = 0; i < llistaTitols.size(); i++) {
			System.out.println((llistaTitols.get(i)).getTitol());
		}
	}
	
	// mostrarContingut(Llibre)
	// Parametres entrada: Un objecte Llibre
	// Parametres eixida: res
	// Mostra tots els atributs del llibre
	public static void mostrarContingutLlibre(Llibre llibre) {
		System.out.println(llibre.toString());
	}

	// pujarLlibre(String[])
	// Parametres entrada: Array de Strings amb les dades necessaries per a crear un llibre nou
	// Parametres eixida: res
	// Crea un Objecte(LLibre) nou i el el puja a la BBDD
	public static void pujarLlibre(String[] datos) {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Llibre.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Llibre llib = new Llibre(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5]);
		Serializable id = session.save(llib);
		
		session.getTransaction().commit();
		session.close();
	}
	
	// actLlibre()
	// Parametres entrada: res
	// Parametres eixida: res
	// Actualitza les dades d'un Objecte llibre i les puja a la BBDD a partir del seu ID
	public static void actLlibre() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Llibre.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		System.out.println("Dime l'ID del camp a actualitzar?");
		int ID = Integer.parseInt(sc.nextLine());
		Llibre llibre = (Llibre) session.load(Llibre.class, ID);
		
		int opc = 0;
		// Menu
		do {
		System.out.println("1.- Titol");
		System.out.println("2.- Autor");
		System.out.println("3.- Any de naiximent");
		System.out.println("4.- Any de publicació");
		System.out.println("5.- Editorial");
		System.out.println("6.- Nombre de pagines");
		System.out.println("7.- Ixir");
		opc = Integer.parseInt(sc.nextLine());
		
		switch (opc) {
		case 1:
			System.out.println("Dime Titol:");
			String titol = sc.nextLine();
			llibre.setTitol(titol);
			break;
		case 2:
			System.out.println("Dime Autor: ");
			String autor = sc.nextLine();
			llibre.setAutor(autor);
			break;
		case 3:
			System.out.println("Dime el any de naiximent: ");
			String anyNaiximent = sc.nextLine();
			llibre.setAnyNaiximent(anyNaiximent);
			break;
		case 4:
			System.out.println("Dime el any de publicació:");
			String anyPubli = sc.nextLine();
			llibre.setAnyPublicacio(anyPubli);
			break;
		case 5:
			System.out.println("Dime la editorial:");
			String editorial = sc.nextLine();
			llibre.setEditorial(editorial);
			break;
		case 6:
			System.out.println("Dime el nombre de pagines:");
			String nPag = sc.nextLine();
			llibre.setNombrePagines(nPag);
			break;
		default:
			break;
		}
		}while(opc != 7);
		
		// Actualitzar llibre
		session.update(llibre);

		session.getTransaction().commit();
		session.close();
	}
	
	// borrarLlibre()
	// Parametres entrada: res
	// Parametres eixida: res
	// Borra un llibre a partir del seu ID
	public static void borrarLlibre() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Llibre.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		System.out.println("Dime l'ID del camp a borrar:");
		int ID = Integer.parseInt(sc.nextLine());
		
		//Borrar
		Llibre llibre = new Llibre();
		llibre.setId(ID);
		session.delete(llibre);
		
		session.getTransaction().commit();
		session.clear();
		session.close();
	}
}

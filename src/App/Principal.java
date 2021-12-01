package App;

import java.util.ArrayList;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("+---Menu---+");
		System.out.println("1.- Mostra tots els títols de la biblioteca.");
		System.out.println("2.- Mostra la informació detallada d'un llibre a partir del seu id.");
		System.out.println("3.- Afegir un nou llibre a la biblioteca.");
		System.out.println("4.- Modificar atributs d'un llibre a la biblioteca.");
		System.out.println("5.- Esborrar un llibre a partir del seu id.");
		int opc = Integer.parseInt(sc.nextLine());

		switch (opc) {
		case 1:
			mostrarLlibres();
			break;

		default:
			break;
		}
	}

	public static void mostrarLlibres() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Llibre.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		// Recuperar llista d’objectes
		ArrayList listaAnimales = new ArrayList();
		listaAnimales = (ArrayList) session.createQuery("From Llibre").list();
		
		for (int i = 0; i < listaAnimales.size(); i++) {
			System.out.println(listaAnimales.get(i).toString());
		}
	}

}

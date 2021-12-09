package hibernate;

import java.io.Serializable;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.List;
import org.hibernate.service.ServiceRegistry;

public class HibernateConfig {

	public static void main(String[] args) {
		// Carrega la configuracio i crea un session factory
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		configuration.addClass(Animal.class);
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		
		// Obri una nova sessi� de la session factory
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		// Ac� les operacio/ns CRUD (crear, llegir, actualitzar, borrar)
		//Recuperar un objecte a partir del seu id
		Animal recuperarAnimal = (Animal) session.get(Animal.class, 1);
		
		// Crear nou objecte
		Animal nouAnimal = new Animal("Ales", "Perro", "Azul", 15);
		Serializable id = session.save(nouAnimal);
		
		// Actualitza la informaci�n d�un objecte donat el seu id
		Animal actAnimal = (Animal) session.load(Animal.class, 2);
		actAnimal.setNombre("Jordi");
		actAnimal.setColor("Ocre");
		session.update(actAnimal);

		//Borrar un objecte donat el seu id
		Animal borrarAnimal = new Animal();
		borrarAnimal.setId(11);
		session.delete(borrarAnimal);
		
		//Recuperar llista d�objectes
		ArrayList listaAnimales = new ArrayList();
		listaAnimales = (ArrayList) session.createQuery("From Animal").list();
		
//		for (int i = 0; i < listaAnimales.size(); i++) {
//			System.out.println(listaAnimales.get(i));
//		}
		
		// Commit de la transacci� i tanca de sessi�
		session.getTransaction().commit();
		session.close();

	}

}

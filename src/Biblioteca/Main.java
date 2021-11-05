package Biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	// llegirCSV(String)
	// Parametres d'entrada: un String amb la ruta del fitxer CSV
	// Parametres d'ixida: un arrayList de objecte Llibre
	// el metodo llegira l'arxiu CSV i plenara un arrayList de Llibres amb el contingut del fitxer
	public static ArrayList<Llibre> llegirCSV(String ruta) {
		String resu = "Exit en llegir el csv";
		System.out.println("hola");
		ArrayList<Llibre> llibres = new ArrayList();

		try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
			String linea;
			int cont = 0;
			while ((linea = br.readLine()) != null) {
				if (cont >= 1) {
					String[] atributsLlibre = linea.split(";");
					Llibre ll = new Llibre();

					for (int i = 0; i < atributsLlibre.length; i++) {
						if (atributsLlibre[i].equals("")) {
							atributsLlibre[i] = "N.C";
						}
					}

					ll.setTitol(atributsLlibre[0]);
					ll.setAutor(atributsLlibre[1]);
					ll.setAnyNaiximent(atributsLlibre[2]);
					ll.setAnyPublicacio(atributsLlibre[3]);
					ll.setEditorial(atributsLlibre[4]);
					ll.setNombrePagines(atributsLlibre[5]);

					llibres.add(ll);
				}
				cont++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return llibres;
	}

	// Main
	// Pujarem les dades del arrayList que ens retorna "llegirCSV(String)" a la BBDD
	// tots els atributs que es munten a la BBDD son Strings per a prevenir possibles conflictes en pujar dades
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Llibre> llibres = llegirCSV(".\\src\\Biblioteca\\Fitxers\\AE04_T1_4_JDBC_Dades.csv");
		int cont = 0;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "");

			Statement s = conexion.createStatement();

			for (int i = 0; i < llibres.size(); i++) {

				String titol = llibres.get(i).getTitol();
				String autor = llibres.get(i).getAutor();
				String anyNaiximent = llibres.get(i).getAnyNaiximent();
				String anyPublicacio = llibres.get(i).getAnyPublicacio();
				String editorial = llibres.get(i).getEditorial();
				String nombrePagines = llibres.get(i).getNombrePagines();

				PreparedStatement ps = conexion.prepareStatement(
						"INSERT INTO `llibre` (`titol`, `autor`, `anyNaiximent`, `anyPublicacio`, `editorial`, `nombrePagines`) VALUES ('"
								+ titol + "','" + autor + "','" + anyNaiximent + "','" + anyPublicacio + "','"
								+ editorial + "','" + nombrePagines + "')");
				ps.executeUpdate();

				// Comprova inserció
				ResultSet rs = s.executeQuery("SELECT * FROM `llibre`");

				while (rs.next()) {
					cont++;
				}

				rs.close();
				ps.close();
			}

			// Consultes Necessaries
			ResultSet rs = s.executeQuery(
					("SELECT `titol`, `autor`, `anyPublicacio` FROM `llibre` WHERE `anyNaiximent` < 1950"));
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}

			rs = s.executeQuery(("SELECT `editorial` FROM `llibre` WHERE `anyPublicacio` >= 2001"));
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}

			// Consulta del usuari
			System.out.println("Vols fer una consulta a la BBDD?? (contesta SI, NO)");
			String ferConsulta = sc.nextLine();

			ferConsulta = ferConsulta.toLowerCase();
			if (ferConsulta.equals("si")) {
				System.out.print("Escriu la consulta: ");
				String consulta = sc.nextLine();

				rs = s.executeQuery("SELECT * FROM `llibre` WHERE id");
				ResultSetMetaData rsmd = rs.getMetaData();
				while (rs.next()) {
					System.out.print(rs.getString(1));
					for (int i = 1; i < rsmd.getColumnCount(); i++) {
						System.out.print(rs.getString(i) + " ");
					}
					System.out.println();
				}
			}

			// Tanquem: resulset, Statement y la conexio a la BBDD
			rs.close();
			s.close();
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (cont != 0) {
			System.out.println("Exit en la conexió");
		} else {
			System.err.println("Error en la conexió!!!");
		}

	}

}

package Seccio4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class act30 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cont = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/selva", "root", "");

			Statement s = conexion.createStatement();

			ResultSet rs = s.executeQuery("SELECT * FROM `animal`");
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
						+ rs.getString(4) + " " + rs.getString(5));
				cont++;
			}

			if (cont != 0) {
				System.out.println("\nExit en la conexió");
			} else {
				System.err.println("\nError en la conexió!!!");
			}

			System.out.println("\nQue ID quieres actualizar? ");
			int id = Integer.parseInt(sc.nextLine());

			int opc = 0;
			String nombre = "";
			String tipo = "";
			String color = "";
			int edad = 0;

			do {
				System.out.println("\n--------Menu--------");
				System.out.println("1.- Actualizar nombre: ");
				System.out.println("2.- Actualizar tipo: ");
				System.out.println("3.- Actualizar color: ");
				System.out.println("4.- Actualizar edad: ");
				System.out.println("5.- Salir del menu");
				opc = Integer.parseInt(sc.nextLine());

				switch (opc) {
				case 1:
					System.out.println("Dime el nuevo nombre: ");
					nombre = sc.nextLine();
					break;

				case 2:
					System.out.println("Dime el nuevo tipo: ");
					tipo = sc.nextLine();
					break;
				case 3:
					System.out.println("Dime el nuevo color: ");
					color = sc.nextLine();
					break;
				case 4:
					System.out.println("Dime la nova edad: ");
					edad = Integer.parseInt(sc.nextLine());
					break;
				case 5:
					break;
				}
			} while (opc != 5);

			PreparedStatement psActualizar = conexion.prepareStatement("UPDATE animal SET nombre = '" + nombre
					+ "', tipo = '" + tipo + "', color = '" + color + "', edad = '" + edad + "' WHERE id = " + id);
			int resultadoActualizar = psActualizar.executeUpdate();

			// Close
			rs.close();
			s.close();
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

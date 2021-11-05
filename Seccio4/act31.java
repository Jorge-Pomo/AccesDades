package Seccio4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class act31 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cont = 0;

		try {
			// Conectarse 
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

			// Entrada ID
			System.out.println("\nQue ID quieres actualizar? ");
			int id = Integer.parseInt(sc.nextLine());

			// Esborar ID
			PreparedStatement psBorrar = conexion.prepareStatement("DELETE FROM animal WHERE id = " + id);
			int resultadoBorrar = psBorrar.executeUpdate();

			if(resultadoBorrar == 1) {
				System.out.println("S'ha esborrat correctament");
			}else {
				System.err.println("Error!! No s'ha pogut esborrar l'entrada amb l'ID " + id);
			}
			
			// Close
			rs.close();
			s.close();
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

package Seccio4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class act28 {

	public static void main(String[] args) {
		int cont = 0;
		Scanner sc = new Scanner(System.in);

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

			System.out.println();

			if (cont != 0) {
				System.out.println("Exit en la conexió");
			} else {
				System.err.println("Error en la conexió!!!");
			}

			rs.close();
			s.close();
			conexion.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

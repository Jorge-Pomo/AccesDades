package Seccio4;

import java.sql.Connection;
import java.sql.DriverManager;
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
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
				cont++;
			}

			System.out.println();
			
			if(cont != 0) {
				System.out.println("Exit en la conexió");
			}else {
				System.err.println("Error en la conexió!!!");
			}
			
			rs.close();
			
			int id = cont + 1;
			System.out.println("Dime el nombre del animal: ");
			String nombre = sc.nextLine();
			System.out.println("Dime el tipo de animal: ");
			String tipo = sc.nextLine();
			System.out.println("Dime el color del animal: ");
			String color = sc.nextLine();
			System.out.println("Dime la edad del animal: ");
			int edad = Integer.parseInt(sc.nextLine());
			
			ResultSet rsInsertar = s.executeQuery("INSERT INTO `animal` (`" +  + "`, `nombre`, `tipo`, `color`, `edad`) VALUES (NULL, 'asdf', 'asdff', 'asdfff', '23');`");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

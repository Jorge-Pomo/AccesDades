package Seccio4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class act27 {

	public static void main(String[] args) {
		int cont = 0;
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/selva", "root", "");

			Statement s = conexion.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM `animal`");

			
			
			while (rs.next()) {
				System.out.println(rs.getString(2));
				cont++;
			}

			System.out.println();
			
			if(cont != 0) {
				System.out.println("Exit en la conexió");
			}else {
				System.err.println("Error en la conexió!!!");
			}
			
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

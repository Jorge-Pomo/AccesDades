package Seccio4;

import java.util.ArrayList;
import java.sql.*;

public class act26 {

	public static void main(String[] args) {
		int cont = 0;
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/selva", "root", "");

			Statement s = conexion.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM `animal`");

			
			
			while (rs.next()) {
//				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
				cont++;
			}

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

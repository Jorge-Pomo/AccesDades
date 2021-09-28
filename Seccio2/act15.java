package Seccio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class act15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		String fitxerDesti = args[0] + System.getProperty("file.separator") + "Act15.txt";

		try {			
			BufferedWriter bw = new BufferedWriter(new FileWriter(fitxerDesti));
			
			String linea = "";
			while (linea.equals("exit") == false) {
				System.out.println("Linea a introducir en fichero: ");
				linea = sc.nextLine();
				
				if(linea.equals("exit") == false) {
					System.out.println(linea);
					bw.write(linea + "\n");
				}
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

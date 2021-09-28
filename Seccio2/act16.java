package Seccio2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class act16 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
		
		String fitxerDesti = args[0] + System.getProperty("file.separator") + "Act16-" + dtf.format(LocalDateTime.now()) + ".txt";

		try {			
			BufferedWriter bw = new BufferedWriter(new FileWriter(fitxerDesti));
			
			String linea = "";
			while (linea.equals("exit") == false) {
				System.out.println("Linea a introducir en fichero: ");
				linea = sc.nextLine();
				
				if(linea.equals("exit") == false) {
					bw.write(linea + "\n");
				}
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

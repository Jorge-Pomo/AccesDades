package Seccio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class act14 {

	public static void main(String[] args) {
		String fitxer = args[0] + System.getProperty("file.separator") + "Text.txt";
		String fCopia = args[0] + System.getProperty("file.separator") + "Copia.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(fitxer))) {
			String linea;
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(fCopia));
			
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
				bw.write(linea + "\n");
			}
			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

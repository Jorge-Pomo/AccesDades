package Seccio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class act9 {

	public static void main(String[] args) {
		//Declarem la ruta del fitxer
		String rutaF = args[0];

		FileReader fr = null;

		try {
			//Li diguem al FileReader on es troba l'arxiu
			fr = new FileReader(rutaF);

			//Guardem el nombre de caracters que ha llegit
			int caracter = fr.read();

			//Mentre que caracter no siga -1 que escriga els caracters.
			while (caracter != -1) {
				System.out.print((char) caracter);
				caracter = fr.read();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

package Seccio2;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class act11 {

	public static void main(String[] args) {

		// Declarem la ruta del fitxer
		String rutaF = args[0];
		int cont = 0;

		FileReader fr = null;

		try {
			// Li diguem al FileReader on es troba l'arxiu
			fr = new FileReader(rutaF);

			// Guardem el nombre de caracters que ha llegit
			int caracter = fr.read();

			Scanner sc = new Scanner(System.in);

			// Mentre que caracter no siga -1 que escriga els caracters.
			while (caracter != -1) {

				if (cont == 100) {
					sc.nextLine();
					System.out.print("");
					cont = 0;
				} else {
					System.out.print((char) caracter);
					caracter = fr.read();
					cont++;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

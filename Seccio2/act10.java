package Seccio2;

import java.io.FileReader;
import java.io.IOException;

public class act10 {
	public static void main(String[] args) {
		// Declarem la ruta del fitxer
		String rutaF = args[0];
		int tempsEspera = Integer.parseInt(args[1]);
		
		FileReader fr = null;
		
		try {
			// Li diguem al FileReader on es troba l'arxiu
			fr = new FileReader(rutaF);

			// Guardem el nombre de caracters que ha llegit
			int caracter = fr.read();
			
			// Mentre que caracter no siga -1 que escriga els caracters.
			while (caracter != -1) {
				System.out.print((char) caracter);
				caracter = fr.read();
				
				// Declarem el temps d'espera en milisegons
				Thread.sleep(tempsEspera);
			}

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}
}

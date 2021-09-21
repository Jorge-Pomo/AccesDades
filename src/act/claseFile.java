package act;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class claseFile {

	// Dona informació sobre un directori o una carpeta
	// Rep com a parametre d'entrada un String amb la rutaabsoluta del
	// directori/fitxer
	public static void getInformacio(String ruta) {
		File f = new File(ruta);

		System.out.println("\nEl nom es: " + f.getName());

		// Es un fitxer o una carpeta?
		if (f.isDirectory()) {
			System.out.println("Es un directori");

			// Contingut directori
			System.out.println("Contingut:");
			String[] contingut = f.list();
			for (String file : contingut) {
				System.out.println(file);
			}

			// Espall total, disponible i utilitzat
			System.out.println();
			System.out.println("Espall total = " + f.getTotalSpace());
			System.out.println("Espall buit = " + f.getFreeSpace());
			System.out.println("Espall utilitzat = " + f.getUsableSpace() + "\n");

		} else {
			System.out.println("Es un fitxer");

			// Grandaria del fixer
			System.out.println(f.length());
		}

		// Ruta absoluta
		System.out.println("La ruta absoluta es: " + f.getAbsolutePath());

		// Ultima Modificació en format de Data
		long ultimaMod = f.lastModified();

		String formatData = "yyyy-MM-dd hh:mm aa";
		SimpleDateFormat format = new SimpleDateFormat(formatData);

		Date ultimaModData = new Date(ultimaMod);

		System.out.println("Ultima modificació: " + format.format(ultimaModData));

		// Carpeta/Fitxer ocult/a
		System.out.println((f.isHidden()) ? "Es oculta" : "No es oculta");
	}

	// Crear carpeta
	// Rep com a parametre d'entrada un String amb la ruta absoluta del directori
	// i un String amb el nom de la carpeta a crear.
	public static void creaCarpeta(String ruta, String nomCarpeta) {
		File f = new File(ruta + File.separator + nomCarpeta);
		System.out.println((f.mkdir() ? "Carpeta creada" : "Error. No s'ha pogut crear la carpeta"));
	}

	// Crear Fitxer
	// Rep com a parametre d'entrada un String amb la ruta absoluta del fitxer
	// i un String amb el nom del fitxer a crear.
	public static void creaFitxer(String ruta, String nomFitxer) {
		File f = new File(ruta, nomFitxer);
		try {
			System.out
					.println((f.createNewFile() ? "El fitxer ha sigut creat" : "Error. No s'ha pogut crear el fitxer"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Eliminar Fitxer
	// Rep com a parametre d'entrada un String amb la ruta absoluta del fitxer
	// i un String amb el nom del fitxer a borrar.
	public static void elimina(String ruta, String nom) {
		File f = new File(ruta, nom);
		System.out.println((f.delete() ? "Objecte borrat" : "Error. No s'ha pogut borar l'objecte"));
	}

	// Renomena un directori o fitxer
	// Rep com a parametre d'entrada un String am la ruda absoluta del
	// directori/fitxer
	// un String amb el nom actual del fitxer/directori
	// i un Objecte File amb el nou nom del fitxer/carpeta
	public static void renomena(String ruta, String nom, File nouNom) {
		File f = new File(ruta, nom);
		System.out.println((f.renameTo(nouNom) ? "Ronomenat en exit" : "Error. No s'ha pogut renomenar l'objecte"));
	}

	// Rep per arguments la ruta absoluta del direcori pare sobre el que treballarem
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String ubicacioDirectorio = args[0];

		// Menu
		System.out.println("Menu:");
		System.out.println("1 -> getInformació \n2 -> crearCarpeta \n3 -> crearFitxer \n4 -> elimina \n5 -> renomena");
		System.out.println("Tria una opcio: ");
		String selec = sc.nextLine();

		// Switch per a accedir a cada punt del menú, cridant a cada mètode.
		switch (Integer.parseInt(selec)) {
		case 1:
			getInformacio(ubicacioDirectorio);
			break;

		case 2:
			System.out.println("Nom de la carpeta:");
			String nomD = sc.nextLine();

			creaCarpeta(ubicacioDirectorio, nomD);
			break;
		case 3:
			System.out.println("Nom del fitxer: ");
			String nomF = sc.nextLine();

			creaFitxer(ubicacioDirectorio, nomF);
			break;

		case 4:
			System.out.println("Nom de la carpeta o el fitxer: ");
			String nomDF = sc.nextLine();

			elimina(ubicacioDirectorio, nomDF);
			break;

		case 5:
			System.out.println("Nom de l'objecte: ");
			String nomO = sc.nextLine();

			System.out.println("Nou nom: ");
			String strNouNom = sc.nextLine();

			File nouNom = new File(ubicacioDirectorio, strNouNom);

			renomena(ubicacioDirectorio, nomO, nouNom);
			break;
		}
	}
}

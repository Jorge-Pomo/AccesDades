package act;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class claseFile {

	// Info
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

			System.out.println();
			System.out.println("Espall total = " + f.getTotalSpace());
			System.out.println("Espall buit = " + f.getFreeSpace());
			System.out.println("Espall utilitzat = " + f.getUsableSpace() + "\n");

			// Espall disponible

		} else {
			System.out.println("Es un fitxer");

			// Grandaria del fitxer
			System.out.println(f.length());
		}

		// Ruta absoluta
		System.out.println("La ruta absoluta es: " + f.getAbsolutePath());

		// Ultima Modificaci�
		long ultimaMod = f.lastModified();

		String formatData = "yyyy-MM-dd hh:mm aa";
		SimpleDateFormat format = new SimpleDateFormat(formatData);

		Date ultimaModData = new Date(ultimaMod);

		System.out.println("Ultima modificaci�: " + format.format(ultimaModData));

		// Carpeta/Fitxer ocult/a
		System.out.println((f.isHidden()) ? "Es oculta" : "No es oculta");
	}

	// Crear carpeta
	public static void creaCarpeta(String ruta, String nomCarpeta) {
		File f = new File(ruta + File.separator + nomCarpeta);
		System.out.println((f.mkdir() ? "Carpeta creada" : "Error. No s'ha pogut crear la carpeta"));
	}

	public static void creaFitxer(String ruta, String nomFitxer) {
		File f = new File(ruta, nomFitxer);
		try {
			System.out
					.println((f.createNewFile() ? "El fitxer ha sigut creat" : "Error. No s'ha pogut crear el fitxer"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void elimina(String ruta, String nom) {
		File f = new File(ruta, nom);
		System.out.println((f.delete() ? "Objecte borrat" : "Error. No s'ha pogut borar l'objecte"));
	}

	public static void renomena(String ruta, String nom, File nouNom) {
		File f = new File(ruta, nom);
		System.out.println((f.renameTo(nouNom) ? "Ronomenat en exit" : "Error. No s'ha pogut renomenar l'objecte"));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Menu:");
		System.out.println("1 -> getInformaci� \n2 -> crearCarpeta \n3 -> crearFitxer \n4 -> elimina \n5 -> renomena");
		System.out.println("Tria una opcio: ");
		String selec = sc.nextLine();

		switch (Integer.parseInt(selec)) {
		case 1:
			getInformacio(args[0]);
			break;

		case 2:
			System.out.println("Nom de la carpeta:");
			String nomD = sc.nextLine();

			creaCarpeta(args[0], nomD);
			break;
		case 3:
			System.out.println("Nom del fitxer: ");
			String nomF = sc.nextLine();

			creaFitxer(args[0], nomF);
			break;

		case 4:
			System.out.println("Nom de la carpeta o el fitxer: ");
			String nomDF = sc.nextLine();

			elimina(args[0], nomDF);
			break;

		case 5:
			System.out.println("Nom de l'objecte: ");
			String nomO = sc.nextLine();

			System.out.println("Nou nom: ");
			String strNouNom = sc.nextLine();

			File nouNom = new File(args[0], strNouNom);

			renomena(args[0], nomO, nouNom);
			break;
		}
	}
}

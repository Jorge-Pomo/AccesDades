package Seccio1;

import java.io.File;

public class ac5 {

	public static void main(String[] args) {

		// Variables
		String rutaDirecotri = args[0];
		String extensio = args[1];

		// Codi
		File f = new File(rutaDirecotri);

		FiltroExtension filtro = new FiltroExtension(extensio);

		String[] directorio = f.list(filtro);

		System.out.println("Contingut del ficher: ");
		for (int i = 0; i < directorio.length; i++) {
			System.out.println(directorio[i]);
		}

	}

}

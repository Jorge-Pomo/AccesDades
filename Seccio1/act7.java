package Seccio1;

import java.io.File;

public class act7 {

	public static void main(String[] args) {

		// Variables
		String rutaDirecotri = args[0];
		String[] directorio;

		// Codi
		File f = new File(rutaDirecotri);

		if (args.length < 2) {
			directorio = f.list();

			System.out.println("Contingut del ficher: ");
			for (String contingut : directorio) {
				System.out.println(contingut);
			}
		} else {
			String extensio = "";
			
			for (int i = 1; i < args.length; i++) {
				extensio = args[i];
				
				FiltroExtension filtro = new FiltroExtension(extensio);
				directorio = f.list(filtro);

				for (int j = 0; j < directorio.length; j++) {
					System.out.println(directorio[j]);
				}
			}

		}

	}

}

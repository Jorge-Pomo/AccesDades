package Seccio1;

import java.io.File;

public class act6 {

	public static void main(String[] args) {

		// Variables
		String rutaDirecotri = args[0];
		String[] directorio;
		
		// Codi
		File f = new File(rutaDirecotri);

		if(args.length < 2) {
			directorio = f.list();

			System.out.println("Contingut del ficher: ");
			for (String contingut : directorio) {
				System.out.println(contingut);
			}
		}else {
			String extensio = args[1];
			
			FiltroExtension filtro = new FiltroExtension(extensio);

			directorio = f.list(filtro);

			System.out.println("Contingut del ficher: ");
			for (int i = 0; i < directorio.length; i++) {
				System.out.println(directorio[i]);
			}
		}

	}

}

package Seccio1;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ac2i3 {

	public static void main(String[] args) {
		File f = new File(args[0]);

		System.out.println("Característiques d'interes del directori:");
		System.out.println();
		
		System.out.println("Existeix? " + (f.exists()? "SI":"NO"));
		
		System.out.println("Nom: " + f.getName());
		
		System.out.println("Ruta absoluta: " + f.getAbsolutePath());
		
		System.out.println("Te permis d'escritura? " + (f.canWrite()? "SI":"NO"));
		System.out.println("Te permis per a llegirlo? " + (f.canRead()? "SI":"NO"));
		
		Long grandaria = f.length();
		System.out.println("Grandaria: " + grandaria);
		
		System.out.println();
		String[] directorio = f.list();

		System.out.println("Contingut del ficher: ");
		for (String contingut : directorio) {
			System.out.println(contingut);
		}
		
	}

}

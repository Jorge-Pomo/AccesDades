package Seccio1;

import java.io.File;

public class ac5 {

	public static void main(String[] args) {
		File f = new File(args[0]);
		String exten = "txt";
		
		
		String[] directorio = f.list();

		System.out.println("Contingut del ficher: ");
		for (String contingut : directorio) {
			String[] parts = contingut.split(".");
			
			if(parts[1].equals("txt")) {
				System.out.println(contingut);
			}
		}
		
	}

}

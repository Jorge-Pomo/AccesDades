package Seccio1;

import java.io.File;

public class ac4 {

	public static void main(String[] args) {
		File f = new File(args[0]);

		if(f.exists()) {
			System.out.println("Si que existeix");
		}else {
			System.err.println("No existeix!!");
		}
	
	}

}

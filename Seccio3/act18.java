package Seccio3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class act18 {

	public static void main(String[] args) {
		try {			
			BufferedReader br = new BufferedReader(new FileReader(".\\src\\Seccio3\\ActivitatsSecc3\\textXML.xml"));
			
			String linea;
			
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

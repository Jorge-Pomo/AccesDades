package Seccio2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class act13 {

	public static void main(String[] args) {
		String fitxer = args[0];
		int tempsEspera = Integer.parseInt(args[1]);

		try (BufferedReader br = new BufferedReader(new FileReader(fitxer))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);

				Thread.sleep(tempsEspera);
			}
			
			br.close();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

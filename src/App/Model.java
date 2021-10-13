package App;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Model {
	private String fichero_lectura;
	private String fichero_escritura;

	public Model() {
		fichero_lectura = "." + System.getProperty("file.separator") + "src" + System.getProperty("file.separator")
				+ "App" + System.getProperty("file.separator") + "contingut" + System.getProperty("file.separator")
				+ "AE02_T1_2_Streams_Groucho.txt";
		fichero_escritura = "." + System.getProperty("file.separator") + "src" + System.getProperty("file.separator")
				+ "App" + System.getProperty("file.separator") + "contingut" + System.getProperty("file.separator")
				+ "AE02_T1_2_Streams_Groucho_nuevoFichero.txt";
	}

	// imprimirTexto()
	// Metodo que retorna el text original ubicat al pc.
	// No te parametres d'entrada
	public String imprimirTexto() {
		String text = "";

		try (BufferedReader br = new BufferedReader(new FileReader(fichero_lectura))) {
			String linea = "";

			while ((linea = br.readLine()) != null) {
				text = text + linea + "\n";
			}

			br.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error, Imprimir texto", JOptionPane.ERROR_MESSAGE);
		}
		return text;
	}

	// guardarTexto(String)
	// Metodo que guarda un String en un ficher al PC
	// Te com a parametres d'entrada un String.
	public void guardarTexto(String textGuardar) {
		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter(fichero_escritura));

			bw.write(textGuardar);

			bw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error, Guardar texto", JOptionPane.ERROR_MESSAGE);
		}
	}

}

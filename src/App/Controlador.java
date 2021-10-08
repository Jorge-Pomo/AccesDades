package App;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Controlador {

	private Model m;
	private Vista v;

	public Controlador(Model m, Vista v) {
		this.m = m;
		this.v = v;
		initEventHandlers();
	}

	public void initEventHandlers() {
		// Mostrar Text original
		v.getTextAreaOriginal().setText(m.imprimirTexto());

		v.getBtnBuscar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String paraulaBuscar = v.getTextFieldBuscar().getText();

				JOptionPane.showMessageDialog(new JFrame(), buscarContarPalabra(m.imprimirTexto(), paraulaBuscar), "Nº Caracteres encontrados", JOptionPane.INFORMATION_MESSAGE);
			}

		});

		v.getBtnReemplazar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String paraulaRemplaçar = v.getTextFieldReemplazar().getText();

				v.getTextAreaModificado().setText("" + remplaçarParaula(m.imprimirTexto(), paraulaRemplaçar));

			}

		});

	}

	private int buscarContarPalabra(String texto, String palabra) {
		int cont = 0;

		Font font = new Font("Verdana", Font.BOLD, 12);

		if (v.getTextFieldBuscar().equals(null)) {
			return cont;
		} else {
			int posicio = 0;

			posicio = texto.indexOf(palabra);

			while (posicio != -1) {

				char caracterRempla = texto.charAt(posicio);
				texto.replace(texto.charAt(posicio), caracterRempla);

				cont++;
				posicio = texto.indexOf(palabra, posicio + 1);
			}
		}

		return cont;
	}

	private String remplaçarParaula(String texto, String paraulaRemplaçar) {
		String paraulaBuscada = v.getTextFieldBuscar().getText();

		texto = texto.replace(paraulaBuscada, paraulaRemplaçar);

		m.guardarTexto(texto);

		return texto;

	}

}

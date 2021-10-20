package XML;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Biblioteca {
	
	private static ArrayList<Llibre> biblio = new ArrayList();
	
	// Metodos act
	public static int crearLlibre(Llibre llibre) {
		int resu = 0;
		return resu;
	}

//	public static Llibre recuperarLlibre(int id) {
//
//	}

	public static void mostrarLlibre(Llibre llibre) {

	}

	public static void borrarLlibre(int id) {

	}

	public static void actualitzaLlibre(int id) {

	}

	public static ArrayList<Llibre> recuperarTots() {
		ArrayList<Llibre> llibresBiblio = new ArrayList();
		
		return llibresBiblio;
	}

	// Metodos meus
	public static ArrayList<Llibre> plenarLlistaBiblio(String ruta){
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File(ruta));
			Element raiz = document.getDocumentElement();
			System.out.println("Contenido XML " + raiz.getNodeName() + ":");
			NodeList nodeList = document.getElementsByTagName("llibre");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				System.out.println("");
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					System.out.println("ID llibre : " + eElement.getAttribute("id"));
					System.out.println("Titol : " + eElement.getElementsByTagName("titol").item(0).getTextContent());
					System.out.println("Autor : " + eElement.getElementsByTagName("autor").item(0).getTextContent());
					System.out.println("Any Publicació : " + eElement.getElementsByTagName("anyPubli").item(0).getTextContent());
					System.out.println("Editorial : " + eElement.getElementsByTagName("editorial").item(0).getTextContent());
					System.out.println("Numero pagines : " + eElement.getElementsByTagName("numPagines").item(0).getTextContent());

					// Crear objectes
					int id = Integer.parseInt(eElement.getAttribute("id"));
					String titol = eElement.getElementsByTagName("titol").item(0).getTextContent();
					String autor = eElement.getElementsByTagName("autor").item(0).getTextContent();
					int anyPubli = Integer.parseInt(eElement.getElementsByTagName("anyPubli").item(0).getTextContent());
					String editorial = eElement.getElementsByTagName("editorial").item(0).getTextContent();
					int numPagines = Integer.parseInt(eElement.getElementsByTagName("numPagines").item(0).getTextContent());

					biblio.add(new Llibre(id, titol, autor, anyPubli, editorial, numPagines));
				}
			}
			
//			for (int i = 0; i < animals.size(); i++) {
//				System.out.println(animals.get(i));
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return biblio;
	}
	
	// Main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int seleccioMenu = 1;
		
		String ruta = ".\\src\\XML\\Arxius\\biblioteca.xml";
		
		do {
			if(seleccioMenu < 1 || seleccioMenu > 6) {
				System.err.println("Opcion incorrecta");
			}
			System.out.println("------- MENU -------");
			System.out.println("1. Mostrar tots els títols de la biblioteca");
			System.out.println("2. Mostrar informació detallada d'un llibre");
			System.out.println("2. Crear nou llibre");
			System.out.println("4. Actualitzar llibre");
			System.out.println("5. Borrar llibre");
			System.out.println("6. Tanca la biblioteca");
			seleccioMenu = sc.nextInt();
		}while(seleccioMenu < 1 || seleccioMenu > 6);
		
		switch (seleccioMenu) {
		case 1:
//			for (int i = 0; i < plenarLlistaBiblio(ruta).size(); i++) {
//				plenarLlistaBiblio(ruta).get(0).toString();
//			}
			plenarLlistaBiblio(ruta).get(0).toString();
			break;

		case 2:
			break;
		}
	}
}

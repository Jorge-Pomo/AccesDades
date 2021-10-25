package XML;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class Biblioteca {

	private static ArrayList<Llibre> biblio = new ArrayList();

	// Metodos act
	public static int crearLlibre(Llibre llibre) {
		int resu = 0;
		
		String nombre = "biblioteca";

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document document = implementation.createDocument(null, nombre, null);
			document.setXmlVersion("1.0");

			// Main Node
			Element raiz = document.getDocumentElement();
			// Por cada key creamos un item que contendrá la key y el value
			for (int i = 0; i < biblio.size(); i++) {
				// Item Node
				Element itemNode = document.createElement("llibre");
				// ID Node
				itemNode.setAttribute("id",String.valueOf(biblio.get(i).getIdentificador()));
				
				// Titol Node
				Element titolNode = document.createElement("titol");
				Text nodeTitolValue = document.createTextNode(biblio.get(i).getTitol());
				titolNode.appendChild(nodeTitolValue);
				// Autor Node
				Element autorNode = document.createElement("autor");
				Text nodeAutorValue = document.createTextNode(biblio.get(i).getAutor());
				autorNode.appendChild(nodeAutorValue);
				// Any Publicacio Node
				Element anyPubliNode = document.createElement("anyPubli");
				Text nodeAnyPubliValue = document.createTextNode(String.valueOf(biblio.get(i).getAnyPubli()));
				anyPubliNode.appendChild(nodeAnyPubliValue);
				// Editorial Node
				Element editorialNode = document.createElement("editorial");
				Text nodeEditorialValue = document.createTextNode(biblio.get(i).getEditorial());
				editorialNode.appendChild(nodeEditorialValue);
				// Num Pagimes Node
				Element numPaginesNode = document.createElement("numPagines");
				Text nodeNumPagineslValue = document.createTextNode(String.valueOf(biblio.get(i).getNumPagines()));
				numPaginesNode.appendChild(nodeNumPagineslValue);
				
				// append keyNode and valueNode to itemNode
				itemNode.appendChild(titolNode);
				itemNode.appendChild(autorNode);
				itemNode.appendChild(anyPubliNode);
				itemNode.appendChild(editorialNode);
				itemNode.appendChild(numPaginesNode);
				// append itemNode to raiz
				raiz.appendChild(itemNode); // pegamos el elemento a la raiz "Documento"
			}
			// Generate XML
			Source source = new DOMSource(document);
			// Indicamos donde lo queremos almacenar
			Result result = new StreamResult(new java.io.File(".\\src\\XML\\Arxius\\biblioteca.xml")); // nombre
																												// del
																												// archivo
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);
		} catch (ParserConfigurationException | TransformerException | TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resu;
	}

	// public static Llibre recuperarLlibre(int id) {
	//
	// }

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
	public static ArrayList<Llibre> plenarLlistaBiblio(String ruta) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File(ruta));
			Element raiz = document.getDocumentElement();
			NodeList nodeList = document.getElementsByTagName("llibre");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
//				System.out.println("");
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					// Crear objectes
					int id = Integer.parseInt(eElement.getAttribute("id"));
					String titol = eElement.getElementsByTagName("titol").item(0).getTextContent();
					String autor = eElement.getElementsByTagName("autor").item(0).getTextContent();
					int anyPubli = Integer.parseInt(eElement.getElementsByTagName("anyPubli").item(0).getTextContent());
					String editorial = eElement.getElementsByTagName("editorial").item(0).getTextContent();
					int numPagines = Integer
							.parseInt(eElement.getElementsByTagName("numPagines").item(0).getTextContent());

					biblio.add(new Llibre(id, titol, autor, anyPubli, editorial, numPagines));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return biblio;
	}

	// Main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String seleccioMenu = "1";
		String ruta = ".\\src\\XML\\Arxius\\biblioteca.xml";
		ArrayList<Llibre> plenarBiblio =  plenarLlistaBiblio(ruta);

		do {
			if (Integer.parseInt(seleccioMenu) < 1 || Integer.parseInt(seleccioMenu) > 6) {
				System.err.println("Opcion incorrecta");
			}
			System.out.println("------- MENU -------");
			System.out.println("1. Mostrar tots els títols de la biblioteca");
			System.out.println("2. Mostrar informació detallada d'un llibre");
			System.out.println("3. Crear nou llibre");
			System.out.println("4. Actualitzar llibre");
			System.out.println("5. Borrar llibre");
			System.out.println("6. Tanca la biblioteca");
			seleccioMenu = sc.nextLine();
		} while (Integer.parseInt(seleccioMenu) < 1 || Integer.parseInt(seleccioMenu) > 6);

		switch (Integer.parseInt(seleccioMenu)) {
		case 1:
			 for (int i = 0; i < plenarBiblio.size(); i++) {
				 System.out.println(plenarBiblio.get(i).getTitol());
			 }
			break;

		case 2:
			System.out.println("Dime el id del libro: ");
			int id = Integer.parseInt(sc.nextLine());
			System.out.println(plenarBiblio.get(id).toString());
			break;
		case 3:
			Llibre nouLlibre = new Llibre();
			nouLlibre.setIdentificador(plenarBiblio.size() + 1);
			
			System.out.println("Dime el titul: ");
			nouLlibre.setTitol(sc.nextLine());
			
			System.out.println("Dime el autor: ");
			nouLlibre.setAutor(sc.nextLine());
			
			System.out.println("Dime l'any de publicacio: ");
			nouLlibre.setAnyPubli(Integer.parseInt(sc.nextLine()));
			
			System.out.println("Dime la editorial: ");
			nouLlibre.setEditorial(sc.nextLine());
			
			System.out.println("Dime el nombre de pagines");
			nouLlibre.setNumPagines(Integer.parseInt(sc.nextLine()));
			
			biblio.add(nouLlibre);
			
			crearLlibre(nouLlibre);
			break;
		case 4:
			System.out.println("Dime el id del libro que quiere actualizar: ");
			System.out.println("El libro que quiere actualizar es : " + plenarBiblio.get(Integer.parseInt(sc.nextLine()) - 1));
		}
	}
}

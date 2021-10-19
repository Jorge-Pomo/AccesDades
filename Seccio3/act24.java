package Seccio3;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
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

public class act24 {

	public static void generarXML(ArrayList<Animal> animals) {
		String nombre = "selva";

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
			for (int i = 0; i < animals.size(); i++) {
				// Item Node
				Element itemNode = document.createElement("animal");
				// ID Node
				Element IdNode = document.createElement("id");
				Text nodeIdValue = document.createTextNode("" + animals.get(i).getId());
				IdNode.appendChild(nodeIdValue);
				// Nombre Node
				Element nombreNode = document.createElement("nombre");
				Text nodeNombreValue = document.createTextNode(animals.get(i).getNombre());
				nombreNode.appendChild(nodeNombreValue);
				// Tipo Node
				Element tipoNode = document.createElement("tipo");
				Text nodeTipoValue = document.createTextNode(animals.get(i).getTipo());
				tipoNode.appendChild(nodeTipoValue);
				// Color Node
				Element colorNode = document.createElement("color");
				Text nodeColorValue = document.createTextNode(animals.get(i).getColor());
				colorNode.appendChild(nodeColorValue);
				// Edad Node
				Element edadNode = document.createElement("edad");
				Text nodeEdadValue = document.createTextNode("" + animals.get(i).getEdad());
				edadNode.appendChild(nodeEdadValue);
				// append keyNode and valueNode to itemNode
				itemNode.appendChild(IdNode);
				itemNode.appendChild(nombreNode);
				itemNode.appendChild(tipoNode);
				itemNode.appendChild(colorNode);
				itemNode.appendChild(edadNode);
				// append itemNode to raiz
				raiz.appendChild(itemNode); // pegamos el elemento a la raiz "Documento"
			}
			// Generate XML
			Source source = new DOMSource(document);
			// Indicamos donde lo queremos almacenar
			Result result = new StreamResult(new java.io.File(".\\src\\Seccio3\\ActivitatsSecc3\\animal.xml")); // nombre
																												// del
																												// archivo
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
		} catch (ParserConfigurationException | TransformerException | TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Animal> animals = new ArrayList();

		int id = 0;
		String nom = "";
		String tipo = "";
		String color = "";
		int edad = 0;

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File(".\\src\\Seccio3\\ActivitatsSecc3\\textXML.xml"));
			Element raiz = document.getDocumentElement();
			System.out.println("Contenido XML " + raiz.getNodeName() + ":");
			NodeList nodeList = document.getElementsByTagName("animal");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				System.out.println("");
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					System.out.println("ID animal : " + eElement.getAttribute("id"));
					System.out.println("Nombre : " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
					System.out.println("Tipo : " + eElement.getElementsByTagName("tipo").item(0).getTextContent());
					System.out.println("Color : " + eElement.getElementsByTagName("color").item(0).getTextContent());
					System.out.println("Edad : " + eElement.getElementsByTagName("edad").item(0).getTextContent());

					// Crear objectes
					id = Integer.parseInt(eElement.getAttribute("id"));
					nom = eElement.getElementsByTagName("nombre").item(0).getTextContent();
					tipo = eElement.getElementsByTagName("tipo").item(0).getTextContent();
					color = eElement.getElementsByTagName("color").item(0).getTextContent();
					edad = Integer.parseInt(eElement.getElementsByTagName("edad").item(0).getTextContent());

					animals.add(new Animal(id, nom, tipo, color, edad));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Plenem els atributs
		System.out.println("\nNou animal");
		System.out.print("Nom del animal: ");
		nom = sc.nextLine();
		System.out.print("Tipo de animal: ");
		tipo = sc.nextLine();
		System.out.print("Color del animal: ");
		color = sc.nextLine();
		System.out.print("Edad del animal: ");
		edad = sc.nextInt();

		id = animals.size() + 1;

		// Afegim en la llista
		animals.add(new Animal(id, nom, tipo, color, edad));

		for (int i = 0; i < animals.size(); i++) {
			System.out.println(animals.get(i));
		}

		try {
			generarXML(animals);
		} catch (Exception e) {
		}

	}

}

package Seccio3;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class act23 {

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
		

	}

}

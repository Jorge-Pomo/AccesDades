package Seccio3;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class act19 {

	public static void main(String[] args) {
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
					// System.out.println("Nombre : " +
					// eElement.getElementsByTagName("nombre").item(0).getTextContent());
					// System.out
					// .println("Tipo : " +
					// eElement.getElementsByTagName("tipo").item(0).getTextContent());
					// System.out.println("Color : " +
					// eElement.getElementsByTagName("color").item(0).getTextContent());
					// System.out
					// .println("Edad : " +
					// eElement.getElementsByTagName("edad").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

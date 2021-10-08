package App;

import java.util.StringTokenizer;

public class Lab {

	public static void main(String[] args) {
		Model m = new Model();

		String texto = m.imprimirTexto();

//		char[] caracteres = texto.toCharArray();
//
//		for (int i = 0; i < caracteres.length; i++) {
//			System.out.println(caracteres[i]);
//		}
//
//		String texto2 = "";
//
//		for (int i = 0; i < caracteres.length; i++) {
//			texto2 = texto2 + caracteres[i];
//		}
//
//		System.out.println(texto2);
//
//		String salto = "-";
//		String remplazar = "";
//		
//		StringTokenizer st = new StringTokenizer(texto);
//		while (st.hasMoreTokens()) {
//			if(salto.equals(st.nextElement())) {
//				remplazar = (String)st.nextElement();
//				remplazar.replaceAll("-", "\n-");
//			}
//			
//			System.out.print(st.nextElement() + " ");
//		}
		
		String textInBold = "Java_Prof_Level";
		System.out.print("\033[0;1m" + textInBold);
		
		
	}

}

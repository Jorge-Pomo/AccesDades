package Seccio1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class act8 {

	public static void main(String[] args) {
		String strPathArxiu = args[0];
		String strPathArxiuCopia = args[0];

		InputStream inputStream = null;
		OutputStream outputStream = null;

		try {
			File arxiuOriginal = new File(strPathArxiu);
			File arxiuCopiat = new File(strPathArxiuCopia);

			inputStream = new FileInputStream(arxiuOriginal);
			outputStream = new FileOutputStream(arxiuCopiat);

			byte[] buffer = new byte[1024];
			int length;

			while ((length = inputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, length);
			}

			inputStream.close();
			outputStream.close();

			System.out.println("Arxiu Copiat.");

			arxiuOriginal.delete();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

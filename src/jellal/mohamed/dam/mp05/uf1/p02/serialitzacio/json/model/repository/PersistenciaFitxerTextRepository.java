package jellal.mohamed.dam.mp05.uf1.p02.serialitzacio.json.model.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PersistenciaFitxerTextRepository {

	private PersistenciaFitxerTextRepository() {

	}

	public static PersistenciaFitxerTextRepository getInstance() {
		if (instance == null) {
			instance = new PersistenciaFitxerTextRepository();
		}
		return instance;
	}

	private static PersistenciaFitxerTextRepository instance = null;

	public void save(String fitxer, String contingut, boolean agregarAlcontingutExistent) throws IOException {
		File file = new File(fitxer);
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;

		fileWriter = new FileWriter(file, agregarAlcontingutExistent);

		// BufferedWriter – Esta clase es usada para hacer clases de bajo nivel como
		// FileWriters de una manera mas eficiente y mas fáciles de usar. Comparado con
		// las clases FileWriter, los BufferedWriters escribe relativamente grandes
		// cantidades de información a un archivo, lo cual minimiza el número de veces
		// que las operaciones de escritura de archivos se llevan a cabo, las cuales son
		// operaciones mas lentas. La clase BufferedWriter tambien provee un método
		// llamado newLine() el cual crea separadores de linea específicos de la
		// plataforma de manera automática.

		bufferedWriter = new BufferedWriter(fileWriter);

		if (contingut != null && contingut.length() > 0) {
			bufferedWriter.write(contingut);

		}

		if (bufferedWriter != null) {
			bufferedWriter.close();
		}

		if (fileWriter != null) {
			fileWriter.close();
		}

	}

	public String read(String fitxer) throws IOException {

		String resultat = null;
		File file = new File(fitxer);

		StringBuilder sb = new StringBuilder();

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		fileReader = new FileReader(file, StandardCharsets.UTF_8);

		// BufferedReader – Esta clase es usada para hacer clases Reader de bajo nivel
		// como FileReader pero de una manera mas eficiente y mas fácil de usar.
		// Comparado con los FileReaders, los BufferedReaders leen relativamente grandes
		// cantidades de un archivo a la vez, y mantienen esta información en el buffer.
		// Cuando preguntamos por el siguiente caracter o la siguiente linea de
		// información, es recuperado del buffer, lo que minimiza el número de veces que
		// se tiene que leer desde el archivo, lo cual es una operación mas lenta. En
		// adición, la clase BufferedReader proveen métodos mas convenientes como
		// readLine(), el cual nos permite leer la siguiente linea de caracteres de un
		// archivo.

		// Podremos leer línea a línea, por lo que la lectura será más eficiente y el
		// código más claro.
		bufferedReader = new BufferedReader(fileReader);

		String linia = bufferedReader.readLine();
		while (linia != null) {
			// System.out.println(linea);
			sb.append(linia);
			linia = bufferedReader.readLine();
		}

		if (bufferedReader != null) {

			bufferedReader.close();
		}

		if (fileReader != null) {
			fileReader.close();

		}

		resultat = sb.toString();
		return resultat;
	}

}

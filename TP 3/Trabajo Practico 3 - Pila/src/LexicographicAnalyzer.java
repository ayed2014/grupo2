
import java.io.*;

/**
 * @author Nicolas Burroni
 * @since 3/18/14
 */
public class LexicographicAnalyzer {


    /**
     * Lee un archivo y se fija que todos los parentesis, corchetes y llaves abiertas tengan un cierre
     * @param file el archivo que se va a leer
     * @return devuelve verdadero si todos los parentesis, corchetes y llaves tienen un cierre
     * @throws IOException
     */
	public static boolean analyze(File file) throws IOException {
		Pila openingClauses = new PilaD();

		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		char[] characters;

		while((line = reader.readLine())!= null){
			characters = line.toCharArray();
			for(char c : characters){
				switch(c){
					case '{':
						openingClauses.apilar(c);
						break;
					case '[':
						openingClauses.apilar(c);
						break;
					case '(':
						openingClauses.apilar(c);
						break;
					case '}':
						if(openingClauses.esVacia()) return false;
						if(((char)openingClauses.verTope()) != '{') return false;
						else openingClauses.desapilar();
						break;
					case ']':
						if(openingClauses.esVacia()) return false;
						if(((char)openingClauses.verTope()) != '[') return false;
						else openingClauses.desapilar();
						break;
					case ')':
						if(openingClauses.esVacia()) return false;
						if(((char)openingClauses.verTope()) != '(') return false;
						else openingClauses.desapilar();
						break;
					default: break;
				}
			}
		}
		return openingClauses.esVacia();
	}

}

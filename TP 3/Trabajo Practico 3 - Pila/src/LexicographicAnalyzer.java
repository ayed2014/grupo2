
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
		Stack openingClauses = new StackD();

		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		char[] characters;

		while((line = reader.readLine())!= null){
			characters = line.toCharArray();
			for(char c : characters){
				switch(c){
					case '{':
						openingClauses.push(c);
						break;
					case '[':
						openingClauses.push(c);
						break;
					case '(':
						openingClauses.push(c);
						break;
					case '}':
						if(openingClauses.isEmpty()) return false;
						if(((char)openingClauses.seeTop()) != '{') return false;
						else openingClauses.pop();
						break;
					case ']':
						if(openingClauses.isEmpty()) return false;
						if(((char)openingClauses.seeTop()) != '[') return false;
						else openingClauses.pop();
						break;
					case ')':
						if(openingClauses.isEmpty()) return false;
						if(((char)openingClauses.seeTop()) != '(') return false;
						else openingClauses.pop();
						break;
					default: break;
				}
			}
		}
		return openingClauses.isEmpty();
	}

}

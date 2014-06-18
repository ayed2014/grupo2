import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Nicolas Burroni
 * @since 6/18/2014
 */
public class Ejercicio2 {

	public static void main(String[] args) {
		Ejercicio2.menu();
	}

	public static void menu(){
		String path = Scanner.getString("Enter a file path: ", "Please enter a valid path! ");
		FileReader fileReader = null;
		while (true) {
			try {
				fileReader = new FileReader(path);
				break;
			} catch (FileNotFoundException e) {
				path = Scanner.getString("File not found! Please enter another file path: ", "Please enter a valid path! ");
			}
		}
		char c = Scanner.getChar("Enter the character to search: ", "Please enter a valid character! ");
		int read = 0;
		try {
			read = fileReader.read();
		} catch (IOException e) {
			System.out.println("There was an error reading the file.");
		}
		int count = 0;
		try {
			while (read != -1){
				if(c == (char) read) count++;
				read = fileReader.read();
			}
		} catch (IOException e) {
			System.out.println("There was an error reading the file.");
		} finally {
			System.out.println("There are " + count + " occurences of " + c + " in the file.");
		}
	}

}

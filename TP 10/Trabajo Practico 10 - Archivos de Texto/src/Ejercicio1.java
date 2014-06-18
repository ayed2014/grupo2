import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Nicolas Burroni
 * @since 6/18/2014
 */
public class Ejercicio1 {


	public static void main(String[] args) {
		Ejercicio1.menu();
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
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		char[] allowed = {'l', 'c'};
		char choice = Scanner.getChar("Enter 'c' to count characters, or 'l' to count lines: ", "Please enter a valid choice! ",allowed);
		if(choice == 'c'){
			int read = 0;
			try {
				read = fileReader.read();
			} catch (IOException e) {
				System.out.println("There was an error reading the file.");
			}
			int count = 0;
			try {
				while (read != -1){
					count++;
					read = fileReader.read();
				}
			} catch (IOException e) {
				System.out.println("There was an error reading the file.");
			} finally {
				System.out.println("There are " + count + " characters in the file.");
			}
		} else {
			String read = null;
			try {
				read = bufferedReader.readLine();
			} catch (IOException e) {
				System.out.println("There was an error reading the file.");
			}
			int count = 0;
			try {
				while (read != null){
					count++;
					read = bufferedReader.readLine();
				}
			} catch (IOException e) {
				System.out.println("There was an error reading the file.");
			} finally {
				System.out.println("There are " + count + " lines in the file.");
			}
		}
	}

}

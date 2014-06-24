import java.io.*;

/**
 * @author Nicolas Burroni
 * @since 6/18/2014
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		Ejercicio3.menu();
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
		BufferedWriter bufferedWriter;
		int[] allowed = {1, 2};
		int choice = Scanner.getInt("Convert to:\n1.\tLower case\n2.\tUpper case\n", "Please enter a valid choice! ", allowed);
		try {
			String line = bufferedReader.readLine();
			if(choice == 1){
				bufferedWriter = new BufferedWriter(new FileWriter(path + "(lowercase)"));
				while(line != null){
					bufferedWriter.write(line.toLowerCase() + "\n");
				}
			} else {
				bufferedWriter = new BufferedWriter(new FileWriter(path + "(uppercase)"));
				while(line != null){
					bufferedWriter.write(line.toUpperCase() + "\n");
				}
			}
		} catch (IOException e) {
			System.out.println("Sorry, there was an error. Please try again.");
		}
	}

}

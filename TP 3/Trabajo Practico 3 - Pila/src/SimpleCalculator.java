import java.util.Scanner;

/**
 * @author Nicolas Burroni
 * @since 3/19/14
 */
public class SimpleCalculator {

	public double calculate(String input){
		Pila pila = new PilaE();
		toPosfix(input);

		return (double) pila.verTope();
	}

	private String toPosfix(String input){
		//Pila
		return null;
	}

	public String scanInput(){
		Scanner scanner = new Scanner(System.in);
		final String result = scanner.nextLine().trim();
		if(result.isEmpty()) {
			System.out.println("\nPlease enter text.");
			return scanInput();
		}
		return result;
	}

}

import java.util.Scanner;

/**
 * @author Nicolas Burroni
 * @since 3/19/14
 */
public class SimpleCalculator {

	public double calculate(String input){
		if(input.charAt(input.length() - 1) != '=') throw new IllegalArgumentException("No equals sign(=) found!");
		Pila pila = new PilaE();
		String equation = toPostfix(input);
		for (int i= 0; i < equation.length(); i++){
			char c = equation.charAt(i);
			if (Character.isDigit(c)){
				double d = (double) Character.getNumericValue(c);
				pila.apilar(d);
			} else {
				if (c == '+'){
					double i1 = (double) pila.verTope();
					pila.desapilar();
					double i2 = (double) pila.verTope();
					pila.desapilar();
					double i3 = i1 + i2;
					pila.apilar(i3);
				} else if (c== '-'){
					double i1 = (double) pila.verTope();
					pila.desapilar();
					double i2 = (double) pila.verTope();
					pila.desapilar();
					double i3 = i2 - i1;
					pila.apilar(i3);
				} else if (c == '*'){
					double i1 = (double) pila.verTope();
					pila.desapilar();
					double i2 = (double) pila.verTope();
					pila.desapilar();
					double i3 = i1 * i2;
					pila.apilar(i3);
				} else if (c == '/'){
					double i1 = (double) pila.verTope();
					pila.desapilar();
					double i2 = (double) pila.verTope();
					pila.desapilar();
					double i3 = i2 / i1;
					pila.apilar(i3);
				}
			}
		}
		return (double) pila.verTope();
	}

	private String toPostfix(String input){
		char[] inputChars = input.toCharArray();
		Pila exit = new PilaE();
		Pila pila = new PilaE();

		for(char c : inputChars){
			if(c == ' ') continue;
			if(Character.isDigit(c))
				exit.apilar(c);
			else if(c == '='){
				while(!pila.esVacia()){
					exit.apilar(pila.verTope());
					pila.desapilar();
				}
			}
			else{ //Asumimos que si no es un numero, es un operador
				if(pila.esVacia()) pila.apilar(c);
				else{
					char tope = (char)pila.verTope();
					while(comparePriority(tope, c) != -1){
						try{
							exit.apilar(tope);
							pila.desapilar();
							tope = (char)pila.verTope();
						}catch(IndexOutOfBoundsException e){
							break;
						}
					}
					pila.apilar(c);
				}
			}
		}
		Pila reverseExit = new PilaE();
		while(!exit.esVacia()){
			reverseExit.apilar(exit.verTope());
			exit.desapilar();
		}
		String postfixInput = "";
		while(!reverseExit.esVacia()){
			postfixInput += (char) reverseExit.verTope();
			reverseExit.desapilar();
		}
		//System.out.println(postfixInput);
		return postfixInput;
	}

	/**
	 * Compara la prioridad de c1 respecto a la de c2 siendo operadores. Devuelve 1 si c1 tiene mayor
	 * prioridad que c2, devuelve 0 si c1 tiene igual prioridad que c2, y -1 si c1 tiene menor prioridad
	 * que c2.
	 * @param c1
	 * @param c2
	 * @return
	 */
	private int comparePriority(char c1, char c2){
		if(c1 == '+' || c1 == '-'){
			if(c2 == '+' || c2 == '-') return 0;
			else if(c2 == '*' || c2 == '/') return -1;
		}else if(c1 == '*' || c1 == '/'){
			if(c2 == '*' || c2 == '/') return 0;
			else return 1;
		}
		throw new IllegalArgumentException();
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

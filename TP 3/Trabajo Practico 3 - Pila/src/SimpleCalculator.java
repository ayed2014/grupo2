import java.util.Scanner;

/**
 * @author Nicolas Burroni
 * @since 3/19/14
 */
public class SimpleCalculator {

    /**
     * Calcula el resultado de una ecuacion
     *
     * @param input es la ecuacion en prefija
     * @return devuelve el resultado de la ecuacion
     */
    public double calculate(String input) {
        if (input.charAt(input.length() - 1) != '=') throw new IllegalArgumentException("No equals sign(=) found!");
        Stack stack = new StackE();
        String equation = toPostfix(input);
        for (int i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);
            if (Character.isDigit(c)) {
                double d = (double) Character.getNumericValue(c);
                stack.push(d);
            } else {
                if (c == '+') {
                    double i1 = (double) stack.seeTop();
                    stack.pop();
                    double i2 = (double) stack.seeTop();
                    stack.pop();
                    double i3 = i1 + i2;
                    stack.push(i3);
                } else if (c == '-') {
                    double i1 = (double) stack.seeTop();
                    stack.pop();
                    double i2 = (double) stack.seeTop();
                    stack.pop();
                    double i3 = i2 - i1;
                    stack.push(i3);
                } else if (c == '*') {
                    double i1 = (double) stack.seeTop();
                    stack.pop();
                    double i2 = (double) stack.seeTop();
                    stack.pop();
                    double i3 = i1 * i2;
                    stack.push(i3);
                } else if (c == '/') {
                    double i1 = (double) stack.seeTop();
                    stack.pop();
                    double i2 = (double) stack.seeTop();
                    stack.pop();
                    double i3 = i2 / i1;
                    stack.push(i3);
                }
            }
        }
        return (double) stack.seeTop();
    }

    /**
     * Ordena una ecuacion de forma posfija
     *
     * @param input es la ecuacion en prefija a ordenar
     * @return devuelve la ecuacion en posfija
     */
    private String toPostfix(String input) {
        char[] inputChars = input.toCharArray();
        Stack exit = new StackE();
        Stack stack = new StackE();

        for (char c : inputChars) {
            if (c == ' ') continue;
            if (Character.isDigit(c))
                exit.push(c);
            else if (c == '=') {
                while (!stack.isEmpty()) {
                    exit.push(stack.seeTop());
                    stack.pop();
                }
            } else { //Asumimos que si no es un numero, es un operador
                if (stack.isEmpty()) stack.push(c);
                else {
                    char tope = (char) stack.seeTop();
                    while (comparePriority(tope, c) != -1) {
                        try {
                            exit.push(tope);
                            stack.pop();
                            tope = (char) stack.seeTop();
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }
                    stack.push(c);
                }
            }
        }
        Stack reverseExit = new StackE();
        while (!exit.isEmpty()) {
            reverseExit.push(exit.seeTop());
            exit.pop();
        }
        String postfixInput = "";
        while (!reverseExit.isEmpty()) {
            postfixInput += (char) reverseExit.seeTop();
            reverseExit.pop();
        }
        //System.out.println(postfixInput);
        return postfixInput;
    }

    /**
     * Compara la prioridad de c1 respecto a la de c2 siendo operadores. Devuelve 1 si c1 tiene mayor
     * prioridad que c2, devuelve 0 si c1 tiene igual prioridad que c2, y -1 si c1 tiene menor prioridad
     * que c2.
     *
     * @param c1
     * @param c2
     * @return
     */
    private int comparePriority(char c1, char c2) {
        if (c1 == '+' || c1 == '-') {
            if (c2 == '+' || c2 == '-') return 0;
            else if (c2 == '*' || c2 == '/') return -1;
        } else if (c1 == '*' || c1 == '/') {
            if (c2 == '*' || c2 == '/') return 0;
            else return 1;
        }
        throw new IllegalArgumentException();
    }

    /**
     * Pide un string al usuario
     * @return devuelve el string
     */
    public String scanInput() {
        Scanner scanner = new Scanner(System.in);
        final String result = scanner.nextLine().trim();
        if (result.isEmpty()) {
            System.out.println("\nPlease enter text.");
            return scanInput();
        }
        return result;
    }

}

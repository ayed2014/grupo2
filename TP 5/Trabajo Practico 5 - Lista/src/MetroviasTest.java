
import java.util.Scanner;

/**
 * Created by Francisco on 10/04/14.
 */
public class MetroviasTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many windows: ");
        int i = scanner.nextInt();
        Metrovias m = new Metrovias(i);
        m.simulate();
    }
}


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
	    System.out.println("AVG wait time: " + m.getAverageWaitTime());
	    System.out.println("TOTAL earnings: " + m.getTotalEarnings());
	    System.out.println("Idle times: ");
	    for(int j : m.getIdleTimes()) System.out.println(j);
    }
}

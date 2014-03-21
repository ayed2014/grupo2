
import java.io.*;

/**
 * @author Nicolas Burroni
 * @since 3/18/14
 */
public class Test {

	public static void main(String[] args) {

		System.out.println("\n*******\n");
		try {
			System.out.println(LexicographicAnalyzer.analyze(new File("src/test1.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\n*******\n");
		try {
			System.out.println(LexicographicAnalyzer.analyze(new File("src/test2.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

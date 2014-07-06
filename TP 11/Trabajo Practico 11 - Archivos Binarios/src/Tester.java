
import java.io.IOException;

/**
 * @author Juan Ignacio Longo
 * @date 04/07/14.
 */
public class Tester {

    public static void main(String[] args) throws IOException {
        FileAnimal fa = new FileAnimal("testFile");
//            fa.add();
       fa.remove();
//        fa.consultAnimal(5);
        fa.report();
        fa.close();
    }
}

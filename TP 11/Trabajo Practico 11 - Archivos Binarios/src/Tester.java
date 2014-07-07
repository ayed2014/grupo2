
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Juan Ignacio Longo
 * @date 04/07/14.
 */
public class Tester {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        FileAnimal fa = new FileAnimal("AnimalFile");
        int option;
        System.out.println("Choose an option:");
        System.out.println("1. Add entry\n2. Modify entry\n3. Remove entry\n4. Generate full report" +
                "\n5. Generate report for a certain conditon\n6. Show number of entries\n7. Show number of entries " +
                "for a certain condition\n8.Generate index file\n9. Consult one tag\n10. Exit");
        option = Integer.parseInt(s.nextLine());
        while (option != 10) {
            switch (option) {
                case 1:
                    fa.add();
                    break;
                case 2:
                    fa.modify();
                    break;
                case 3:
                    fa.remove();
                    break;
                case 4:
                    fa.report();
                    break;
                case 5:
                    fa.reportByCondition();
                    break;
                case 6:
                    System.out.println(fa.getAmountOfEntries());
                    break;
                case 7:
                    System.out.println(fa.getAmountOfEntriesByCondition());
                    break;
                case 8:
                    fa.generateIndexFile();
                    break;
                case 9:
                    fa.consultAnimal();
                default:
                    System.out.println("That is not a valid option.");
            }
            System.out.println("Choose an option:");
            System.out.println("1. Add entry\n2. Modify entry\n3. Remove entry\n4. Generate full report" +
                    "\n5. Generate report for a certain conditon\n6. Show number of entries\n7. Show number of entries " +
                    "for a certain condition\n8.Generate index file\n9. Consult one tag\n10. Exit");
            option = Integer.parseInt(s.nextLine());
        }
        fa.close();
    }
}

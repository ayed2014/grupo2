import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ListToTreeApi {

    public BinarySearchTree ListToTree(List<LightBulb> lightBulbs){
        BinarySearchTree tree = new BinarySearchTreeD();
        for(LightBulb bulb : lightBulbs){
            tree.insert(bulb);
        }
        return tree;
    }

    public void high(BinarySearchTree tree, LightBulb lightBulb){
        tree.insert(lightBulb);
    }

    public void low(BinarySearchTree tree, LightBulb lightBulb){
        tree.remove(lightBulb);
    }

    public void createReport(BinarySearchTree a){
        if(a.isEmpty()) return;
        System.out.println(a.getRoot());
        System.out.println("Code : " + ((LightBulb) a.getRoot()).REFERENCE_CODE);
        System.out.println("Watts : " + ((LightBulb) a.getRoot()).getWatts());
        System.out.println("Type: " + ((LightBulb) a.getRoot()).getType());
        System.out.println("Quantity: " + ((LightBulb) a.getRoot()).getQuantity());
        createReport((BinarySearchTree) a.getLeft());
        createReport((BinarySearchTree) a.getRight());
    }

    public void modify(BinarySearchTree tree, String code) throws NoSuchElementException{
        LightBulb lightBulb = new LightBulb(code,0,"");
        LightBulb l = null;
        boolean enter = true;

        l = (LightBulb)tree.search(lightBulb);    //Might throw NoSuchElementException

	    if(enter){
            Scanner scanner = new Scanner(System.in);
            System.out.println("1 to modify type, 2 to modify watts, 3 to modify quantity");
            int n = scanner.nextInt();
            while(n < 1 || n > 3){
                System.out.println("Please enter a number between 1 to modify type, 2 to modify watts, 3 to modify quantity");
                n = scanner.nextInt();
            }
            switch (n){
                case 1:
                    System.out.println("Please enter the new type of light bulb");
                    String newType = scanner.nextLine();
                    l.setType(newType);
                    break;
                case 2:
                    System.out.println("Please enter the new amount of watts of the light bulb");
                    int newWatts = scanner.nextInt();
                    l.setWatts(newWatts);
                    break;
                case 3:
                    System.out.println("Please enter the new quantity of light bulbs");
                    int newQuantity = scanner.nextInt();
                    l.setQuantity(newQuantity);
                    break;
                default:
                    break;
            }
        }
    }
}

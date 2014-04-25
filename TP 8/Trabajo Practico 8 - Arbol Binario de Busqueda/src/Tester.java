import java.util.ArrayList;


/**
 * Created by juan on 23/04/14.
 */
public class Tester {
    public static void main(String[] args) {
        LightBulb bulb = new LightBulb("hola3",60,"LED");
        LightBulb bulb1 = new LightBulb("hola2",60,"LED");
        ListToTreeApi api = new ListToTreeApi();
        ArrayList<LightBulb> list = new ArrayList<LightBulb>();
        list.add(bulb);
        list.add(bulb1);
        BinarySearchTree tree = api.ListToTree(list);
        api.modify(tree,"hola1");
        api.low(tree,bulb1);
        api.createReport(tree);
    }
}

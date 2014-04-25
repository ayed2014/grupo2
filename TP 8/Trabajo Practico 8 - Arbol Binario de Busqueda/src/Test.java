import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * @author Nicolas Burroni
 * @since 4/23/2014
 */
public class Test {
	public static void main(String[] args) {
		/*BinarySearchTree b = new BinarySearchTreeD();
		b.insert("Nico");
		b.insert("Humi");
		b.insert("Yankee");
		b.insert("Alvaro");
		b.insert("Anastasia");
		b.insert("Gabriel");
		b.insert("Maria");
		b.insert("Hello World");
		(new BinaryTreeApi()).printPreorder(b);
		System.out.println("");
		b.remove("Hello World");
		new BinaryTreeApi().printPreorder(b);*/
		LightBulb bulb = new LightBulb("hola3",60,"LED");
		LightBulb bulb1 = new LightBulb("hola2",60,"LED");
		ListToTreeApi api = new ListToTreeApi();
		ArrayList<LightBulb> list = new ArrayList<LightBulb>();
		list.add(bulb);
		list.add(bulb1);
		BinarySearchTree tree = api.ListToTree(list);
		String s;
		s = "hola1";
		try {
			api.modify(tree, s);
		} catch (NoSuchElementException e) {
			System.out.println("Couldn't find " + s);
		}
		s = "hola2";
		try {
			api.modify(tree, s);
		} catch (NoSuchElementException e) {
			System.out.println("Couldn't find " + s);
		}
		api.low(tree,bulb1);
		api.createReport(tree);
	}
}

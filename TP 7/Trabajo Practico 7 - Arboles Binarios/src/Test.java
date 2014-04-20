/**
 * @author Nicolas Burroni
 * @since 4/8/2014
 */
public class Test {
	public static void main(String[] args) {
		BinaryTreeApi binaryTreeApi = new BinaryTreeApi();
		System.out.println(binaryTreeApi.treeOccursIn(
				new BinaryTreeD("1",
						new BinaryTreeD("2",
								new BinaryTreeD("4"),
								new BinaryTreeD("5")),
						new BinaryTreeD("3",
								new BinaryTreeD("6"),
								new BinaryTreeD("7"))
				),
				new BinaryTreeD("2",
						new BinaryTreeD("4"),
						new BinaryTreeD("5"))
		));
	}
}

/**
 * @author Nicolas Burroni
 * @since 3/26/2014
 */
public class BinaryTreeD implements BinaryTree {

	protected NodoDoble root;

	public BinaryTreeD(){
		root = null;
	}

	public BinaryTreeD(Object x){
		root = new NodoDoble(x);
	}

	public BinaryTreeD(Object x, BinaryTreeD leftTree, BinaryTreeD rightTree){
		root = new NodoDoble(x);
		root.left = leftTree.root;
		root.right = rightTree.root;
	}

	public BinaryTreeD(Object x, NodoDoble leftTree, NodoDoble rightTree){
		root = new NodoDoble(x);
		root.left = leftTree;
		root.right = rightTree;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public Object getRoot() {
		return root.obj;
	}

	@Override
	public BinaryTree getLeft() {
		BinaryTreeD t = new BinaryTreeD();
		t.root = root.left;
		return t;
	}

	@Override
	public BinaryTree getRight() {
		BinaryTreeD t = new BinaryTreeD();
		t.root = root.right;
		return t;
	}
}

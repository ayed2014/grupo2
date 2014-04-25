import java.util.NoSuchElementException;

/**
 * @author Nicolas Burroni
 * @since 4/9/2014
 */
public class BinarySearchTreeD extends BinaryTreeD implements BinarySearchTree {

	public BinarySearchTreeD(){
		super();
	}

	@Override
	public void insert(Comparable c) {
		if(exists(c)) throw new IllegalArgumentException("Object already exists in this tree");
		root = insert(c, root);
	}

	public Comparable search(Comparable c){
		if(exists(c)){
			return (Comparable) search(root, c).obj;
		} else {
			throw new NoSuchElementException("There is no such element on this tree");
		}
	}

	private NodoDoble search(NodoDoble root, Comparable c) {
		if (c.compareTo(root.obj) == 0)
			return root;
		else if (c.compareTo( root.obj)< 0)
			return search(root.left, c);
		else
			return search(root.right, c);
	}

	@Override
	public void remove(Comparable c){
		root = remove(root, c);
	}

	private NodoDoble remove(NodoDoble root, Comparable c) {
		if (c.compareTo(root.obj) < 0)
			root.left = remove(root.left, c);
		else if (c.compareTo(root.obj) > 0)
			root.right = remove(root.right, c);
		else {
			if (root.left != null && root.right != null) {
				root.obj = getMin(root.right).obj;
				root.right = removeMin(root.right);
			} else if (root.left != null)
				root = root.left;
			else
				root = root.right;
		}
		return root;
	}

	private NodoDoble removeMin(NodoDoble t){
		if (t.left != null)
			t.left = removeMin(t.left);
		else
			t = t.right;
		return t;
	}

	@Override
	public boolean exists(Comparable c) {
		return exists(c, root);
	}

	@Override
	public Comparable getMin() {
		return (Comparable) getMin(root).obj;
	}

	private NodoDoble getMin(NodoDoble root) {
        NodoDoble n = root;
        while(n.left != null) n = n.left;
		return n;
	}

	@Override
	public Comparable getMax() {
		return (Comparable) getMax(root).obj;
	}

	private NodoDoble getMax(NodoDoble root) {
        NodoDoble n = root;
        while(n.right != null) n = n.right;
        return n;
	}


	private NodoDoble insert(Comparable c, NodoDoble root){
		if(root == null) root = new NodoDoble(c);
		else if(c.compareTo(root.obj) < 0) root.left = insert(c, root.left);
		else if(c.compareTo(root.obj) > 0) root.right = insert(c, root.right);
		return root;
	}

    private boolean exists(Comparable c, NodoDoble root){
        if(root == null) return false;
        if(c.compareTo(root.obj) < 0) return exists(c, root.left);
        else if(c.compareTo(root.obj) > 0) return exists(c, root.right);
        else return true;
    }

	@Override
	public BinarySearchTree getLeft() {
		BinarySearchTreeD t = new BinarySearchTreeD();
		t.root = root.left;
		return t;
	}

	@Override
	public BinarySearchTree getRight() {
		BinarySearchTreeD t = new BinarySearchTreeD();
		t.root = root.right;
		return t;
	}
}

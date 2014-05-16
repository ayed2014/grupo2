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
		if(exists(c)) throw new IllegalArgumentException("Element already exists in this tree!");
		insert(c, root);
	}

	@Override
	public void remove(Comparable c) {
		if(!exists(c)) throw new IllegalArgumentException("Element does not exist in this list");
		NodoDoble aux = root;
		if(c.compareTo(aux.obj) < 0) aux = aux.left;
		else if(c.compareTo(aux.obj) > 0) aux = aux.right;
		else {
			if(aux.left == null && aux.right == null) aux = null;
			else if(aux.left == null) aux = aux.right;
			else if(aux.right == null) aux = aux.left;
			else{
				NodoDoble aux2 = getMax(aux.left);
				aux.obj = aux2.obj;
				aux2 = null;
			}
		}
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


	private void insert(Comparable c, NodoDoble root){
		if(root == null) root = new NodoDoble(c);
		if(c.compareTo(root.obj) < 0) insert(c, root.left);
		else if(c.compareTo(root.obj) > 0) insert(c, root.right);
	}

    private boolean exists(Comparable c, NodoDoble root){
        if(root == null) return false;
        if(c.compareTo(root.obj) < 0) exists(c, root.left);
        else if(c.compareTo(root.obj) > 0) exists(c, root.right);
        return true;
    }
}

/**
 * @author Nicolas Burroni
 * @since 4/9/2014
 */
public interface BinarySearchTree extends BinaryTree {

	public void insert(Comparable c);

	public void remove(Comparable c);

	public Comparable search(Comparable c);

	public boolean exists(Comparable c);

	public Comparable getMin();

	public Comparable getMax();

}

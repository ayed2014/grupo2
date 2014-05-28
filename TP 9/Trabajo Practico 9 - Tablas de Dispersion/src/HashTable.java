
/**
 * @author Nicolas Burroni
 * @since 5/14/2014
 */
public interface HashTable {

	public void insert(Hashable elem);
	public void delete(Hashable elem);
	public Object get(Hashable elem);
	public boolean exists(Hashable elem);
	public BinarySearchTree toBinarySearchTree();
	public void destroy();

}

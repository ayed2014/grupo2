
/**
 * @author Nicolas Burroni
 * @since 5/14/2014
 */
public interface HashTable {

	public void insert(Object obj);
	public void delete(String key);
	public Object get(String key);
	public boolean exists(String key);
	public BinarySearchTree toBinarySearchTree();
	public void destroy();

}

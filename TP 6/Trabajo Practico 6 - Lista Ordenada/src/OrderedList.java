/**
 * @author Nicolas Burroni
 * @since 4/11/2014
 */
public interface OrderedList {

	public void insert(Comparable elem);

	public Comparable seeCurrent();

	public void empty();

	public boolean isEmpty();

	public void next();

	public void previous();

	public void goTo(int index);

	public void remove();

	public int size();
}

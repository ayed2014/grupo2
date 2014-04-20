/**
 * @author Nicolas Burroni
 * @since 4/4/2014
 */
public interface List {

	public Object seeCurrent();

	public void empty();

	public boolean isEmpty();

	public void addBefore(Object obj);

	public void addAfter(Object obj);

	public void next();

	public void previous();

	public void goTo(int index);

	public void remove();

	public void modify(Object obj);

	public int size();


}

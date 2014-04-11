/**
 * @author Nicolas Burroni
 * @since 3/28/2014
 */
public interface Queue {

	public void enQueue(Object obj);
	public Object deQueue();
	public boolean isEmpty();
	public int length();

}

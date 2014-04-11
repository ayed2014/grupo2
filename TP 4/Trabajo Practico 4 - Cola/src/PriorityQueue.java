

/**
 * @author Nicolas Burroni
 * @since 3/28/2014
 */
public interface PriorityQueue {

	public void enQueue(Prioritizable elem);
	public Prioritizable deQueue();
	public boolean isEmpty();
	public int length();

}

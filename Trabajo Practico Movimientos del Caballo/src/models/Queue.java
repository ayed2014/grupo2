package models;

/**
 * @author Nicolas Burroni
 * @since 3/28/2014
 */
public interface Queue {

	public void enQueue(Object obj);
	public Object deQueue();
	public boolean isEmpty();
	public int length();
	public Queue clone();
	public Object seeFront();
	public boolean exists(Object obj);

}

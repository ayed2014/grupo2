

/**
 * @author Nicolas Burroni
 * @since 3/28/2014
 */
public class QueueD implements Queue {

	private Nodo front, end;
	private int length;

	public QueueD(){
		front = new Nodo();
		end = front;
		length = 0;
	}

	public QueueD(Object initialObject){
		this();
		enQueue(initialObject);
	}

	@Override
	public void enQueue(Object obj) {
		end.obj = obj;
		end.next = new Nodo();
		end = end.next;
		length++;
	}

	@Override
	public Object deQueue() {
		if(isEmpty()) throw new IndexOutOfBoundsException("The queue is empty");
		Object deQueued = front.obj;
		front = front.next;
		length--;
		return deQueued;
	}

	@Override
	public boolean isEmpty() {
		return length == 0;
	}

	@Override
	public int length() {
		return length;
	}
}

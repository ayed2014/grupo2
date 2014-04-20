

/**
 * @author Nicolas Burroni
 * @since 3/28/2014
 */
public class QueueE implements Queue{

	private Object[] objects;
	private int front, end, length;

	public QueueE() {
		objects = new Object[10];
		front = 0;
		end = 0;
		length = 0;
	}

	public QueueE(Object initialObject){
		this();
		enQueue(initialObject);
	}

	@Override
	public void enQueue(Object obj) {
		if(front == end && length != 0) enlarge();
		objects[end] = obj;
		end = increment(end);
		length++;
	}

	@Override
	public Object deQueue() {
		if(isEmpty()) throw new IndexOutOfBoundsException("The queue is empty");
		Object deQueued = objects[front];
		front = increment(front);
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

	private int increment(int index){
		if(index == objects.length - 1) index = 0;
		else index++;
		return index;
	}

	private void enlarge(){
		Object[] enlarged = new Object[objects.length + 10];
		int i = 0;
		do{
			enlarged[i] = objects[front];
			i++;
			front = increment(front);
		} while(front != end);
		end = length;
		objects = enlarged;
	}
}

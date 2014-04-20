/**
 * @author Nicolas Burroni
 * @since 4/9/2014
 */
public class PriorityQueueD implements PriorityQueue {

	private PriorityNode front, end;
	private int length;

	public PriorityQueueD(){
		front = new PriorityNode();
		end = front;
		length = 0;
	}

	@Override
	public void enQueue(Prioritizable elem) {
		if(end == front) {
			end.obj = elem;
			end.next = new PriorityNode();
			end = end.next;
		}
		else if(elem.getPriority() < front.obj.getPriority()){
			front = new PriorityNode(elem, front);
		}
		else{
			PriorityNode aux = new PriorityNode(null, front);
			try {
				while (aux.next.obj.getPriority() <= elem.getPriority()) {
					aux = aux.next;
				}
			} catch (NullPointerException e){
				end.obj = elem;
				end.next = new PriorityNode();
				end = end.next;
			}
			aux.next = new PriorityNode(elem, aux.next);
		}
		length++;
	}

	@Override
	public Prioritizable deQueue() {
		if(isEmpty()) throw new IndexOutOfBoundsException("The queue is empty");
		Prioritizable deQueued = front.obj;
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

/**
 * @author Nicolas Burroni
 * @since 4/11/2014
 */
public class OrderedListD implements OrderedList {

	private ComparableNode head, window, sentinel;
	private int size;

	public OrderedListD(){
		head = new ComparableNode("Head");
		sentinel = new ComparableNode("Sentinel");
		head.next = sentinel;
		window = head;
		size = 0;
	}

	@Override
	public Comparable seeCurrent() {
		return window.obj;
	}


	@Override
	public void insert(Comparable elem) {
		window = head;
		try {
			while (window.next.obj.compareTo(elem) <= 0) {
				window = window.next;
			}
		} catch (NullPointerException ignored){}
		window.next = new ComparableNode(elem, window.next);
		window = window.next;
		size++;
	}

	@Override
	public void empty() {
		head = new ComparableNode("Head");
		window = head;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return head.next == sentinel;
	}

	@Override
	public void next() {
		if(window.next == sentinel) throw new IndexOutOfBoundsException("Reached the end of this List");
		window = window.next;
	}

	@Override
	public void previous() {
		if(window == head.next) throw new IndexOutOfBoundsException("Reached the beginning of this List");
		goBack();
	}

	private void goBack(){
		ComparableNode aux = head;
		while(window != aux.next){
			aux = aux.next;
		}
		window = aux;
	}

	@Override
	public void goTo(int index) {
		window = head.next;
		for(int i = 0; i < index; i++){
			window = window.next;
		}
	}

	@Override
	public void remove() {
		if(isEmpty()) throw new NullPointerException("This List is empty");
		goBack();
		window.next = window.next.next;
		window = window.next;
		if(window == sentinel) goBack();
		size--;
	}

	@Override
	public int size() {
		return size;
	}

}

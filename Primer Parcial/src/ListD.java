/**
 * @author Nicolas Burroni
 * @since 4/4/2014
 */
public class ListD implements List {

	private Nodo head, window, sentinel;
	private int size;

	public ListD(){
		head = new Nodo("Head");
		sentinel = new Nodo("Sentinel");
		head.next = sentinel;
		window = head;
		size = 0;
	}

	@Override
	public Object seeCurrent() {
		return window.obj;
	}

	@Override
	public void empty() {
		head = new Nodo();
		window = head;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return head.next == sentinel;
	}

	@Override
	public void addBefore(Object obj) {
		if (!isEmpty()) {
			goBack();
		}
		addAfter(obj);
	}

	@Override
	public void addAfter(Object obj) {
		window.next = new Nodo(obj, window.next);
		window = window.next;
		size++;
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
		Nodo aux = head;
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
	public void modify(Object obj) {
		if(isEmpty()) throw new NullPointerException("This List is empty");
		window.obj = obj;
	}

	@Override
	public int size() {
		return size;
	}
}

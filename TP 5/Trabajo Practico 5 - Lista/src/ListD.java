/**
 * @author Nicolas Burroni
 * @since 4/4/2014
 */
public class ListD implements List {

	private Nodo first, window;
	private int size;

	public ListD(){
		first = new Nodo();
		window = first;
		size = 0;
	}

	@Override
	public Object seeCurrent() {
		return window.obj;
	}

	@Override
	public void empty() {
		first = new Nodo();
		window = first;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return first.hasNoObj();
	}

	@Override
	public void addBefore(Object obj) {
		if(window == first) {
			first = new Nodo(obj, first);
			window = first;
		} else{
			previous();
			addAfter(obj);
		}
		size++;
	}

	@Override
	public void addAfter(Object obj) {
		window.next = new Nodo(obj, window.next);
		next();
		size++;
	}

	@Override
	public void next() {
		window = window.next;
	}

	@Override
	public void previous() {
		Nodo aux = first;
		while(window != aux.next){
			aux = aux.next;
		}
		window = aux;
	}

	@Override
	public void goTo(int index) {
		window = first;
		for(int i = 0; i < index; i++){
			window = window.next;
		}
	}

	@Override
	public void remove() {
		previous();
		window.next = window.next.next;
		next();
		size--;
	}

	@Override
	public void modify(Object obj) {
		if(isEmpty()) size++;
		window.obj = obj;
	}

	@Override
	public int size() {
		return size;
	}
}

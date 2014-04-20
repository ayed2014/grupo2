/**
 * @author Nicolas Burroni
 * @since 4/4/2014
 */
public class ListE implements List {

	private Object[] objects;
	private int window;
	private int size;

	public ListE() {
		objects = new Object[10];
		window = 0;
		size = 0;
	}

	@Override
	public Object seeCurrent() {
		if(isEmpty()) throw new NullPointerException("The list is empty");
		return objects[window];
	}

	@Override
	public void empty() {
		objects = new Object[10];
		window = 0;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return objects[0] == null;
	}

	@Override
	public void addBefore(Object obj) {
		if(size == objects.length) enlarge();
		for(int i = objects.length - 1; i > window; i--){
			objects[i] = objects[i-1];
		}
		objects[window] = obj;
		size++;
	}

	@Override
	public void addAfter(Object obj) {
		if(size == objects.length) enlarge();
		window++;
		addBefore(obj);
	}

	@Override
	public void next() {
		if(window == size - 1) throw new IndexOutOfBoundsException("Reached the end of the list");
		window++;
	}

	@Override
	public void previous() {
		if(window == 0) throw new IndexOutOfBoundsException("Reached the beginning of the list");
		window--;
	}

	@Override
	public void goTo(int index) {
		if(index < 0 || index >= objects.length) throw new IndexOutOfBoundsException("There is no such index in this list");
		window = index;
	}

	@Override
	public void remove() {
		for(int i = window; i < objects.length - 1; i++){
			objects[i] = objects[i+1];
		}
		size--;
		if(window >= size) window = size - 1;
	}

	@Override
	public void modify(Object obj) {
		if(isEmpty()) size++;
		objects[window] = obj;
	}

	@Override
	public int size() {
		return size;
	}

	private void enlarge(){
		Object[] tempObjects = new Object[objects.length + 10];
		for (int i = 0; i < objects.length; i++) tempObjects[i] = objects[i];
		objects = tempObjects;
	}
}

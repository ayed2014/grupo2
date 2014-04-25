
/**
 * @author Nicolas Burroni
 * @since 3/14/14
 */
public class StackE implements Stack {

	protected Object[] objects;
	private int top;

	public StackE(){
		objects = new Object[10];
		for (int i = 0; i < objects.length; i++) {
			objects[i] = new Object();
		}
		top = 0;
	}

	public void push(Object obj){
		if(top == objects.length){
			enlargeStack();
		}
		objects[top] = obj;
		top++;
	}

	private void enlargeStack(){
		Object[] tempObjects = new Object[objects.length + 10];
		for (int i = 0; i < objects.length; i++) tempObjects[i] = objects[i];
		for (int i = top; i < objects.length; i++) {
			objects[i] = new Object();
		}
		objects = tempObjects;
	}

	public void pop(){
		if(top == 0) throw new IndexOutOfBoundsException("The pila is empty!");
		top--;
	}

	public Object seeTop(){
		if(top == 0) throw new IndexOutOfBoundsException("The pila is empty!");
		return objects[top - 1];
	}

	public boolean isEmpty(){
		return top == 0;
	}

	public void emptyStack(){
		top = 0;
	}

}

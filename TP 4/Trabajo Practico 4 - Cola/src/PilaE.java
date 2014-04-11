/**
 * @author Nicolas Burroni
 * @since 3/14/14
 */
public class PilaE implements Pila{

	private Object[] objects;
	private int top;

	public PilaE(){
		objects = new Object[10];
		for (int i = 0; i < objects.length; i++) {
			objects[i] = new Object();
		}
		top = 0;
	}

	public void apilar(Object obj){
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

	public void desapilar(){
		if(top == 0) throw new IndexOutOfBoundsException("The objects is empty!");
		top--;
	}

	public Object verTope(){
		return objects[top - 1];
	}

	public boolean esVacia(){
		return top == 0;
	}

	public void vaciar(){
		top = 0;
	}

}

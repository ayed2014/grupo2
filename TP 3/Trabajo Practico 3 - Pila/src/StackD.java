/**
 * @author Nicolas Burroni
 * @since 3/21/14
 */
public class StackD implements Stack {

	private Nodo tope;

	public StackD(){
		emptyStack();
	}

	@Override
	public void push(Object obj) {
		if(tope.hasNoObj()){
			tope.dato = obj;
		}
		else tope = new Nodo(obj, tope);
	}

	@Override
	public void pop() {
		if(isEmpty()) throw new IndexOutOfBoundsException("The pila is empty!");
		if(tope.sig == null) emptyStack();
		else tope = tope.sig;
	}

	@Override
	public Object seeTop() {
		if(isEmpty()) throw new IndexOutOfBoundsException("The pila is empty!");
		return tope.dato;
	}

	@Override
	public boolean isEmpty() {
		return tope.hasNoObj();
	}

	@Override
	public void emptyStack() {
		tope = new Nodo();
	}
}

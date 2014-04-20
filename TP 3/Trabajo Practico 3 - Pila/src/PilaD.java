/**
 * @author Nicolas Burroni
 * @since 3/21/14
 */
public class PilaD implements Pila {

	private Nodo tope;

	public PilaD(){
		vaciar();
	}

	@Override
	public void apilar(Object obj) {
		if(tope.hasNoObj()){
			tope.dato = obj;
		}
		else tope = new Nodo(obj, tope);
	}

	@Override
	public void desapilar() {
		if(esVacia()) throw new IndexOutOfBoundsException("The pila is empty!");
		if(tope.sig == null) vaciar();
		else tope = tope.sig;
	}

	@Override
	public Object verTope() {
		if(esVacia()) throw new IndexOutOfBoundsException("The pila is empty!");
		return tope.dato;
	}

	@Override
	public boolean esVacia() {
		return tope.hasNoObj();
	}

	@Override
	public void vaciar() {
		tope = new Nodo();
	}
}

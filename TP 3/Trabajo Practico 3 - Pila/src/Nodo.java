/**
 * @author Nicolas Burroni
 * @since 3/21/14
 */
public class Nodo {

	public Object dato;
	public Nodo sig;

	public Nodo(){
		dato = null;
	    sig = null;
	}

	public Nodo(Object o){
		dato = o;
		sig = null;
	}

	public Nodo(Object o, Nodo sig){
		this(o);
		this.sig = sig;
	}

	public boolean hasNoObj(){
		return dato == null;
	}
}

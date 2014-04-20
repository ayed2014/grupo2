/**
 * @author Nicolas Burroni
 * @since 3/21/14
 */
public class Nodo {

	public Object obj;
	public Nodo next;

	public Nodo(){
		obj = null;
		next = null;
	}

	public Nodo(Object o){
		obj = o;
		next = null;
	}

	public Nodo(Object o, Nodo next){
		this(o);
		this.next = next;
	}

	public boolean hasNoObj(){
		return obj == null;
	}
}

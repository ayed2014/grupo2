/**
 * @author Nicolas Burroni
 * @since 3/21/14
 */
public class ListaD implements Lista{

	private Nodo initial;

	public ListaD(){
		initial = new Nodo();
	}

	public ListaD(Object initialObject){
		initial = new Nodo(initialObject);
	}

	@Override
	public void agregar(Object o) {
		if(initial.hasNoObj()) initial.dato = o;
		else initial.sig = new Nodo(o);
	}

	@Override
	public Object quitar(int index) {
		if(index == 0) {
			Object o = initial.dato;
			initial = initial.sig;
			return o;
		}
		int count = 0;

		Nodo n = initial;
		while(n != null){
			if(count == index - 1) {
				Object o = n.sig.dato;
				n.sig = n.sig.sig;
				return o;
			}
			count++;
			n = n.sig;
		}

		throw new IndexOutOfBoundsException();
	}

	@Override
	public int longitud() {
		int count = 0;

		Nodo n = initial;
		while(n != null){
			count++;
			n = n.sig;
		}

		return count;
	}

	@Override
	public void vaciar() {
		initial = new Nodo();
	}

	@Override
	public Object ver(int index) {
		int count = 0;

		Nodo n = initial;
		while(n != null){
			if(count == index) return n.dato;
			count++;
			n = n.sig;
		}

		throw new IndexOutOfBoundsException();
	}
}

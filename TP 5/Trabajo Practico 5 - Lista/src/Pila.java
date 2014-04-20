/**
 * @author Nicolas Burroni
 * @since 3/14/14
 */
public interface Pila {

	public void apilar(Object obj);
	public void desapilar();
	public Object verTope();
	public boolean esVacia();
	public void vaciar();

}

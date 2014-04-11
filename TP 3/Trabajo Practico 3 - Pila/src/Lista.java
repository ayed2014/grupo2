/**
 * @author Nicolas Burroni
 * @since 3/21/14
 */
public interface Lista {

	public void agregar(Object o);
	public Object quitar(int index);
	public int longitud();
	public void vaciar();
	public Object ver(int index);

}

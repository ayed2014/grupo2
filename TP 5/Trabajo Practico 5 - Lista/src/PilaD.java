
/**
 * Created with IntelliJ IDEA.
 * User: alumnosfi
 * Date: 21/03/14
 * Time: 10:24
 * To change this template use File | Settings | File Templates.
 */
public class PilaD implements Pila {
    private Nodo nodo;
    private int longitud;

    public PilaD(Object o) {
        nodo = new Nodo(o);
        longitud = 1;
    }


    @Override
    public Object verTope() {
        return nodo.obj;
    }

    @Override
    public void apilar(Object o) {
        Nodo aux = new Nodo(o);
        aux.next = nodo;
        nodo = aux;
        longitud++;
    }

    @Override
    public void desapilar() {
        nodo = nodo.next;
        longitud--;
    }

    @Override
    public void vaciar() {
        nodo = new Nodo();
        longitud = 0;
    }

    @Override
    public boolean esVacia() {
        return (longitud == 0);
    }
}

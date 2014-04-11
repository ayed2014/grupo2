/**
 * @author Nicolas Burroni
 * @since 3/21/14
 */
public class TestLista {
	public static void main(String[] args) {
		Lista lista = new ListaD("Nico");
		lista.agregar("Crack");
		lista.agregar("Crack");
		lista.agregar("Crack");
		lista.agregar("Que sos");
		lista.agregar("Que sos");
		lista.agregar("Que sos");
		lista.agregar("Que sos");
		System.out.println(lista.longitud());
		for(int i = 0; i < lista.longitud(); i++) System.out.println(lista.ver(i));
		lista.quitar(0);
		System.out.println("");
		for(int i = 0; i < lista.longitud(); i++) System.out.println(lista.ver(i));
	}
}

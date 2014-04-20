/**
 * @author Nicolas Burroni
 * @since 3/21/14
 */
public class Test2 {
	public static void main(String[] args) {
		Nodo n3 = new Nodo(2),
				n2 = new Nodo(8, n3),
				n1 = new Nodo(3, n2),
				n0 = new Nodo(5, n1);

		System.out.println(n0.dato);
		System.out.println(n1.dato);
		System.out.println(n2.dato);
		System.out.println(n3.dato);
		System.out.println("");

		Nodo n = n0;
		while(n != null){
			System.out.println(n.dato);
			n = n.sig;
		}

	}
}

/**
 * @author Nicolas Burroni
 * @since 3/21/14
 */
public class TestPilaD {

	public static void main(String[] args) {
		Pila pila = new PilaD();
		pila.apilar("Nico1");
		pila.apilar("Nico2");
		pila.apilar("Nico3");
		pila.apilar("Nico4");
		pila.apilar("Nico5");
		pila.apilar("Nico6");
		System.out.println(pila.verTope());
		pila.desapilar();
		System.out.println(pila.verTope());
		pila.desapilar();
		System.out.println(pila.verTope());
		pila.desapilar();
		System.out.println(pila.verTope());
		pila.desapilar();
		System.out.println(pila.verTope());
		pila.desapilar();
		System.out.println(pila.verTope() + "" + pila.esVacia());
		pila.desapilar();
		System.out.println(pila.esVacia());
	}

}

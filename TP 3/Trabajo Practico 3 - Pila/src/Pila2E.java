/**
 * @author Nicolas Burroni
 * @since 3/21/14
 */
public class Pila2E extends PilaE {

	public Object verYDesapilar(){
		Object o = verTope();
		desapilar();
		return o;
	}

	public Object[] toArray(){
		return objects.clone();
	}

	public void invert(){
		Object[] objects1 = toArray();
		vaciar();
		for(int i = objects1.length - 1; i >= 0; i--){
			apilar(objects1[i]);
		}
	}
}

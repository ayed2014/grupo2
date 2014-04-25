/**
 * @author Nicolas Burroni
 * @since 3/21/14
 */
public class Stack2E extends StackE {

	public Object verYDesapilar(){
		Object o = seeTop();
		pop();
		return o;
	}

	public Object[] toArray(){
		return objects.clone();
	}

	public void invert(){
		Object[] objects1 = toArray();
		emptyStack();
		for(int i = objects1.length - 1; i >= 0; i--){
			push(objects1[i]);
		}
	}
}

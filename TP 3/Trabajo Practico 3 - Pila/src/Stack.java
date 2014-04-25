
/**
 * @author Nicolas Burroni
 * @since 3/14/14
 */
public interface Stack {

	public void push(Object obj);
	public void pop();
	public Object seeTop();
	public boolean isEmpty();
	public void emptyStack();

}

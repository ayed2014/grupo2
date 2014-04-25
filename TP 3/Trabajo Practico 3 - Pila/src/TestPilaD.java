/**
 * @author Nicolas Burroni
 * @since 3/21/14
 */
public class TestPilaD {

	public static void main(String[] args) {
		Stack stack = new StackD();
		stack.push("Nico1");
		stack.push("Nico2");
		stack.push("Nico3");
		stack.push("Nico4");
		stack.push("Nico5");
		stack.push("Nico6");
		System.out.println(stack.seeTop());
		stack.pop();
		System.out.println(stack.seeTop());
		stack.pop();
		System.out.println(stack.seeTop());
		stack.pop();
		System.out.println(stack.seeTop());
		stack.pop();
		System.out.println(stack.seeTop());
		stack.pop();
		System.out.println(stack.seeTop() + "" + stack.isEmpty());
		stack.pop();
		System.out.println(stack.isEmpty());
	}

}

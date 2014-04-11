/**
 * @author Nicolas Burroni
 * @since 4/9/2014
 */
public class Test {
	public static void main(String[] args) {
		//System.out.println(Palindrome.isPalindrome("NeuqUen menem neuquen"));
		PriorityQueue queue = new PriorityQueueD();
		queue.enQueue(new VIP(5));
		queue.enQueue(new VIP(2));
		queue.enQueue(new VIP(4));
		queue.enQueue(new VIP(3));
		queue.enQueue(new VIP(5));
		queue.enQueue(new VIP(1));
		queue.enQueue(new VIP(1));
		queue.enQueue(new VIP(2));
		while(!queue.isEmpty()){
			System.out.println(queue.deQueue());
		}
	}

	static class VIP implements Prioritizable{
		int priority;

		VIP(int priority) {
			this.priority = priority;
		}

		@Override
		public int getPriority() {
			return priority;
		}

		public String toString(){
			return "" + priority;
		}
	}
}

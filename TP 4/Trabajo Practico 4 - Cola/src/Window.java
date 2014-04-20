import java.util.Random;

/**
 * Created by Francisco on 10/04/14.
 */
public class Window {
	private int minTime;
	private int maxTime;
	private QueueE queue;
	private Customer currentCustomer;

	public Window(int minTime, int maxTime) {
		this.minTime = minTime;
		this.maxTime = maxTime;
		queue = new QueueE();
	}

	public void addToQueue(Customer c) {
		queue.enQueue(c);
		c.setWaitTime(generateWaitTime());
	}

	public void attend() {
		if (!isEmpty()) {
			if (currentCustomer == null) currentCustomer = (Customer) queue.deQueue();
			if (currentCustomer.attend()) currentCustomer = (Customer) queue.deQueue();
		}
	}

	public int generateWaitTime() {
		Random r = new Random();
		return r.nextInt(maxTime - minTime) + minTime;

	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}
}

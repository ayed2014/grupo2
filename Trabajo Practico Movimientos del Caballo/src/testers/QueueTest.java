package testers;

import models.Queue;
import models.QueueD;

/**
 * @author Nicolas Burroni
 * @since 6/13/2014
 */
public class QueueTest {
	public static void main(String[] args) {
		Queue q1 = new QueueD();
		for (int i = 0; i < 6; i++) {
			q1.enQueue(i);
		}
		Queue q2 = q1.clone();
		while(!q1.isEmpty()){
			System.out.println(q1.deQueue());
		}
		while(!q2.isEmpty()){
			System.out.println(q2.deQueue());
		}
	}
}

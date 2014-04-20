/**
 * Created by Francisco on 10/04/14.
 */
public class Customer {
	private int waitTime;
	private int beenWaiting;

	public Customer() {
		beenWaiting = 0;
	}

	public boolean attend() {
		if (waitTime <= beenWaiting) return true;
		else beenWaiting = beenWaiting + 30;
		return false;
	}

	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}
}

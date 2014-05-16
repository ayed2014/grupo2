/**
 * @author Nicolas Burroni
 * @since 4/25/2014
 */
public class Car implements Comparable{

	private int timeEnteredQueue, timeLeftQueue, totalQueueWaitTime, totalTimeInCampus;

	public Car() {
		timeEnteredQueue = 0;
		timeLeftQueue = 0;
		totalQueueWaitTime = 0;
		totalTimeInCampus = 0;
	}

	public void enterQueue(int timeEntered){
		timeEnteredQueue = timeEntered;
	}

	public void leaveQueue(int timeLeft){
		timeLeftQueue = timeLeft;
		totalQueueWaitTime = timeLeftQueue - timeEnteredQueue;
	}

	public void leaveCampus(int timeLeft){
		totalTimeInCampus = timeLeft - timeLeftQueue;
	}

	public int getTotalQueueWaitTime() {
		return totalQueueWaitTime;
	}

	public int getTotalTimeInCampus() {
		return totalTimeInCampus;
	}

	@Override
	public int compareTo(Object o) {
		if (totalQueueWaitTime > ((Car) o).getTotalQueueWaitTime())
			return 1;
		else if (totalQueueWaitTime == ((Car) o).getTotalQueueWaitTime())
			return 0;
		else
			return -1;
	}
}

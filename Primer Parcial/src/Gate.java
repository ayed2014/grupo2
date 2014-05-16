/**
 * @author Nicolas Burroni
 * @since 4/25/2014
 */
public class Gate {

	private Queue carQueue;
	private boolean enabled;
	private int lastTimeEnabled, totalTimeEnabled, carCount;

	public Gate(){
		carQueue = new QueueD();
		enabled = false;
		lastTimeEnabled = 0;
		totalTimeEnabled = 0;
		carCount = 0;
	}

	public void enQueueCar(Car car, int timeEntered){
		carQueue.enQueue(car);
		car.enterQueue(timeEntered);
	}

	public Car releaseCar(int timeReleased){
		Car carReleased = (Car) carQueue.deQueue();
		carReleased.leaveQueue(timeReleased);
		carCount++;
		return carReleased;
	}

	public void enable(int timeEnabled){
		enabled = true;
		lastTimeEnabled = timeEnabled;
	}

	public void disable(int timeDisabled){
		enabled = false;
		totalTimeEnabled += (timeDisabled - lastTimeEnabled);
	}

	public boolean isEnabled() {
		return enabled;
	}

	public int getQueueLength(){
		return carQueue.length();
	}

	public boolean isEmpty(){
		return carQueue.isEmpty();
	}

	public int getTotalTimeEnabled() {
		return totalTimeEnabled;
	}

	public int getCarCount() {
		return carCount;
	}

}

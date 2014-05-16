import java.util.Random;

/**
 * @author Nicolas Burroni
 * @since 4/25/2014
 */
public class CampusParkingLot {

	private List parkedCars;
	private int maxParkedCars, timeOfPeak, totalParkedTime, carsLeft;
	private OrderedList maxStayTimes;

	public CampusParkingLot(){
		parkedCars = new ListD();
		maxParkedCars = 0;
		timeOfPeak = 0;
		totalParkedTime = 0;
		carsLeft = 0;
		maxStayTimes = new OrderedListD();
	}

	public void enterCar(Car car, int timeEntered){
		parkedCars.addAfter(car);
		int numberOfCars = parkedCars.size();
		if(numberOfCars > maxParkedCars) {
			maxParkedCars = numberOfCars;
			timeOfPeak = timeEntered;
		}
	}

	public Car releaseCar(int timeLeft){
		parkedCars.goTo((new Random()).nextInt(parkedCars.size()));
		Car carToLeave = (Car) parkedCars.seeCurrent();
		parkedCars.remove();
		carToLeave.leaveCampus(timeLeft);
		totalParkedTime += carToLeave.getTotalTimeInCampus();
		carsLeft++;
		maxStayTimes.insert(new StayTime(carToLeave.getTotalTimeInCampus()));
		return carToLeave;
	}

	public int getAverageStayTime(){
		int avg = 0;
		try {
			avg = totalParkedTime/ carsLeft;
		} catch (ArithmeticException ignored) {}
		return avg;
	}

	public int getMaxParkedCars() {
		return maxParkedCars;
	}

	public int getTimeOfPeak() {
		return timeOfPeak;
	}

	public OrderedList getMaxStayTimes() {
		return maxStayTimes;
	}

	public class StayTime implements Comparable{

		private int totalStayTime;

		StayTime(int totalStayTime) {
			this.totalStayTime = totalStayTime;
		}

		@Override
		public int compareTo(Object o) {
			if (totalStayTime > ((StayTime) o).getTotalStayTime())
				return 1;
			else if (totalStayTime == ((StayTime) o).getTotalStayTime())
				return 0;
			else
				return -1;
		}

		public int getTotalStayTime() {
			return totalStayTime;
		}
	}
}

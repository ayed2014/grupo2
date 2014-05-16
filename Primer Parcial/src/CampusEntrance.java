import java.util.Random;
import java.util.Scanner;

/**
 * @author Nicolas Burroni
 * @since 4/25/2014
 */
public class CampusEntrance {

	private List entranceGates;
	private Gate exitGate;
	private CampusParkingLot campusParkingLot;
	private int currentTime;
	private OrderedList maxWaitTimes;

	public CampusEntrance() {
		entranceGates = new ListD();
		for(int i = 0; i < 4; i++) entranceGates.addAfter(new Gate());
		entranceGates.goTo(0);
		((Gate) entranceGates.seeCurrent()).enable(0);
		currentTime = 0;
		maxWaitTimes = new OrderedListD();
		campusParkingLot = new CampusParkingLot();
		exitGate = new Gate();
		exitGate.enable(0);
	}

	public void simulateParkingLot(){
		System.out.println("** Welcome to the Campus Parking Lot simulator **");
		while(menuChoice() == 1){
			carsArrive();
			carLeavesCampus();
			carsEnterCampus();
			disableEmptyGates();
			currentTime += 30;
		}
		printReport();
	}

	private int menuChoice(){
		System.out.print("1.\tAdvance\n2.\tEnd\nEnter your choice: ");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	private void carsArrive(){
		for(int i = 0; i < 3; i++){
			entranceGates.goTo(0);
			Car carToEnter = new Car();
			int gateWithLessCars = 0;
			int lessAmountOfCars = ((Gate) entranceGates.seeCurrent()).getQueueLength();
			for(int j = 0; j < entranceGates.size(); j++){
				entranceGates.goTo(j);
				Gate currentGate = (Gate) entranceGates.seeCurrent();
				if(!currentGate.isEnabled()) break;   //If the gate is not enabled, stop looking
				if(currentGate.getQueueLength() <= lessAmountOfCars) {
					gateWithLessCars = j;
					lessAmountOfCars = ((Gate) entranceGates.seeCurrent()).getQueueLength();
				}
			}
			entranceGates.goTo(gateWithLessCars);
			if(((Gate) entranceGates.seeCurrent()).getQueueLength() == 10){
				try {
					enableNextGate();
				} catch (IndexOutOfBoundsException e) {
					openAllGates();
					entranceGates.goTo(0);
				}
			}
			((Gate) entranceGates.seeCurrent()).enQueueCar(carToEnter, currentTime);
		}
	}

	private void enableNextGate() throws IndexOutOfBoundsException{
		entranceGates.next();
		((Gate) entranceGates.seeCurrent()).enable(currentTime);
	}

	private void openAllGates(){
		for(int i = 0; i < entranceGates.size(); i++){
			entranceGates.goTo(i);
			Gate currentGate = (Gate) entranceGates.seeCurrent();
			while(!currentGate.isEmpty()){
				Car carDeQueued = currentGate.releaseCar(currentTime);
				maxWaitTimes.insert(carDeQueued);
			}
		}
		for(int i = 1; i < entranceGates.size(); i++){
			entranceGates.goTo(i);
			((Gate) entranceGates.seeCurrent()).disable(currentTime);
		}
	}

	private void carLeavesCampus(){
		int random = (new Random()).nextInt(100);
		int probability = 5;
		if(currentTime >= 14400) probability = 70;
		if(random < probability){
			exitGate.enQueueCar(campusParkingLot.releaseCar(currentTime), currentTime);
		}
		if (!exitGate.isEmpty()) {
			probability = 80;
			if(random < probability){
				exitGate.releaseCar(currentTime);
			}
		}
	}

	private void carsEnterCampus(){
		entranceGates.goTo(0);
		for(int i = 0; i < entranceGates.size(); i++){
			entranceGates.goTo(i);
			Gate currentGate = (Gate) entranceGates.seeCurrent();
			if(!currentGate.isEnabled()) continue;  //If the gate is not enabled, continue to the next gate
			int random = (new Random()).nextInt(100);
			int probability = 80;
			if(random < probability){
				carEntersCampus();
			}
		}
	}

	private void carEntersCampus(){
		Car carDeQueued = ((Gate) entranceGates.seeCurrent()).releaseCar(currentTime);
		campusParkingLot.enterCar(carDeQueued, currentTime);
		maxWaitTimes.insert(carDeQueued);
	}

	private void disableEmptyGates(){
		for(int i = 1; i < entranceGates.size(); i++){
			entranceGates.goTo(i);
			Gate currentGate = (Gate) entranceGates.seeCurrent();
			if(currentGate.isEmpty()) currentGate.disable(currentTime);
		}
	}

	private void printReport(){
		for(int i = 1; i < entranceGates.size(); i++){
			entranceGates.goTo(i);
			Gate currentGate = (Gate) entranceGates.seeCurrent();
			System.out.println("Gate number " + (i+1) + " was enabled for " +
					currentGate.getTotalTimeEnabled() + " seconds.");
		}
		System.out.println("The average stay time in the campus parking lot is " + campusParkingLot.getAverageStayTime() +
				" seconds.");
		System.out.print("The five cars that stayed the longest parked stayed for: ");
		OrderedList maxStayTimes = campusParkingLot.getMaxStayTimes();
		for(int i = 0; i < 5; i++) {
			maxStayTimes.goTo(i);
			try {
				System.out.print(((CampusParkingLot.StayTime) maxStayTimes.seeCurrent()).getTotalStayTime() + ", "); //Si esto tira excepcion que la lista esta vacia, es porque no salieron suficientes autos del campus
			} catch (NullPointerException e) {
				break;
			}
		}
		System.out.println("seconds respectively.");
		for(int i = 0; i < entranceGates.size(); i++){
			entranceGates.goTo(i);
			Gate currentGate = (Gate) entranceGates.seeCurrent();
			System.out.println(currentGate.getCarCount() + " cars entered the campus through gate number " + (i+1));
		}
		System.out.print("The five cars that waited the longest in the queue waited for: ");
		for(int i = 0; i < 5; i++) {
			maxWaitTimes.goTo(i);
			System.out.print(((Car) maxWaitTimes.seeCurrent()).getTotalQueueWaitTime() + ", ");
		}
		System.out.println("seconds respectively.");
		System.out.println("The maximum amount of parked cars was " + campusParkingLot.getMaxParkedCars() + " cars, at " +
				campusParkingLot.getTimeOfPeak() + " seconds of the simulation.");
	}

}

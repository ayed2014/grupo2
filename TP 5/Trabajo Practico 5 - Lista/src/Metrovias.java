import java.util.Random;

/**
 * @author Nicolas Burroni
 * @since 4/11/2014
 */
public class Metrovias {
	private List windows;
	private int currentTime;
	private int closingTime;

	public Metrovias(int windows) {
		this.windows = new ListD();
		currentTime = 0;
		closingTime = 57570;
		for (int i = 0; i < windows; i++) this.windows.addAfter(new Window());
	}

	public void simulate() {
		for (; currentTime < closingTime; currentTime += 10){
			generateCustomers();
			attend();
		}
		for (int i=0; i <windows.size(); i++){
			windows.goTo(i);
			Window w = (Window) windows.seeCurrent();
			w.causeMayhem(currentTime);
		}
	}

	public void generateCustomers() {
		for (int i = 0; i < 5; i++) {
			Customer c = new Customer(currentTime);
			sortCustomer(c);
		}
	}

	public void sortCustomer(Customer c) {
		Random r = new Random();
		int chosenWindow = r.nextInt(windows.size());
		windows.goTo(chosenWindow);
		Window w = (Window) windows.seeCurrent();
		w.addCustomer(c);
	}

	public void attend(){
		for (int i=0; i <windows.size(); i++){
			windows.goTo(i);
			Window w = (Window) windows.seeCurrent();
			w.attend(currentTime);
		}
	}

	public double getAverageWaitTime(){
		int sum = 0;
		for (int i=0; i <windows.size(); i++){
			windows.goTo(i);
			Window w = (Window) windows.seeCurrent();
			sum += w.getAverageWaitTime();
		}
		return sum/windows.size();
	}

	public double getTotalEarnings(){
		double sum = 0;
		for (int i=0; i <windows.size(); i++){
			windows.goTo(i);
			Window w = (Window) windows.seeCurrent();
			sum += w.getMoney();
		}
		return sum;
	}

	public int[] getIdleTimes(){
		int idleTimes[] = new int[windows.size()];
		for (int i=0; i <windows.size(); i++){
			windows.goTo(i);
			Window w = (Window) windows.seeCurrent();
			idleTimes[i] = w.getIdleTime();
		}
		return idleTimes;
	}

}

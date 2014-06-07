/**
 * @author Nicolas Burroni
 * @since 6/4/2014
 */
public class BusSystem {

	private OrderedList busList;

	public BusSystem(){
		busList = new OrderedListD();
	}

	public void runSystemMenu(){
		System.out.println("**Welcome to the Bus System**");
		boolean keepGoing = true;
		while (keepGoing) {
			System.out.println(	"\n1.\tAdd Bus\n" +
					"2.\tRemove Bus\n" +
					"3.\tPrint Report\n" +
					"4.\tShow buses apt for disabled\n" +
					"5.\tShow buses with more than 27 seats\n" +
					"6.\tSave\n" +
					"7.\tLoad");
			int choice = Scanner.getInt("Enter your choice: ", "Please enter a valid choice! ");
			switch(choice){
				case 1: addBus();
					break;
				case 2: removeBus();
					break;
				case 3: printReport();
					break;
				case 4: showAptForDisabled();
					break;
				case 5: showWithMoreSeatsThan(27);
					break;
				case 6: save();
					break;
				case 7: load();
					break;
				default: keepGoing = false;
					break;
			}
		}
	}

	public void addBus(){
		System.out.println("Enter bus information");
		int line = Scanner.getInt("Line: ", "Please enter a valid line number! ");
		int intern = Scanner.getInt("Intern: ", "Please enter a valid intern number! ");
		int seats = Scanner.getInt("Seats: ", "Please enter a valid amount of seats! ");
		char[] allowed = {'y', 'n', 'Y', 'N'};
		boolean aptForDisabled = Character.toLowerCase(
				Scanner.getChar("Is it apt for disabled?: ", "Please enter yes or no! ", allowed)) == 'y';
		busList.insert(new Bus(line, intern, seats, aptForDisabled));
		System.out.println("\nSuccessfully added " + busList.seeCurrent());
		busList.goTo(0);
	}

	public void removeBus(){
		printReport();
		int[] allowed = new int[busList.size()];
		for (int i = 0; i <= allowed.length; i++) allowed[i] = i;
		int choice = Scanner.getInt("Which bus would you like to remove? (Enter 0 to cancel): ", "Please enter a valid choice", allowed);
		if(choice == 0) return;
		busList.goTo(choice - 1);
		busList.remove();
		busList.goTo(0);
	}

	public void printReport(){
		int line = -1;
		for (int i = 0; i < busList.size(); i++) {
			busList.goTo(i);
			int currentLine = ((Bus) busList.seeCurrent()).getLine();
			if(currentLine != line){
				line = currentLine;
				System.out.println("Line " + line);
			}
			int n = i+1;
			System.out.println("\t" + n + ".\t" + busList.seeCurrent().toString() + "");
		}
		busList.goTo(0);
	}

	public void showAptForDisabled(){

	}

}

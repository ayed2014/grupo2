/**
 * @author Nicolas Burroni
 * @since 6/4/2014
 */
public class Bus implements Comparable{

	private int line, intern, seats;
	private boolean aptForDisabled;

	public Bus(int line, int intern, int seats, boolean aptForDisabled) {
		this.line = line;
		this.intern = intern;
		this.seats = seats;
		this.aptForDisabled = aptForDisabled;
	}

	@Override
	public int compareTo(Object o) {
		int oLine = ((Bus) o).line;
		if(line > oLine){
			return 1;
		} else if (line < oLine){
			return -1;
		} else {
			return 0;
		}
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getIntern() {
		return intern;
	}

	public void setIntern(int intern) {
		this.intern = intern;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public boolean isAptForDisabled() {
		return aptForDisabled;
	}

	public void setAptForDisabled(boolean aptForDisabled) {
		this.aptForDisabled = aptForDisabled;
	}

	@Override
	public String toString() {
		return "Bus{" +
				"line: " + line +
				", intern: " + intern +
				", seats: " + seats +
				", aptForDisabled: " + aptForDisabled +
				'}';
	}
}

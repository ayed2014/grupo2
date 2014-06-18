package models;

/**
 * @author Nicolas Burroni
 * @since 6/13/2014
 */
public class KnightMoves {

	private Queue[] movesQueues;
	private String currentPosition;
	private int currentQueue;

	private final boolean DEBUG = true;

	public KnightMoves(){
		movesQueues = new Queue[4];
		for (int i = 0; i < movesQueues.length; i++) {
			movesQueues[i] = new QueueD();
		}
		currentPosition = "A1";
		currentQueue = -1;
	}

	/**
	 * Generates the next move for the Knight. It returns true if there are moves left, and
	 * false if it has made them all.
	 * @return true if there are still moves left, false otherwise.
	 */
	public boolean nextMove(){
		if(fillQueue(currentQueue + 1)) currentQueue++;
		else movesQueues[currentQueue].deQueue();
		while(movesQueues[currentQueue].isEmpty()){ //Check if the current queue is empty to go back a queue
			currentQueue--;
			if(currentQueue < 0) return false; //No more possible moves remain
			movesQueues[currentQueue].deQueue();
		}
		currentPosition = (String) movesQueues[currentQueue].seeFront();
		return true; //Possible moves remain
	}

	public boolean fillQueue(int index){
		if(index >= movesQueues.length) return false;
		if(DEBUG) System.out.println("**" + currentPosition + "**");
		int i = (int) currentPosition.charAt(0);
		int j = Integer.parseInt(currentPosition.substring(1));
		Queue nextQueue = movesQueues[index];
		String[] possibleMoves = {
				((char) (i - 1)) + "" + (j - 2),
				((char) (i - 2)) + "" + (j - 1),
				((char) (i - 2)) + "" + (j + 1),
				((char) (i - 1)) + "" + (j + 2),
				((char) (i + 1)) + "" + (j + 2),
				((char) (i + 2)) + "" + (j + 1),
				((char) (i + 2)) + "" + (j - 1),
				((char) (i + 1)) + "" + (j - 2)
		};
	    for(String move : possibleMoves){
		    i = (int) move.charAt(0);
		    j = Integer.parseInt(move.substring(1));
		    if((!(i < 65 || j < 1 || i > 72 || j > 8)) && !hasBeenQueued(move)) {
			    nextQueue.enQueue(move);
			    if(DEBUG) System.out.println(move);
		    }
	    }
		return true;
	}

	private boolean hasBeenQueued(String move){
		if(move.equals("A1")) return true;
		for (Queue movesQueue : movesQueues) {
			if(!movesQueue.isEmpty() && movesQueue.seeFront().equals(move)) return true;
		}
		return false;
	}

	public String getCurrentPosition() {
		return currentPosition;
	}

	public int getMoveNumber(){
		return currentQueue + 1;
	}

	public Queue[] getMovesQueues(){
		Queue[] q = {movesQueues[0].clone(), movesQueues[1].clone(), movesQueues[2].clone(), movesQueues[3].clone()};
		return q;
	}
}

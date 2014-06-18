package controllers;

import models.KnightMoves;
import models.Queue;
import views.MovesView;

import javax.swing.*;

/**
 * Created by Francisco on 6/17/2014.
 */
public class KnightMovesController {
    private MovesView movesView;
    private KnightMoves knightMoves;

    public KnightMovesController() {
        knightMoves = new KnightMoves();
        movesView = new MovesView(e -> nextMove());
	    movesView.highlightPosition(1, 1, 0);
	    movesView.setVisible(true);
	    movesView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * First unhighlights the current position, then does the next move and distributes the queues, then
     * highlights the new current position
     */
    public void nextMove() {
        String currentPosition = knightMoves.getCurrentPosition();
        movesView.unhighlightAll();
	    movesView.highlightPosition(1, 1, 0);
        if(!knightMoves.nextMove()) {
	        JOptionPane.showMessageDialog(new JFrame("Reached the end!"), "Congratulations, you've made it to the end!");
	        movesView.dispose();
	        knightMoves = new KnightMoves();
	        movesView = new MovesView(e -> nextMove());
	        movesView.highlightPosition(1, 1, 0);
	        movesView.setVisible(true);
	        movesView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        return;
        }
        Queue[] movesQueues = knightMoves.getMovesQueues();
        currentPosition = knightMoves.getCurrentPosition();
        movesView.removeAllMoves();
        for (int i = 0; i < movesQueues.length; i++) {
            Queue currentQueue = movesQueues[i];
            while (!currentQueue.isEmpty()) movesView.addMove(i, (String) currentQueue.deQueue());
        }
	    movesQueues = knightMoves.getMovesQueues();
	    for (int i = 0; i < knightMoves.getMoveNumber() - 1; i++) {
		    if(!movesQueues[i].isEmpty()) movesView.highlightPosition(((String)movesQueues[i].seeFront()).charAt(0) - 64, Integer.parseInt(((String)movesQueues[i].seeFront()).substring(1)), i + 1);
	    }
        movesView.highlightPosition((int) currentPosition.charAt(0) - 64, Integer.parseInt(currentPosition.substring(1)), knightMoves.getMoveNumber());
    }
}

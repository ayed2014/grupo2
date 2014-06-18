package controllers;

import models.KnightMoves;
import models.Queue;
import views.MovesView;

import javax.swing.*;

/**
 * Created by Francisco on 6/17/2014.
 */
public class KnightMovesController {
    MovesView mv;
    KnightMoves km;

    public KnightMovesController() {
        km = new KnightMoves();
        mv = new MovesView(e -> nextMove());
	    mv.highlightPosition(1, 1, 1);
	    mv.setVisible(true);
	    mv.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * First unhighlights the current position, then does the next move and distributes the queues, then
     * highlights the new current position
     */
    public void nextMove() {
        String currentPosition = km.getCurrentPosition();
        mv.unhighlightPosition((int) currentPosition.charAt(0) - 64, Integer.parseInt(currentPosition.substring(1)));
        km.nextMove();
        Queue[] q = km.getMovesQueues();
        currentPosition = km.getCurrentPosition();
        mv.removeAllMoves();
        for (int i = 0; i < 4; i++) {
            Queue currentQueue = q[i];
            while (!currentQueue.isEmpty()) mv.addMove(i, (String) currentQueue.deQueue());
        }
        mv.highlightPosition((int) currentPosition.charAt(0) - 64, Integer.parseInt(currentPosition.substring(1)), km.getMoveNumber());
    }
}

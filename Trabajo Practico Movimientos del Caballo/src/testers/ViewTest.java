package testers;

import views.MovesView;

import javax.swing.*;

/**
 * @author Nicolas Burroni
 * @since 5/28/2014
 */
public class ViewTest {
	public static void main(String[] args) {
		MovesView m = new MovesView(e -> System.out.println("Clicked"));
		m.setVisible(true);
		m.addMove(1, "A1 C2 D3");
		m.removeMove(1);
		m.highlightPosition(1, 3, 2);
		m.removeAllMoves();
	}

}

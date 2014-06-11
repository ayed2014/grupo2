package testers;

import views.MovesView;

import javax.swing.*;

/**
 * @author Nicolas Burroni
 * @since 5/28/2014
 */
public class Test {
	public static void main(String[] args) {
		new MovesView(e -> System.out.println("Clicked")).setVisible(true);
	}

}

package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Nicolas Burroni
 * @since 5/30/2014
 */
public class MovesView extends JFrame{

	private GridBagConstraints constraints;
	private JPanel rootPanel;
	private JButton nextButton;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel boardPanel;
	private Tile[][] tileArray;

	public MovesView(ActionListener nextActionListener){
		super("Horse Moves");
		setContentPane(rootPanel);
		setMinimumSize(new Dimension(700, 500));
		setLocationRelativeTo(null);
		nextButton.addActionListener(nextActionListener);
	}

	private void createUIComponents() {
		GridBagLayout centerLayout = new GridBagLayout();
		constraints = new GridBagConstraints();
		boardPanel = new JPanel(centerLayout);
		centerLayout.setConstraints(boardPanel, constraints);
		tileArray = new Tile[8][8];
		createBoard();
	}

	/**
	 * Creates the visual board by adding different buttons with their respective images.
	 */
	public void createBoard(){
		for(int i = 1; i <= 8; i++){
			for(int j = 1; j <= 8; j++){
				placeTile(i, j);
			}
		}
	}

	/**
	 * Places a button with its image on the given coordinate.
	 * @param i i coordinate.
	 * @param j j coordinate.
	 */
	private void placeTile(int i, int j){
		Tile tile;
		constraints.gridx = i;
		constraints.gridy = j;
		if((i % 2 == 0 && j % 2 != 0) || (i % 2 != 0 && j % 2 == 0)) tile = new Tile(false);
		else tile = new Tile(true);
		tileArray[j-1][i-1] = tile;
		boardPanel.add(tile, constraints);
	}

	public void highlightPosition(int i, int j, int number){
		tileArray[i][j].setText(String.valueOf(number));
	}

	public class Tile extends JPanel{

		private JLabel label;

		public Tile(boolean isWhite){
			super();
			label = new JLabel();
			label.setOpaque(false);
			label.setFont(new Font("Arial", Font.BOLD, 30));
			setPreferredSize(new Dimension(40, 40));
			if(isWhite) setBackground(Color.WHITE);
			else setBackground(Color.BLACK);
			add(label);
		}

		public void setText(String text){
			label.setText(text);
		}
	}
}

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
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private Tile[][] tileArray;
	private JTextField[] movesFields;

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
		movesFields = new JTextField[4];
		textField1 = new JTextField();
		textField2 = new JTextField();
		textField3 = new JTextField();
		textField4 = new JTextField();
		movesFields[0] = textField1;
		movesFields[1] = textField2;
		movesFields[2] = textField3;
		movesFields[3] = textField4;
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

	public void addMove(int stackNumber, String move){
		movesFields[stackNumber].setText(movesFields[stackNumber].getText() + " " + move);
	}

	public void removeMove(int stackNumber){
		String text = movesFields[stackNumber].getText();
		movesFields[stackNumber].setText(text.substring(0, text.lastIndexOf(" ")));
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

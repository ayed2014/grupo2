import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * @author Nicolas Burroni
 * @since 7/4/2014
 */
public class DictionaryInterface extends JFrame{

	private JPanel root;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JButton proofReadButton;
	private JTextPane correctionsTextPane;
	private JPanel buttonPanel;
	private JScrollPane correctionsScrollPane;
	private JLabel correctionsLabel;
	private JLabel enterLabel;
	private JButton addWordButton;
	private JTextArea textArea;
	private Dictionary dictionary;

	public DictionaryInterface(){
		super("Dictionary");
		setContentPane(root);
		setMinimumSize(new Dimension(600, 500));
		String reference;
		do {
			reference = JOptionPane.showInputDialog("Input the reference text for the dictionary:");
			if(reference == null) return;
		} while (reference.equals(""));
		dictionary = new Dictionary(reference);
		proofReadButton.addActionListener(e -> {
			Map<String, DictionaryWord[]> correctionsMap = dictionary.proofRead(textArea.getText());
			String corrections = "";
			for (String word : correctionsMap.keySet()) {
				corrections = corrections + word + "\n";
				DictionaryWord[] similarWords = correctionsMap.get(word);
				for (DictionaryWord similar : similarWords) {
					corrections = corrections + "\t" + similar.getWord() + "\n";
				}
			}
			
			correctionsTextPane.setText(corrections);
		});
		correctionsLabel.setText("Word              Suggestions");
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

}

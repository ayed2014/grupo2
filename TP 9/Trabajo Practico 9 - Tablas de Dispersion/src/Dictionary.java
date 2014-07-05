import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

/**
 * @author Nicolas Burroni
 * @since 5/14/2014
 */
public class Dictionary {

	private HashTableOpen words;

	public Dictionary(String referenceText){
		words = new HashTableOpen(53);
		String[] referenceWords = separateWords(referenceText);
		for (String referenceWord : referenceWords) {
			addWord(referenceWord);
		}
	}

	public void addWord(String word){
		if(!words.exists(new DictionaryWord(word))) words.insert(new DictionaryWord(word));
	}

	public boolean wordExists(String word){
		return words.exists(new DictionaryWord(word));
	}

	public DictionaryWord getWord(String word){
		return (DictionaryWord) words.get(new DictionaryWord(word));
	}

	public DictionaryWord[] findSimilar(String word){
		return (DictionaryWord[]) words.getArray(new DictionaryWord(word));
	}

	/**
	 * Receives a text to proof read, and returns a list of words the dictionary doesn't know with similar words
	 * the dictionary does know as possible corrections.
	 * @param text text to proof read.
	 * @return a Map, containing as keys the words that may have mistakes, and as values a String array containing the
	 * possible corrections. The Map will be empty if no mistakes were found.
	 */
	public Map<String, DictionaryWord[]> proofRead(String text){
		String[] toCheck = separateWords(text);
		Map<String, DictionaryWord[]> possibleMistakes = new TreeMap<>();
		for (String s : toCheck) {
			DictionaryWord word = new DictionaryWord(s);
			if(!words.exists(word)) {
				Object[] similarObj = words.getArray(word);
				DictionaryWord[] similar = new DictionaryWord[similarObj.length];
				for (int i = 0; i < similarObj.length; i++) {
					similar[i] = (DictionaryWord) similarObj[i];
				}
				possibleMistakes.put(s, similar);
			}
		}
		return possibleMistakes;
	}

	private String[] separateWords(String text){
		for (int i = 1; i <= 8; i++) {
			String replace = "";
			switch(i){
				case 1: replace = ".";
					break;
				case 2: replace = ",";
					break;
				case 3: replace = ";";
					break;
				case 4: replace = ":";
					break;
				case 5: replace = "?";
					break;
				case 6: replace = "!";
					break;
				case 7: replace = "(";
					break;
				case 8: replace = ")";
					break;
				default: break;
			}
			text = text.replaceAll(Pattern.quote(replace), "");
		}
		return text.split(" ");
	}
}

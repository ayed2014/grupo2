/**
 * @author Nicolas Burroni
 * @since 5/14/2014
 */
public class Dictionary {

	private HashTableOpen words;



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
}

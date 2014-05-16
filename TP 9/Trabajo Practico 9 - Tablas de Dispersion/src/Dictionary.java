/**
 * @author Nicolas Burroni
 * @since 5/14/2014
 */
public class Dictionary {

	private HashTableOpen words;


	public String soundexCode(String word){
		char[] wordChars = word.toLowerCase().toCharArray();
		String soundex = "";
		soundex += wordChars[0];
		for (int i = 1; i < wordChars.length; i++) {
			if(soundex.length() == 4) break;
			char c = wordChars[i];
			switch(c){
				case 'b':case 'f':case 'p':case 'v':
					soundex = append(soundex, '1');
					break;
				case 'c':case 'g':case 'j':case 'k':
				case 'q':case 's':case 'x':case 'z':
					soundex = append(soundex, '2');
					break;
				case 'd':case 't':
					soundex = append(soundex, '3');
					break;
				case 'l':
					soundex = append(soundex, '4');
					break;
				case 'm':case 'n':
					soundex = append(soundex, '5');
					break;
				case 'r':
					soundex = append(soundex, '6');
					break;
				default: break;
			}
		}
		if(soundex.length() < 4){
			for(int i = 0; i <= (4 - soundex.length()); i++){
				soundex += '0';
			}
		}
		return soundex;
	}

	private String append(String s, char toAppend){
		if(s.charAt(s.length()-1) == toAppend)
			return s;
		return s + toAppend;
	}

	public void addWord(String word){
		String soundexCode = soundexCode(word);
		if(!words.exists(soundexCode)) words.insert(new DictionaryWord(word, soundexCode));
	}

	public boolean wordExists(String word){
		return words.exists(soundexCode(word));
	}

	public DictionaryWord getWord(String word){
		return (DictionaryWord) words.get(soundexCode(word));
	}

	public DictionaryWord[] findSimilar(String word){
		return (DictionaryWord[]) words.getArray(soundexCode(word));
	}
}

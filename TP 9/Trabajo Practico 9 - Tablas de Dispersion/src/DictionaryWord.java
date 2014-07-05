/**
 * @author Nicolas Burroni
 * @since 5/15/2014
 */
public class DictionaryWord implements Hashable{

	private String word, definition, soundexCode;

	public DictionaryWord(String word) {
		this.word = word.toLowerCase();
		this.soundexCode = soundexCode(this.word);
	}

	public DictionaryWord(String word, String definition) {
		this.word = word.toLowerCase();
		this.definition = definition;
		this.soundexCode = soundexCode(this.word);
	}

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

	@Override
	public int hash(int n) {
		return soundexCode.hashCode() % n;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word.toLowerCase();
		this.soundexCode = soundexCode(this.word);
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getSoundexCode() {
		return soundexCode;
	}

	public String toString(){
		return soundexCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		DictionaryWord that = (DictionaryWord) o;

		if (word != null ? !word.equals(that.word) : that.word != null) return false;

		return true;
	}
}

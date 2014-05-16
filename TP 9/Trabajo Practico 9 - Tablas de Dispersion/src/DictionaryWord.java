/**
 * @author Nicolas Burroni
 * @since 5/15/2014
 */
public class DictionaryWord {

	private String word, definition, soundexCode;

	public DictionaryWord(String word, String soundexCode) {
		this.word = word;
		this.soundexCode = soundexCode;
	}

	public DictionaryWord(String word, String definition, String soundexCode) {
		this.word = word;
		this.definition = definition;
		this.soundexCode = soundexCode;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
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

	public void setSoundexCode(String soundexCode) {
		this.soundexCode = soundexCode;
	}

	public String toString(){
		return soundexCode;
	}

}

/**
 * @author Nicolas Burroni
 * @since 4/9/2014
 */
public class Palindrome {

	public static boolean isPalindrome(String wordOrPhrase){
		Pila pila = new PilaE();
		wordOrPhrase = wordOrPhrase.toLowerCase();
		for(char c : wordOrPhrase.toCharArray()){
			pila.apilar(c);
		}
		char[] flippedChars = new char[wordOrPhrase.length()];
		int i = 0;
		while(!pila.esVacia()){
			flippedChars[i] = (char) pila.verTope();
			pila.desapilar();
			i++;
		}
		String flipped = new String(flippedChars);
		return wordOrPhrase.equals(flipped);
	}

}

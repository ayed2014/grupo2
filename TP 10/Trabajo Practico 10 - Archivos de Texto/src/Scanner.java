
public class Scanner {

	private static final java.util.Scanner scanner = new java.util.Scanner(System.in);

	private Scanner() { }

	/** Displays the given message and waits for user to enter some text.
	 * @param message to be displayed.
	 * @return text entered by the user.
	 */
	public static String getString(String message, String errorMessage) {
		System.out.print(message);
		final String result = scanner.nextLine().trim();
		if(result.isEmpty()) {
			System.out.println("\n" + errorMessage);
			return getString(message, errorMessage);
		}
		return result;
	}

	/** Displays the given message and waits for user to enter a character.
	 * @param message to be displayed.
	 * @return char entered by the user.
	 */
	public static char getChar(String message, String errorMessage) {
		return getString(message, errorMessage).charAt(0);
	}

	public static char getChar(String message, String errorMessage, char[] allowedChars) {
		char c = getChar(message, errorMessage);
		for(char accepted : allowedChars) {
			if (c == accepted) {
				return c;
			}
		}
		System.out.println(errorMessage);
		return getChar(message, errorMessage, allowedChars);
	}

	/** Displays the given message and waits for user to enter an int.
	 * @param message to be displayed.
	 * @return integer entered by the user.
	 */
	public static int getInt(String message, String errorMessage) {
		System.out.print(message);
		try {
			return Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println(errorMessage);
			return getInt(message, errorMessage);
		}
	}

	public static int getInt(String message, String errorMessage, int[] allowedInts) {
		int i = getInt(message, errorMessage);
		for (int accepted : allowedInts) {
			if (i == accepted) {
				return i;
			}
		}
		System.out.println(errorMessage);
		return getInt(message, errorMessage, allowedInts);
	}


		/** Displays the given message and waits for user to enter a long.
		 * @param message to be displayed.
		 * @return long entered by the user.
		 */
	public static long getLong(String message, String errorMessage) {
		System.out.print(message);
		try {
			return Long.parseLong(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("\nPor favor ingrese un long.");
			return getLong(message, errorMessage);
		}
	}

	public static long getLong(String message, String errorMessage, long[] allowedLongs) {
		long i = Scanner.getLong(message, errorMessage);
		for (long accepted : allowedLongs) {
			if (i == accepted) {
				return i;
			}
		}
		System.out.println(errorMessage);
		return getLong(message, errorMessage, allowedLongs);
	}

	/** Displays the given message and waits for user to enter a float.
	 * @param message to be displayed.
	 * @return float entered by the user.
	 */
	public static float getFloat(String message, String errorMessage) {
		System.out.print(message);
		try {
			return Float.parseFloat(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("\nPor favor ingrese un float.");
			return getFloat(message, errorMessage);
		}
	}

	public static float getFloat(String message, String errorMessage, float[] allowedFloats) {
		float i = getFloat(message, errorMessage);
		for (float accepted : allowedFloats) {
			if (i == accepted) {
				return i;
			}
		}
		System.out.println(errorMessage);
		return getFloat(message, errorMessage, allowedFloats);
	}

	/** Displays the given message and waits for user to enter a double.
	 * @param message to be displayed.
	 * @return double entered by the user.
	 */
	public static double getDouble(String message, String errorMessage) {
		System.out.print(message);
		try {
			return Double.parseDouble(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("\nPor favor ingrese un numero real.");
			return getDouble(message, errorMessage);
		}
	}

	public static double getDouble(String message, String errorMessage, double[] allowedDoubles) {
		double i = getDouble(message, errorMessage);
		for (double accepted : allowedDoubles) {
			if (i == accepted) {
				return i;
			}
		}
		System.out.println(errorMessage);
		return getDouble(message, errorMessage, allowedDoubles);
	}

	public static void waitForEnter(String message){
		System.out.print(message);
		scanner.nextLine();
	}
}


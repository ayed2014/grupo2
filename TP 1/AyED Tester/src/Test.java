import java.util.Random;

/**
 * @author
 * @since 3/5/14
 */
public class Test {
	public static void main(String[] args) {
		SeSoMe sesome = new SeSoMe();
		int n = (new Random()).nextInt(50) + 1;

		int[] a = new int[n];

		for (int i = 0; i < a.length; i++) {
			a[i] = (new Random()).nextInt(500) + 1;
		}

		int[] b = a.clone();
		int[] c = a.clone();
		long iTime, fTime;

		System.out.println("\n\nSelection");
		print(a);
		iTime = System.nanoTime();
		sesome.selectionSort(a);
		fTime = System.nanoTime();
		print(a);
		System.out.println("\nTime: " + (fTime - iTime) + " nanoseconds.");

		System.out.println("\n\nSnsertion");
		print(b);
		iTime = System.nanoTime();
		sesome.insertionSort(b);
		fTime = System.nanoTime();
		print(b);
		System.out.println("\nTime: " + (fTime - iTime) + " nanoseconds.");

		System.out.println("\n\nBubble");
		print(c);
		iTime = System.nanoTime();
		sesome.bubbleSort(c);
		fTime = System.nanoTime();
		print(c);
		System.out.println("\nTime: " + (fTime - iTime) + " nanoseconds.");
	}

	public static int[] duplicateArray(int[] array){
		int[] duplicated = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			duplicated[i] = array[i];
		}
		return duplicated;
	}

	public static void print(int[] a){
		System.out.println("");
		for(int i : a) System.out.print(i + " ");
	}

}

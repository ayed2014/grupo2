/**
 * @author
 * @since 3/5/14
 */
public class SeSoMe {

	/**
	 * Busqueda secuencial para un arreglo de int. Devuelve true o false si encontro el int
	 * dado en el arreglo dado.
	 * @param a arreglo de int.
	 * @param k int a buscar.
	 * @return true si encuentra el int en el arreglo, false si no.
	 */
	public boolean sequentialSearch(int[]a, int k){
		for(int a1 : a) if(k == a1) return true;
		return false;
	}

	/**
	 * Busqueda secuencial para un arreglo de Comparable. Devuelve true o false si encontro el Comparable
	 * dado en el arreglo dado.
	 * @param a arreglo de Comparable.
	 * @param k Comparable a buscar.
	 * @return true si encuentra el Comparable en el arreglo, false si no.
	 */
	public boolean sequentialSearch(Comparable[]a, Comparable k){
		for(Comparable a1 : a) if(k.equals(a1)) return true;
		return false;
	}

	/**
	 * Busqueda binaria para un arreglo de int. Devuelve true o false si encontro el int
	 * dado en el arreglo dado.
	 * @param a arreglo de int.
	 * @param k int a buscar.
	 * @return true si encuentra el int en el arreglo, false si no.
	 */
	public boolean binarySearch(int[]a, int k){
		int min = 0;
		int max = a.length - 1;

		while (min <= max){
			int middle = (min + max)/2;
			if(k == a[middle]) return true;
			else if(k < a[middle]) max = middle - 1;
			else min = middle + 1;
		}

		return false;
	}

	/**
	 * Busqueda binaria para un arreglo de Comparable. Devuelve true o false si encontro el Comparable
	 * dado en el arreglo dado.
	 * @param a arreglo de Comparable.
	 * @param k Comparable a buscar.
	 * @return true si encuentra el Comparable en el arreglo, false si no.
	 */
	public boolean binarySearch(Comparable[]a, Comparable k){
		int min = 0;
		int max = a.length - 1;

		while (min <= max){
			int middle = (min + max)/2;
			if(a[middle].equals(k)) return true;
			else if(a[middle].compareTo(k) < 0) max = middle - 1;
			else min = middle + 1;
		}

		return false;
	}

	/* EJERCICIO 1*/

	/**
	 * Busqueda secuencial para un arreglo de int. Devuelve el indice donde se encuentra el int
	 * dado en el arreglo dado, y si no se encuentra devuelve -1.
	 * @param a arreglo de int.
	 * @param k int a buscar.
	 * @return el indice donde encuentra el int en el arreglo, devuelve -1 si no lo encuentra.
	 */
	public int sequentialSearchIndex(int[]a, int k){
		for (int i = 0; i < a.length; i++) {
			if (k == a[i]) return i;
		}
		return -1;
	}

	/**
	 * Busqueda secuencial para un arreglo de int. Devuelve el indice donde se encuentra el int
	 * dado en el arreglo dado, y si no se encuentra devuelve -1.
	 * @param a arreglo de int.
	 * @param k int a buscar.
	 * @return el indice donde encuentra el int en el arreglo, devuelve -1 si no lo encuentra.
	 */
	public int binarySearchIndex(int[]a, int k){
		int min = 0;
		int max = a.length - 1;

		while (min <= max){
			int middle = (min + max)/2;
			if(k == a[middle]) return middle;
			else if(k < a[middle]) max = middle - 1;
			else min = middle + 1;
		}

		return -1;
	}

	/* EJERCICIO 2 */

	/**
	 * Algoritmo de ordenamiento por seleccion. Ordena un arreglo de int.
	 * @param a arreglo de int a ordenar.
	 */
	public void selectionSort(int[] a){
		int min;
		for (int i = 0; i < a.length-1; i++) {
			min = i;
			for (int j = i+1; j < a.length; j++) {
				if (a[j] < a[min]) min = j;
			}
			if ( min != i ) {
				int temp = a[i];
				a[i] = a[min];
				a[min] = temp;
			}
		}
	}

	/**
	 * Algoritmo de ordenamiento por insercion. Ordena un arreglo de int.
	 * @param a arreglo de int a ordenar.
	 */
	public void insertionSort(int[] a){
		for (int i = 1; i < a.length; i++){
			int j = i;
			while ((j > 0) && (a[j-1] > a[j])){
				int temp = a[j];
				a[j] = a[j-1];
				a[j-1] = temp;
				j--;
			}
		}
	}

	/**
	 * Algoritmo de ordenamiento por burbujeo. Ordena un arreglo de int.
	 * @param a arreglo de int a ordenar.
	 */
	public void bubbleSort(int[] a){
		for (int i = a.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}

	/**
	 * Algoritmo de ordenamiento por seleccion. Ordena un arreglo de Comparable.
	 * @param a arreglo de Comparable a ordenar.
	 */
	public void selectionSort(Comparable[] a){
		int min;
		for (int i = 0; i < a.length-1; i++) {
			min = i;
			for (int j = i+1; j < a.length; j++) {
				if (a[j].compareTo(a[min]) < 0) min = j;
			}
			if ( min != i ) {
				Comparable temp = a[i];
				a[i] = a[min];
				a[min] = temp;
			}
		}
	}

	/**
	 * Algoritmo de ordenamiento por insercion. Ordena un arreglo de Comparable.
	 * @param a arreglo de Comparable a ordenar.
	 */
	public void insertionSort(Comparable[] a){
		for (int i = 1; i < a.length; i++){
			int j = i;
			while ((j > 0) && (a[j-1].compareTo(a[j]) > 0)){
				Comparable temp = a[j];
				a[j] = a[j-1];
				a[j-1] = temp;
				j--;
			}
		}
	}

	/**
	 * Algoritmo de ordenamiento por burbujeo. Ordena un arreglo de Comparable.
	 * @param a arreglo de Comparable a ordenar.
	 */
	public void bubbleSort(Comparable[] a){
		for (int i = a.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (a[j].compareTo(a[j+1]) > 0) {
					Comparable temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}

	/**
	 * Llama a la version recursiva del algoritmo de ordenamiento por seleccion
	 * con un indice inicial de 0.
	 * Ordena un arreglo de int.
	 * @param a arreglo de int a ordenar.
	 */
	public void selectionSortRecursive(int[] a){
		selectionSortRecursive(a, 0);
	}

	/**
	 * Version recursiva del algoritmo de ordenamiento por seleccion. Ordena un arreglo de int.
	 * @param a arreglo de int a ordenar.
	 * @param i indice actual del arreglo.
	 */
	private void selectionSortRecursive(int[] a, int i){
		int min;
		if (i < a.length-1) {
			min = i;
			for (int j = i+1; j < a.length; j++) {
				if (a[j] < a[min]) min = j;
			}
			if ( min != i ) {
				int temp = a[i];
				a[i] = a[min];
				a[min] = temp;
			}
			i++;
			selectionSortRecursive(a, i);
		}
	}

	/**
	 * Llama a la version recursiva del algoritmo de ordenamiento por seleccion
	 * con un indice inicial de 0.
	 * Ordena un arreglo de Comparable.
	 * @param a arreglo de Comparable a ordenar.
	 */
	public void selectionSortRecursive(Comparable[] a){
		selectionSortRecursive(a, 0);
	}

	/**
	 * Version recursiva del algoritmo de ordenamiento por seleccion. Ordena un arreglo de Comparable.
	 * @param a arreglo de Comparable a ordenar.
	 * @param i indice actual del arreglo.
	 */
	public void selectionSortRecursive(Comparable[] a, int i){
		int min;
		if (i < a.length-1) {
			min = i;
			for (int j = i+1; j < a.length; j++) {
				if (a[j].compareTo(a[min]) < 0) min = j;
			}
			if ( min != i ) {
				Comparable temp = a[i];
				a[i] = a[min];
				a[min] = temp;
			}
			i++;
			selectionSortRecursive(a, i);
		}
	}

	/* EJERCICIO 3 */

	/**
	 * Algoritmo de intercalacion. Toma dos arreglos de Comparable ordenados y los junta en
	 * un tercer arreglo conteniendo todos los elementos de ambos arreglos de forma ordenada.
	 * @param a arreglo de Comparable a intercalar.
	 * @param b el otro arreglo de Comparable a intercalar.
	 * @return un arreglo conteniendo todos los elementos de ambos arreglos de forma ordenada.
	 */
	public Comparable[] mergeSorted(Comparable[] a, Comparable[] b){
		Comparable[] c = new Comparable[a.length + b.length];
		int i = 0;
		int j = 0;
		for(int k = 0; k < c.length; k++){
			if(i == a.length){
				c[k] = b[j];
				j++;
				continue;
			}
			if(j == b.length){
				c[k] = a[i];
				i++;
				continue;
			}
			if(a[i].compareTo(b[j]) <= 0){
				c[k] = a[i];
				i++;
			}
			else{
				c[k] = b[j];
				j++;
			}
		}
		return c;
	}
}

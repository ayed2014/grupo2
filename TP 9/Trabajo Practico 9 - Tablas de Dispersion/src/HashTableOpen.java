import java.util.ArrayList;
import java.util.List;

/**
 * @author Nicolas Burroni
 * @since 5/14/2014
 */
public class HashTableOpen implements HashTable {

    private List[] elements;

    public HashTableOpen(int size) {
        elements = new ArrayList[size];
        for (int i = 0; i < elements.length;i++) elements[i] = new ArrayList();
    }

    public boolean isPrime(int number) {
        for (int i = 2; i < number / 2; i++) if (number % i == 0) return false;
        return true;
    }

    @Override
    public void insert(Hashable elem) {
        if (!exists(elem)) {
            elements[elem.hash(elements.length)].add(elem);
        }
    }

    @Override
    public void delete(Hashable elem) {
        List theList = elements[elem.hash(elements.length)];
        for (int i = 0; i < theList.size(); i++) {
            if (theList.get(i).equals(elem)) theList.remove(i);
        }
    }

    @Override
    public Object get(Hashable elem) {
        List theList = elements[elem.hash(elements.length)];
        for (int i = 0; i < theList.size(); i++) {
            if (theList.get(i).equals(elem)) {
                Hashable theObject = (Hashable) theList.get(i);
                return theObject;
            }
        }
        return null;
    }

    @Override
    public boolean exists(Hashable elem) {
        List theList = elements[elem.hash(elements.length)];
        for (int i = 0; i < theList.size(); i++) {
	        if(theList.isEmpty()) continue;
            if (theList.get(i).equals(elem)){
                return true;
            }
        }
        return false;
    }

    @Override
    public BinarySearchTree toBinarySearchTree() {
        BinarySearchTree b = new BinarySearchTreeD();
        for (int i = 0; i < elements.length; i++){
            List currentList = elements[i];
            for (int j = 0; j < currentList.size(); j++){
                b.insert((Comparable) currentList.get(j));
            }
        }
        return b;
    }

    @Override
    public void destroy() {
	    for (int i = 0; i < elements.length; i++) {
		    elements[i] = new ArrayList<>(); // El puntero vuelve al primer lugar
	    }
    }

    public Object[] getArray(Hashable elem) {
        List theList = elements[elem.hash(elements.length)];
        Object[] theArray = new Object[theList.size()];
        for (int i = 0; i < theList.size(); i++) {
            theArray[i] = theList.get(i);
        }
        return theArray;
    }
}

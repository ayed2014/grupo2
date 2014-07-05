/**
 * @author Nicolas Burroni
 * @since 5/14/2014
 */
public class HashTableOpen implements HashTable {

    private List[] array;

    public HashTableOpen(int size) {
        array = new ListE[size];
        for (int i = 0; i < array.length;i++) array[i] = new ListE();
    }

    public boolean isPrime(int number) {
        for (int i = 2; i < number / 2; i++) if (number % i == 0) return false;
        return true;
    }

    @Override
    public void insert(Hashable elem) {
        if (!exists(elem)) {
            array[elem.hash(array.length)].addAfter(elem);
        }
    }

    @Override
    public void delete(Hashable elem) {
        List theList = array[elem.hash(array.length)];
        for (int i = 0; i < theList.size(); i++) {
            theList.goTo(i);
            if (theList.seeCurrent().equals(elem)) theList.remove();
        }
        theList.goTo(theList.size());
    }

    @Override
    public Object get(Hashable elem) {
        List theList = array[elem.hash(array.length)];
        for (int i = 0; i < theList.size(); i++) {
            theList.goTo(i);
            if (theList.seeCurrent().equals(elem)) {
                Hashable theObject = (Hashable) theList.seeCurrent();
                theList.goTo(theList.size());
                return theObject;
            }
        }
        theList.goTo(theList.size());
        return null;
    }

    @Override
    public boolean exists(Hashable elem) {
        List theList = array[elem.hash(array.length)];
        for (int i = 0; i < theList.size(); i++) {
            theList.goTo(i);
            if (theList.seeCurrent().equals(elem)){
                theList.goTo(theList.size());
                return true;
            }
        }
        theList.goTo(theList.size());
        return false;
    }

    @Override
    public BinarySearchTree toBinarySearchTree() {
        BinarySearchTree b = new BinarySearchTreeD();
        for (int i = 0; i < array.length; i++){
            List currentList = array[i];
            for (int j = 0; j < currentList.size(); j++){
                currentList.goTo(j);
                b.insert((Comparable) currentList.seeCurrent());
            }
            currentList.goTo(currentList.size());
        }
        return b;
    }

    @Override
    public void destroy() {
	    for (List currentList : array) {
		    currentList.empty(); // El puntero vuelve al primer lugar
	    }
    }

    public Object[] getArray(Hashable elem) {
        List theList = array[elem.hash(array.length)];
        Object[] theArray = new Object[theList.size()];
        for (int i = 0; i < theList.size(); i++) {
            theList.goTo(i);
            theArray[i] = theList.seeCurrent();
        }
        theList.goTo(theList.size());
        return theArray;
    }
}

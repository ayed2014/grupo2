/**
 * Created with IntelliJ IDEA.
 * User: alumnosfi
 * Date: 04/04/14
 * Time: 09:54
 * To change this template use File | Settings | File Templates.
 */
public class ListE implements List {
    private int window;
    private int size;
    private Object[] list;

    public ListE() {
        window = 0;
        size = 0;
        list = new Object[10];
    }

    public void addBefore(Object o) {
        if (size == list.length) enlarge();
        for (int i = size; i > window; i--) {
            list[i] = list[i - 1];
        }
        list[window] = o;
        size++;
    }

    public void addAfter(Object o) {
        if (size == list.length) enlarge();
        if (size == 0) {
            list[window] = o;
            size++;
        } else {
            for (int i = size; i > window + 1; i--) {
                list[i] = list[i - 1];
            }
            list[window + 1] = o;
            size++;
        }
    }

    public void goTo(int i) {
        window = i;
    }

    @Override
    public void remove() {
        for (int i = window; i < size; i++) {
            list[i] = list[i + 1];
        }
        list[size - 1] = null;
        size--;
    }

    @Override
    public void modify(Object obj) {
        list[window] = obj;
    }

    public void next() {
        window++;
    }

    public void previous() {
        window--;
    }

    public Object seeCurrent() {
        return list[window];
    }

    @Override
    public void empty() {
        for (int i = 0; i < size; i++) {
            list[i] = null;
            size--;
        }
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    public int size(){
        return size;
    }

    private void enlarge() {
        Object[] aux = new Object[list.length + 10];
        for (int i = 0; i < size; i++) {
            aux[i] = list[i];
        }
        list = aux;
    }


}

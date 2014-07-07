
/**
 * Here is the AVL-Node class for Completenesse *
 */

public class AvlNode {

    public AvlNode left;
    public AvlNode right;
    public AvlNode parent;
    public int key;
    public int balance;
    public long filePointer;

    public AvlNode(int k, long pointer) {
        left = right = parent = null;
        balance = 0;
        key = k;
        filePointer = pointer;
    }

    public String toString() {
        return "" + key;
    }

}
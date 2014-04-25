import java.io.*;
import java.util.ArrayList;

/**
 * @author Nicolas Burroni, Juan Longo, Francisco DiGiandomenico
 * @since 3/26/2014
 */
public class BinaryTreeApi {

	public int weight(BinaryTree a) {
		if (a.isEmpty()) return 0;
		else return 1 + weight(a.getLeft()) + weight(a.getRight());
	}

	public int leaves(BinaryTree a) {
		if (a.isEmpty()) return 0;
		else if (a.getLeft().isEmpty() && a.getRight().isEmpty()) return 1;
		else return leaves(a.getLeft()) + leaves(a.getRight());
	}

	/*public int countOcurrences(Object o, BinaryTree a) {
		int counter = 0;
		Object[] array = getArrayByLevels(a);
		for (Object object : array) {
			if (o.equals(object)) {
				counter++;
			}
		}
		return counter;
	}*/

	public int countOcurrencesInLevel(BinaryTree a, int lvl) {
		int answer = countOcurrencesInLevel(a, lvl, 0);
		if (height(a) > 0 && answer == 0) return -1;
		else return answer;
	}

	private int countOcurrencesInLevel(BinaryTree a, int lvl, int currentLvl) {
		if (a.isEmpty()) {
			return 0;
		} else if (lvl == currentLvl) {
			return 1;
		} else {
			return countOcurrencesInLevel(a.getLeft(), lvl, currentLvl + 1) + countOcurrencesInLevel(a.getRight(), lvl, currentLvl + 1);
		}
	}

	public int height(BinaryTree a) {
		if (a.isEmpty()) return 0;
		if (a.getLeft().isEmpty() && a.getRight().isEmpty()) return 0;
		int leftHeight, rightHeight;
		leftHeight = height(a.getLeft());
		rightHeight = height(a.getRight());
		return leftHeight >= rightHeight ? leftHeight + 1 : rightHeight + 1;
	}

	public void printPreorder(BinaryTree a) {
		if (a.isEmpty()) return;
		System.out.println(a.getRoot());
		printPreorder(a.getLeft());
		printPreorder(a.getRight());
	}

	public void printInorder(BinaryTree a) {
		if (a.isEmpty()) return;
		printInorder(a.getLeft());
		System.out.println(a.getRoot());
		printInorder(a.getRight());
	}

	public void printPostorder(BinaryTree a) {
		if (a.isEmpty()) return;
		printPostorder(a.getLeft());
		printPostorder(a.getRight());
		System.out.println(a.getRoot());
	}

	/*public void printByLevels(BinaryTree a) {
		for (Object o : getArrayByLevels(a)) System.out.println(o);
	}

	private Object[] getArrayByLevels(BinaryTree a) {
		Object[] byLevels = new Object[weight(a)];
		Queue queue = new QueueD();
		queue.enQueue(a);
		BinaryTree b;
		int i = 0;
		while (!queue.isEmpty()) {
			b = (BinaryTree) queue.deQueue();
			byLevels[i] = b.getRoot();
			if (!b.getLeft().isEmpty())
				queue.enQueue(b.getLeft());
			if (!b.getRight().isEmpty())
				queue.enQueue(b.getRight());
			i++;
		}
		return byLevels;
	}*/

	/*public int addInts(BinaryTree t) {
		Object[] array = getArrayByLevels(t);
		int total = 0;
		for (int i = 0; i < array.length; i++) total = total + (Integer) array[i];
		return total;
	}*/

	/*public int addMultiplesOfThree(BinaryTree t) {
		Object[] allInts = getArrayByLevels(t);
		Queue addInts = new QueueD();
		int total = 0;
		for (int i = 0; i < allInts.length; i++) {
			if (((Integer) allInts[i]) % 3 == 0) addInts.enQueue(allInts[i]);
		}
		while (!addInts.isEmpty()) total = total + (Integer) addInts.deQueue();
		return total;
	}*/

	public boolean areEqual(BinaryTree a1, BinaryTree a2) {
		if (a1.isEmpty() && a2.isEmpty()) return true;
		else if (a1.isEmpty() || a2.isEmpty()) return false;
		if (a1.getRoot().equals(a2.getRoot()))
			return areEqual(a1.getLeft(), a2.getLeft()) && areEqual(a1.getRight(), a2.getRight());
		return false;
	}

	public boolean areIsomorphic(BinaryTree t1, BinaryTree t2) {
		if (t1.isEmpty() && t2.isEmpty()) return true;
		try {
			if ((areIsomorphic(t1.getLeft(), t2.getRight()) && areIsomorphic(t1.getRight(), t2.getLeft()))) return true;
		} catch (NullPointerException e) {
			return false;
		}
		return false;
	}

	/*public boolean areSimilar(BinaryTree t1, BinaryTree t2) {
		Object[] tree1 = getArrayByLevels(t1);
		Object[] tree2 = getArrayByLevels(t2);
		int matches = 0;
		if (tree1.length == tree2.length) {
			loop1:
			for (Object aTree1 : tree1) {
				loop2:
				for (Object aTree2 : tree2) {
					if (aTree1.equals(aTree2)) {
						matches++;
						break loop2;
					}
				}
			}
		}
		if (matches == tree1.length) {
			return true;
		} else {
			return false;
		}
	}*/

	public boolean isComplete(BinaryTree t) {
		if (t.getLeft() == null && t.getRight() == null) return true;
		if (t.getLeft() == null || t.getRight() == null) return false;
		try {
			if (isComplete(t.getLeft()) && isComplete(t.getRight())) return true;
		} catch (NullPointerException e) {
			return true;
		}
		return false;
	}

	public boolean isFull(BinaryTree a) {
		return isFull(a, height(a), 0);
	}

	private boolean isFull(BinaryTree a, int height, int actualLevel) {
		if (actualLevel == height) return true;
		if (height > actualLevel && (a.getLeft().isEmpty() || a.getRight().isEmpty())) return false;
		return isFull(a.getLeft(), height, actualLevel + 1) || isFull(a.getRight(), height, actualLevel + 1);
	}

	public boolean isStable(BinaryTree a) {
		if (a.isEmpty()) {
			return true;
		} else if (a.getRight().isEmpty() && a.getLeft().isEmpty()) {
			return true;
		} else if ((Integer) a.getRoot() < (Integer) a.getLeft().getRoot() || (Integer) a.getRoot() < (Integer) a.getRight().getRoot()) {
			return false;
		}
		return isStable(a.getRight()) && isStable(a.getLeft());
	}

	public boolean treeOccursIn(BinaryTree a1, BinaryTree a2) {
		return areEqual(a1, a2) || treeOccursIn(a1.getLeft(), a2) || treeOccursIn(a1.getRight(), a2);
	}

	public void printFrontier(BinaryTree a) {
		if (a.isEmpty()) return;
		if (a.getLeft().isEmpty() && a.getRight().isEmpty()) System.out.println(a.getRoot());
		else {
			printFrontier(a.getRight());
			printFrontier(a.getLeft());
		}
	}

	public ArrayList<Object> frontierToArrayList(BinaryTree a) {
		return frontierToArrayList(a, new ArrayList<Object>());
	}

	private ArrayList<Object> frontierToArrayList(BinaryTree a, ArrayList<Object> list) {
		if (a.isEmpty()) return list;
		if (a.getLeft().isEmpty() && a.getRight().isEmpty()) list.add(a.getRoot());
		else {
			frontierToArrayList(a.getRight(), list);
			frontierToArrayList(a.getLeft(), list);
		}
		return list;
	}

	public void saveTree(BinaryTree b) throws IOException {
		FileOutputStream fileStream;
		ObjectOutputStream os;
		fileStream = new FileOutputStream("Tree.ser");
		os = new ObjectOutputStream(fileStream);
		os.writeObject(b);
		os.close();
	}

	public BinaryTree loadTree() throws IOException, ClassNotFoundException {
		BinaryTree tree;
		FileInputStream fileStream;
		ObjectInputStream os;
		fileStream = new FileInputStream("Tree.ser");
		os = new ObjectInputStream(fileStream);
		tree = (BinaryTree) os.readObject();
		os.close();
		return tree;
	}
}

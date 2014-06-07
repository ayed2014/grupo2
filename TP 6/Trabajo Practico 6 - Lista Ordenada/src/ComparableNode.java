import java.io.Serializable;

/**
 * @author Nicolas Burroni
 * @since 3/21/14
 */
public class ComparableNode implements Serializable{

	public Comparable obj;
	public ComparableNode next;
	private String debugInfo;

	public ComparableNode(){
		obj = null;
		next = null;
	}

	ComparableNode(String debugInfo){
		this();
		this.debugInfo = debugInfo;
	}

	public ComparableNode(Comparable o){
		obj = o;
		next = null;
	}

	public ComparableNode(Comparable o, ComparableNode next){
		this(o);
		this.next = next;
	}

	public boolean hasNoObj(){
		return obj == null;
	}

	public String toString(){
		return debugInfo;
	}
}

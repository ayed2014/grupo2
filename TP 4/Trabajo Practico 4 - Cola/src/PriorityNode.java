

/**
 * @author Nicolas Burroni
 * @since 3/21/14
 */
public class PriorityNode {

	public Prioritizable obj;
	public PriorityNode next;

	public PriorityNode(){
		obj = null;
		next = null;
	}

	public PriorityNode(Prioritizable o){
		obj = o;
		next = null;
	}

	public PriorityNode(Prioritizable o, PriorityNode next){
		this(o);
		this.next = next;
	}

	public boolean hasNoObj(){
		return obj == null;
	}
}


public class LightBulb implements Comparable{

	final public String REFERENCE_CODE;
	private int watts;
	private String type;
	private int quantity;

	public LightBulb(String REFERENCE_CODE, int watts, String type) {
		if(REFERENCE_CODE.length() > 5) throw new IllegalArgumentException("Reference code can't have a length of more than 5 characters");
		if(type.length() > 10) throw new IllegalArgumentException("Type can't have a length of more than 10 characters");
		this.REFERENCE_CODE = REFERENCE_CODE;
		this.watts = watts;
		this.type = type;
	}

	public LightBulb(String REFERENCE_CODE, int watts, String type, int quantity) {
		this(REFERENCE_CODE, watts, type);
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

    @Override
    public int compareTo(Object o) {
        return REFERENCE_CODE.compareTo(((LightBulb) o).REFERENCE_CODE);
    }

    public int getWatts() {
        return watts;
    }

    public void setWatts(int watts) {
        this.watts = watts;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

	@Override
	public String toString() {
		return "LightBulb{" +
				"REFERENCE_CODE='" + REFERENCE_CODE + '\'' +
				", watts=" + watts +
				", type='" + type + '\'' +
				", quantity=" + quantity +
				'}';
	}

}

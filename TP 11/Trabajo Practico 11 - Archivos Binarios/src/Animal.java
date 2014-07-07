
/**
 * @author Juan Ignacio Longo
 * @date 04/07/14.
 */
public class Animal {

    private char type;
    private int age;
    private char sex;
    private double weight;
    private double pricePerKg;
    private boolean isAvailable;
    private int tag;

    public Animal(int tag, char type, int age, char sex, double weight, double pricePerKg, boolean isAvailable) {
        this.tag = tag;
        this.age = age;
        this.sex = Character.toUpperCase(sex);
        this.pricePerKg = pricePerKg;
        this.type = Character.toUpperCase(type);
        this.weight = weight;
        this.isAvailable = isAvailable;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(double pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String toString() {
        return "Animal with tag " + getTag() + " weighs " + getWeight() + " kilos and its price per kilogram is "
                + getPricePerKg() + ". The animal type code is the letter " + getType() + ", " + getAge() +
                " years old and sex " + getSex();
    }
}

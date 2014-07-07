
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * @author Juan Ignacio Longo
 * @date 04/07/14.
 */
public class FileAnimal {

    private final static int lengthEntry = 29;
    private File f;
    private RandomAccessFile raf;
    private AvlTree indexFile;

    public FileAnimal(String name) throws FileNotFoundException {
        f = new File(name);
        raf = new RandomAccessFile(f, "rw");
    }

    public long getAmountOfEntries() throws IOException {
        return length() / lengthEntry;
    }

    public long getAmountOfEntriesByCondition() throws IOException {
        long counter = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Which field is the condition going to be applied to:");
        System.out.println("1. Type\n2. Age\n3. Sex\n4. Weight\n5. Price per kilo\n6. Availability");
        int option = Integer.parseInt(sc.nextLine());
        switch (option) {
            case 1:
                System.out.println("Please enter the type: ");
                char c = Character.toUpperCase(sc.nextLine().charAt(0));
                counter = getAmountOfEntriesByType(c);
                break;
            case 2:
                System.out.println("Please enter the age: ");
                int i = Integer.parseInt(sc.nextLine());
                counter = getAmountOfEntriesByAge(i);
                break;
            case 3:
                System.out.println("Please enter the sex: ");
                char s = Character.toUpperCase(sc.nextLine().charAt(0));
                counter = getAmountOfEntriesBySex(s);
                break;
            case 4:
                System.out.println("Please enter the weight: ");
                double w = Double.parseDouble(sc.nextLine());
                counter = getAmountOfEntriesByWeight(w);
                break;
            case 5:
                System.out.println("Please enter the price per kilo: ");
                double p = Double.parseDouble(sc.nextLine());
                counter = getAmountOfEntriesByPrice(p);
                break;
            case 6:
                System.out.println("Available (Yes or No): ");
                char a = Character.toLowerCase(sc.nextLine().charAt(0));
                if (a == 'y') counter = getAmountOfEntriesByAvailability(true);
                else if (a == 'n') counter = getAmountOfEntriesByAvailability(false);
                else {
                    System.out.println("Not a valid option.");
                    getAmountOfEntriesByCondition();
                }
                break;
            default:
                System.out.println("Not a valid option.");
                getAmountOfEntriesByCondition();
                break;
        }
        return counter;
    }

    public long getAmountOfEntriesByType(char type) throws IOException {
        int counter = 0;
        goTo(1);
        for (int i = 0; i < getAmountOfEntries(); i++) {
            Animal a = read();
            if (a.getType() == type) counter++;
        }
        return counter;
    }

    public long getAmountOfEntriesByAge(int age) throws IOException {
        int counter = 0;
        goTo(1);
        for (int i = 0; i < getAmountOfEntries(); i++) {
            Animal a = read();
            if (a.getAge() == age) counter++;
        }
        return counter;
    }

    public long getAmountOfEntriesBySex(char sex) throws IOException {
        int counter = 0;
        goTo(1);
        for (int i = 0; i < getAmountOfEntries(); i++) {
            Animal a = read();
            if (a.getSex() == sex) counter++;
        }
        return counter;
    }

    public long getAmountOfEntriesByWeight(double weight) throws IOException {
        int counter = 0;
        goTo(1);
        for (int i = 0; i < getAmountOfEntries(); i++) {
            Animal a = read();
            if (a.getWeight() == weight) counter++;
        }
        return counter;
    }

    public long getAmountOfEntriesByPrice(double price) throws IOException {
        int counter = 0;
        goTo(1);
        for (int i = 0; i < getAmountOfEntries(); i++) {
            Animal a = read();
            if (a.getPricePerKg() == price) counter++;
        }
        return counter;
    }

    public long getAmountOfEntriesByAvailability(boolean available) throws IOException {
        int counter = 0;
        goTo(1);
        for (int i = 0; i < getAmountOfEntries(); i++) {
            Animal a = read();
            if (a.isAvailable() == available) counter++;
        }
        return counter;
    }

    public void beginning() throws IOException {
        raf.seek(0);
    }

    public void ending() throws IOException {
        raf.seek(raf.length());
    }

    public void goTo(long entry) throws IOException {
        raf.seek((entry - 1) * lengthEntry);
    }

    public void close() throws IOException {
        raf.close();
    }

    public long length() throws IOException {
        return raf.length();
    }

    public void write(Animal animal) throws IOException {
        raf.writeInt(animal.getTag());
        raf.writeChar(animal.getType());
        raf.writeInt(animal.getAge());
        raf.writeChar(animal.getSex());
        raf.writeDouble(animal.getWeight());
        raf.writeDouble(animal.getPricePerKg());
        raf.writeBoolean(animal.isAvailable());
    }

    public Animal read() throws IOException {
        return new Animal(raf.readInt(), raf.readChar(), raf.readInt(), raf.readChar(), raf.readDouble(), raf.readDouble()
                , raf.readBoolean());
    }

    public Animal search() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a tag: ");
        int tag = scanner.nextInt();
        Animal a = search(tag);
        if (a.getTag() == 0) System.out.println("The animal with that tag doesn't exists");
        else System.out.println(a.toString());
        return a;
    }

    private Animal search(int tag) throws IOException {
        if (indexFile == null) {
            beginning();
            for (int i = 0; i < getAmountOfEntries(); i++) {
                Animal a = read();
                if (a.getTag() == tag) {
                    return a;
                }
            }
        } else {
            long pointer = indexFile.findNode(tag);
            if (pointer > 0) {
                goTo(pointer);
                return read();
            }
        }
        return null;
    }

    public void add() throws IOException {
        int tag;
        char type;
        int age;
        char sex;
        double weight;
        double pricePerKg;
        Scanner scanner = new Scanner(System.in);
        try {
            ending();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Enter the following data of the animal");
        System.out.println("Tag:");
        tag = scanner.nextInt();
        Animal a = search(tag);
        while (tag == 0 || (a != null && a.getTag() != 0)) {
            System.out.println("Tag can't be 0 or this tag is all ready registered, please enter another value ");
            tag = scanner.nextInt();
            a = search(tag);
        }
        System.out.println("Type: ");
        type = scanner.next().charAt(0);
        System.out.println("Age: ");
        age = scanner.nextInt();
        System.out.println("Sex type: ");
        sex = scanner.next().toLowerCase().charAt(0);
        System.out.println("Weight: ");
        weight = scanner.nextDouble();
        System.out.println("Price: ");
        pricePerKg = scanner.nextDouble();
        try {
            ending();
            if (indexFile != null) indexFile.insert(tag, raf.getFilePointer());
            write(new Animal(tag, type, age, sex, weight, pricePerKg, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean remove() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the tag you wish to eliminate:");
        int tag = scanner.nextInt();
        Animal a = search(tag);
        if (a != null && a.getTag() != 0) {
            raf.seek(raf.getFilePointer() - lengthEntry);
            a.setAvailable(false);
            write(a);
            return true;
        } else return false;
    }

    public boolean modify() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter the tag you wish to modify: ");
        int tag = scanner.nextInt();
        Animal a = search(tag);
        if (a != null && a.getTag() != 0) {
            raf.seek(raf.getFilePointer() - lengthEntry);
            boolean enter = true;
            while (enter) {
                System.out.println("Enter 0 to exit");
                System.out.println("Enter 1 to modify tag");
                System.out.println("Enter 2 to modify type");
                System.out.println("Enter 3 to modify sex");
                System.out.println("Enter 4 to modify weight");
                System.out.println("Enter 5 to modify price per kilogram");
                int user = scanner.nextInt();
                switch (user) {
                    case 0:
                        enter = false;
                        break;
                    case 1:
                        System.out.println("Enter the new tag ");
                        int tag1 = scanner.nextInt();
                        Animal a1 = search(tag1);
                        while (a1.getTag() != 0 || tag1 == 0) {
                            System.out.println("tag can't be 0 or this tag is all ready registered, please enter another value ");
                            tag1 = scanner.nextInt();
                        }
                        a.setTag(tag1);
                        break;
                    case 2:
                        System.out.println("Enter the new type ");
                        String type = scanner.next();
                        a.setType(type.toLowerCase().charAt(0));
                        break;
                    case 3:
                        System.out.println("Enter the new sex ");
                        String sex = scanner.next();
                        a.setSex(sex.toLowerCase().charAt(0));
                        break;
                    case 4:
                        System.out.println("Enter the new weight ");
                        double weight = scanner.nextDouble();
                        a.setWeight(weight);
                        break;
                    case 5:
                        System.out.println("Enter the new price per kilogram ");
                        double pricePerKg = scanner.nextDouble();
                        a.setPricePerKg(pricePerKg);
                        break;
                    default:
                        System.out.println("Enter a number between 0 and 5");
                }
            }
            write(a);
            return true;
        } else return false;
    }

    public void consultAnimal() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter tag to search for:");
        int tag = Integer.parseInt(sc.nextLine());
        Animal a = search(tag);
        if (a != null) {
            System.out.println(a.toString());
        } else {
            System.out.println("Tag not found.");
        }
    }

    public void report() throws IOException {
        goTo(1);
        for (int i = 0; i < getAmountOfEntries(); i++) System.out.println(read().toString() + "\n");
    }

    public void reportByCondition() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which field is the condition going to be applied to:");
        System.out.println("1. Type\n2. Age\n3. Sex\n4. Weight\n5. Price per kilo\n6. Availability");
        int option = Integer.parseInt(sc.nextLine());
        switch (option) {
            case 1:
                System.out.println("Please enter the type: ");
                char c = Character.toUpperCase(sc.nextLine().charAt(0));
                reportByType(c);
                break;
            case 2:
                System.out.println("Please enter the age: ");
                int i = Integer.parseInt(sc.nextLine());
                reportByAge(i);
                break;
            case 3:
                System.out.println("Please enter the sex: ");
                char s = Character.toUpperCase(sc.nextLine().charAt(0));
                reportBySex(s);
                break;
            case 4:
                System.out.println("Please enter the weight: ");
                double w = Double.parseDouble(sc.nextLine());
                reportByWeight(w);
                break;
            case 5:
                System.out.println("Please enter the price per kilo: ");
                double p = Double.parseDouble(sc.nextLine());
                reportByPrice(p);
                break;
            case 6:
                System.out.println("Available (Yes or No): ");
                char a = Character.toLowerCase(sc.nextLine().charAt(0));
                if (a == 'y') reportByAvailability(true);
                else if (a == 'n') reportByAvailability(false);
                else {
                    System.out.println("Not a valid option.");
                    reportByCondition();
                }
                break;
            default:
                System.out.println("Not a valid option.");
                reportByCondition();
                break;
        }
    }

    public void reportByType(char type) throws IOException {
        goTo(1);
        for (int i = 0; i < getAmountOfEntries(); i++) {
            Animal a = read();
            if (a.getType() == type) System.out.println(a.toString());
        }
    }

    public void reportByAge(int age) throws IOException {
        goTo(1);
        for (int i = 0; i < getAmountOfEntries(); i++) {
            Animal a = read();
            if (a.getAge() == age) System.out.println(a.toString());
        }
    }

    public void reportBySex(char sex) throws IOException {
        goTo(1);
        for (int i = 0; i < getAmountOfEntries(); i++) {
            Animal a = read();
            if (a.getSex() == sex) System.out.println(a.toString());
        }
    }

    public void reportByWeight(double weight) throws IOException {
        goTo(1);
        for (int i = 0; i < getAmountOfEntries(); i++) {
            Animal a = read();
            if (a.getWeight() == weight) System.out.println(a.toString());
        }
    }

    public void reportByPrice(double price) throws IOException {
        goTo(1);
        for (int i = 0; i < getAmountOfEntries(); i++) {
            Animal a = read();
            if (a.getPricePerKg() == price) System.out.println(a.toString());
        }
    }

    public void reportByAvailability(boolean available) throws IOException {
        goTo(1);
        for (int i = 0; i < getAmountOfEntries(); i++) {
            Animal a = read();
            if (a.isAvailable() == available) System.out.println(a.toString());
        }
    }

    public void generateIndexFile() throws IOException {
        indexFile = new AvlTree();
        goTo(1);
        long filePointer;
        for (int i = 0; i < getAmountOfEntries(); i++) {
            filePointer = raf.getFilePointer();
            Animal a = read();
            indexFile.insert(a.getTag(), filePointer);
        }
    }
}

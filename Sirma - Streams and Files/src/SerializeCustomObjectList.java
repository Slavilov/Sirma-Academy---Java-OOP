import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class SerializeCustomObjectList {
    public static void main(String[] args) {
        String file = "persons.ser";
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        // Serialize
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(people);
            System.out.println("People saved to " + file);
        } catch (IOException e) {
            System.out.println("Error writing: " + e.getMessage());
        }

        // Deserialize
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                List<?> loaded = (List<?>) obj;
                System.out.println("Loaded people:");
                for (Object p : loaded) {
                    System.out.println(p);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading: " + e.getMessage());
        }
    }
}

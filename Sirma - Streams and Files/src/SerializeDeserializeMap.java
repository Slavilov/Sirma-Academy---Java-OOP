import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class SerializeDeserializeMap {
    public static void main(String[] args) {
        String file = "map.ser";
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 3);
        map.put("Bob", 7);
        map.put("Charlie", 5);

        // Serialize
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(map);
            System.out.println("Map saved to " + file);
        } catch (IOException e) {
            System.out.println("Error writing: " + e.getMessage());
        }

        // Deserialize
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof Map) {
                Map<?, ?> loaded = (Map<?, ?>) obj;
                System.out.println("Loaded map:");
                for (Map.Entry<?, ?> e : loaded.entrySet()) {
                    System.out.println(e.getKey() + " -> " + e.getValue());
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading: " + e.getMessage());
        }
    }
}

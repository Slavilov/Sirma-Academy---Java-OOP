import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterFrequency {
    public static void main(String[] args) {
        Map<Character, Integer> frequency = new LinkedHashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                char c = (char) ch;
                frequency.put(c, frequency.getOrDefault(c, 0) + 1);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

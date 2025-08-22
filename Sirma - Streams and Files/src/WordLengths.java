import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordLengths {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            boolean first = true;
            while ((line = reader.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                for (String w : words) {
                    if (w.isEmpty()) continue;
                    if (!first) System.out.print(", ");
                    System.out.print(w.length());
                    first = false;
                }
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

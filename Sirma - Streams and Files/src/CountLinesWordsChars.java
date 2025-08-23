import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountLinesWordsChars {
    public static void main(String[] args) {
        int lines = 0;
        int words = 0;
        int chars = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines++;
                String trimmed = line.trim();
                if (!trimmed.isEmpty()) {
                    String[] w = trimmed.split("\\s+");
                    words += w.length;
                }
                chars += line.length();
            }
            System.out.println("Lines: " + lines);
            System.out.println("Words: " + words);
            System.out.println("Characters: " + chars);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReplaceWord {
    public static void main(String[] args) {
        String wordToReplace = "Java";
        String newWord = "HTML";

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
             PrintWriter writer = new PrintWriter(new FileWriter("output.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line.replace(wordToReplace, newWord));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MergeLinesTwoFiles {
    public static void main(String[] args) {
        try (BufferedReader r1 = new BufferedReader(new FileReader("input1.txt"));
             BufferedReader r2 = new BufferedReader(new FileReader("input2.txt"));
             PrintWriter out = new PrintWriter(new FileWriter("output.txt"))) {

            String l1, l2;
            while (true) {
                l1 = r1.readLine();
                l2 = r2.readLine();
                if (l1 == null && l2 == null) break;
                if (l1 != null) out.println(l1);
                if (l2 != null) out.println(l2);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

import java.io.File;
import java.util.Scanner;

public class CalculateDirectorySize {
    private static long sizeOf(File f) {
        if (f == null || !f.exists()) return 0;
        if (f.isFile()) return f.length();
        long sum = 0;
        File[] list = f.listFiles();
        if (list != null) {
            for (File child : list) {
                sum += sizeOf(child);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine().trim();
        File dir = new File(path);
        long total = sizeOf(dir);
        System.out.println("Total size: " + total + " bytes");
    }
}

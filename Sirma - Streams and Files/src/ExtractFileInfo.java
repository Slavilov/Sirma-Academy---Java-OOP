import java.io.File;
import java.util.Scanner;

public class ExtractFileInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine().trim();
        File file = new File(path);
        String namePart = file.getName();
        int dot = namePart.lastIndexOf('.');
        String fileName = (dot == -1) ? namePart : namePart.substring(0, dot);
        String extension = (dot == -1) ? "" : namePart.substring(dot + 1);

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + extension);

        if (file.exists() && file.isFile()) {
            System.out.println("File size: " + file.length() + " bytes");
        } else {
            System.out.println("File size: 0 bytes");
        }
    }
}

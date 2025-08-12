package generics;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Demo of ArrayCreator.
 * Reads: length then item (as string). Prints array elements one per line.
 */
public class ArrayCreatorApp {
    public static void run(Scanner sc) {
        System.out.print("Enter length: ");
        int len = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter item (string): ");
        String item = sc.nextLine();
        String[] arr = ArrayCreator.create(String.class, len, item);
        System.out.println("Array contents:");
        Arrays.stream(arr).forEach(System.out::println);
    }
}

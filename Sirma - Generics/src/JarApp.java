package generics;

import java.util.Scanner;

public class JarApp {
    public static void run(Scanner sc) {
        Jar<String> jar = new Jar<>();
        System.out.print("Enter number of items to add: ");
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String item = sc.nextLine();
            jar.add(item);
        }
        System.out.println("Removing items (topmost first):");
        String rem;
        while ((rem = jar.remove()) != null) {
            System.out.println(rem);
        }
    }
}

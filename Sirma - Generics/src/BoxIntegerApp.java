package generics;

import java.util.Scanner;

public class BoxIntegerApp {
    public static void run(Scanner sc) {
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) { i--; continue; }
            Integer v = Integer.parseInt(line);
            Box<Integer> box = new Box<>(v);
            System.out.println(box.toString());
        }
    }
}

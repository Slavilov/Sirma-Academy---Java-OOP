package generics;

import java.util.Scanner;

public class ScaleApp {
    public static void run(Scanner sc) {
        System.out.print("Enter left: ");
        Integer left = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter right: ");
        Integer right = Integer.parseInt(sc.nextLine().trim());
        Scale<Integer> scale = new Scale<>(left, right);
        Integer heavy = scale.getHeavier();
        System.out.println(heavy == null ? "null" : heavy);
    }
}

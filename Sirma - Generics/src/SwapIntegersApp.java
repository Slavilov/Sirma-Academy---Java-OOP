package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SwapIntegersApp {
    public static void run(Scanner sc) {
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Box<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Box<>(Integer.parseInt(sc.nextLine().trim())));
        }
        String[] parts = sc.nextLine().trim().split("\\s+");
        int i = Integer.parseInt(parts[0]);
        int j = Integer.parseInt(parts[1]);
        SwapUtil.swap(list, i, j);
        for (Box<Integer> b : list) System.out.println(b);
    }
}

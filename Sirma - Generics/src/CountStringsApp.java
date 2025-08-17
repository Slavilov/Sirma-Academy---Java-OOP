package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountStringsApp {
    public static void run(Scanner sc) {
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Box<String>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Box<>(sc.nextLine()));
        }
        String comparator = sc.nextLine();
        // Extract values and count using CountUtil on strings
        List<String> vals = new ArrayList<>();
        for (Box<String> b : list) vals.add(b.getValue());
        int result = CountUtil.countGreaterThan(vals, comparator);
        System.out.println(result);
    }
}

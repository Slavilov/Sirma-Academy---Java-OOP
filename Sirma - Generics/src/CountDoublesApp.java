package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountDoublesApp {
    public static void run(Scanner sc) {
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Box<Double>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Box<>(Double.parseDouble(sc.nextLine().trim())));
        }
        Double comparator = Double.parseDouble(sc.nextLine().trim());
        List<Double> vals = new ArrayList<>();
        for (Box<Double> b : list) vals.add(b.getValue());
        int result = CountUtil.countGreaterThan(vals, comparator);
        System.out.println(result);
    }
}

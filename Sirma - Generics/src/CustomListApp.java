package generics;

import java.util.Scanner;

public class CustomListApp {
    public static void run(Scanner sc) {
        CustomList<String> list = new CustomList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.equals("")) continue;
            if (line.equalsIgnoreCase("end")) break;
            String[] parts = line.split("\\s+", 2);
            String cmd = parts[0];
            switch (cmd) {
                case "Add":
                    list.add(parts[1]);
                    break;
                case "Remove":
                    int idx = Integer.parseInt(parts[1]);
                    list.remove(idx);
                    break;
                case "Contains":
                    System.out.println(list.contains(parts[1]));
                    break;
                case "Swap": {
                    String[] p = parts[1].split("\\s+");
                    int i = Integer.parseInt(p[0]);
                    int j = Integer.parseInt(p[1]);
                    list.swap(i, j);
                    break;
                }
                case "Greater":
                    System.out.println(list.countGreaterThan(parts[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    list.printAll();
                    break;
                default:
                    System.out.println("Unknown command: " + line);
            }
        }
    }
}

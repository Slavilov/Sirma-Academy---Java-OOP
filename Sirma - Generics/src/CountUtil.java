package generics;

import java.util.List;

public class CountUtil {
    public static <T extends Comparable<T>> int countGreaterThan(List<T> list, T elem) {
        int cnt = 0;
        for (T t : list) {
            if (t.compareTo(elem) > 0) cnt++;
        }
        return cnt;
    }
}

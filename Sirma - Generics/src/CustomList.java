package generics;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> data = new ArrayList<>();

    public void add(T element) { data.add(element); }

    public T remove(int index) {
        return data.remove(index);
    }

    public boolean contains(T element) { return data.contains(element); }

    public void swap(int i, int j) { T tmp = data.get(i); data.set(i, data.get(j)); data.set(j, tmp); }

    public int countGreaterThan(T element) {
        int cnt = 0;
        for (T t : data) if (t.compareTo(element) > 0) cnt++;
        return cnt;
    }

    public T getMax() {
        if (data.isEmpty()) return null;
        T max = data.get(0);
        for (T t : data) if (t.compareTo(max) > 0) max = t;
        return max;
    }

    public T getMin() {
        if (data.isEmpty()) return null;
        T min = data.get(0);
        for (T t : data) if (t.compareTo(min) < 0) min = t;
        return min;
    }

    public void printAll() {
        for (T t : data) System.out.println(t);
    }
}

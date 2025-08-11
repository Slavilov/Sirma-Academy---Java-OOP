package generics;

import java.util.ArrayList;
import java.util.List;

public class Jar<T> {
    private List<T> data = new ArrayList<>();

    public void add(T element) {
        data.add(element);
    }

    public T remove() {
        if (data.isEmpty()) return null;
        return data.remove(data.size() - 1);
    }
}

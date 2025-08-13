package generics;

public class Scale<T extends Comparable<T>> {
    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        int cmp = left.compareTo(right);
        if (cmp > 0) return left;
        if (cmp < 0) return right;
        return null;
    }
}

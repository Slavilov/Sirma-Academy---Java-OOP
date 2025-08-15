package generics;

public class Box<T> implements Comparable<Box<T>> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() { return value; }

    @Override
    public String toString() {
        return value.getClass().getName() + ": " + value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public int compareTo(Box<T> other) {
        if (this.value instanceof Comparable && other.value instanceof Comparable) {
            Comparable a = (Comparable) this.value;
            Comparable b = (Comparable) other.value;
            return a.compareTo(b);
        }
        throw new IllegalStateException("Values not comparable");
    }
}

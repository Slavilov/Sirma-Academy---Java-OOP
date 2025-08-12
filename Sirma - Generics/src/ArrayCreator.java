package generics;

import java.lang.reflect.Array;

/**
 * ArrayCreator with two overloads.
 */
public class ArrayCreator {
    public static <T> T[] create(int length, T item) {
        @SuppressWarnings("unchecked")
        T[] arr = (T[]) new Object[length];
        for (int i = 0; i < length; i++) arr[i] = item;
        return arr;
    }

    public static <T> T[] create(Class<T> clazz, int length, T item) {
        @SuppressWarnings("unchecked")
        T[] arr = (T[]) Array.newInstance(clazz, length);
        for (int i = 0; i < length; i++) arr[i] = item;
        return arr;
    }
}

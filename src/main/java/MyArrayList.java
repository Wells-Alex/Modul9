public class MyArrayList {
    private Object[] elements;
    private int size;
    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }
    public void add(Object value) {
        ensureCapacity();
        elements[size++] = value;
    }
    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newArray = new Object[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                newArray[i] = elements[i];
            }
            elements = newArray;
        }
    }
    public Object get(int index) {
        checkIndex(index);
        return elements[index];
    }
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
    }
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
    }
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
    public int size() {
        return size;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
    public static void main(String[] args) {
        int[] numbers = {3, 7, 1, 9, 2};
        MyArrayList list = new MyArrayList();
        for (int number : numbers) {
        list.add(number);
        }
        System.out.println(list);
        list.add(1);
        list.remove(2);
        System.out.println(list.get(1));
        list.clear();
        System.out.println(list);
    }
}

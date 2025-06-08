public class MyLinkedList<T> {

    private class Node {
        T value;
        Node next;
        Node prev;
        Node(T value) {
            this.value = value;
        }
    }
    private Node head;
    private Node tail;
    private int size = 0;

    public void add(T value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Error: " + index);
        }
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
        size--;
    }
    public int size() {
        return size;
    }
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Неверный индекс: " + index);
        }
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        } return current.value;
    }
    public void clear() {
        if (head != null) {
            Node current = head;
            for (int i = 0; i < size; i++) {
                Node next = current.next;
                current.next = null;
                current.prev = null;
                current.value = null;
                current = next;
            }
            head = null;
            tail = null;
            size = 0;
        }
    }
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        System.out.println(list.get(2));
        System.out.println(list.size);
        list.clear();
        System.out.println(list);
    }
}

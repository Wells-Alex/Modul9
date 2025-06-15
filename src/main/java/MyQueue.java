public class MyQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;

    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return head.value;
    }

    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T value = head.value;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return value;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
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
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        System.out.println(myQueue);
        System.out.println(myQueue.size);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        System.out.println(myQueue);
        myQueue.clear();
        System.out.println(myQueue);
    }
}
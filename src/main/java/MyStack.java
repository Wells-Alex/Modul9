public class MyStack<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyStack() {
        head = null;
        tail = null;
        size = 0;
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

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;

        }
        tail = newNode;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }

        size--;
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

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T value = head.value;
        head = head.next;
        size--;
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
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println(myStack);
        myStack.remove(2);
        System.out.println(myStack);
        System.out.println(myStack.size);
        System.out.println(myStack.peek());
        myStack.pop();
        System.out.println(myStack);
        myStack.clear();
        System.out.println(myStack);
    }
}
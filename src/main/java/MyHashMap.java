public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private final MapNode<K, V>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        table = (MapNode<K, V>[]) new MapNode[DEFAULT_CAPACITY];
        size = 0;
    }

    private static class MapNode<K, V> {
        public K key;
        public V value;
        public MapNode<K, V> next;

        public MapNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        MapNode<K, V> current = table[index];

        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        MapNode<K, V> newNode = new MapNode<>(key, value);
        newNode.next = table[index];
        table[index] = newNode;

        size++;
    }

    private int getIndex(K key) {
        return (key == null ? 0 : Math.abs(key.hashCode())) % table.length;
    }

    public V remove(K key) {
        int index = getIndex(key);
        MapNode<K, V> current = table[index];
        MapNode<K, V> previous = null;

        while (current != null) {
            if ((key == null && current.key == null) || (key != null && key.equals(current.key))) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return current.value;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int index = getIndex(key);
        MapNode<K, V> current = table[index];

        while (current != null) {
            if ((key == null && current.key == null) || (key != null && key.equals(current.key))) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        boolean firstEntry = true;
        for (int i = 0; i < table.length; i++) {
            MapNode<K, V> current = table[i];
            while (current != null) {
                if (!firstEntry) {
                    sb.append(", ");
                }
                sb.append(current.key).append(": ").append(current.value);
                firstEntry = false;
                current = current.next;
            }
        }

        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<>();
        myHashMap.put(123, "John");
        myHashMap.put(321, "Alex");
        myHashMap.put(231, "Mark");
        myHashMap.put(4321, "Vika");
        System.out.println(myHashMap);
        myHashMap.remove(321);
        System.out.println(myHashMap);
        System.out.println(myHashMap.size());
        System.out.println(myHashMap.get(231));
    }
}
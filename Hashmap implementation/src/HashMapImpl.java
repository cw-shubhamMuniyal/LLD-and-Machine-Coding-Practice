public class HashMapImpl<K, V> {

    private static final int INITIAL_CAPACITY = 1 << 4;
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    Node<K, V>[] buckets;

    HashMapImpl() {
        buckets = new Node[INITIAL_CAPACITY];
    }

    HashMapImpl(int capacity) {
        tableSizeFor(capacity);
        buckets = new Node[capacity];
    }

    public static void main(String[] args) {
        System.out.println("Hash Map implementation!");
        System.out.println("_______________________!");

        HashMapImpl<String, Integer> hashMap = new HashMapImpl<>(2);
        hashMap.put("tina", 95);
        hashMap.put("rahul", 80);
        hashMap.put("aman", 90);
        hashMap.put("tina", 99);

        System.out.println("Tina's score " + hashMap.get("tina"));
        System.out.println("Rahul's score " + hashMap.get("rahul"));
        System.out.println("Aman's score " + hashMap.get("aman"));

    }

    static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    void put(K key, V value) {

        int index = key.hashCode() % buckets.length;

        Node<K, V> previousNode = null;
        Node<K, V> node = buckets[index];

        if (node == null) {
            Node<K, V> newNode = new Node<>(key, value);
            buckets[index] = newNode;
        } else {

            while (node != null) {

                if (node.getKey() == key) {
                    node.setValue(value);
                    return;
                } else {
                    previousNode = node;
                    node = previousNode.getNext();
                }
            }

            if (previousNode != null) {
                previousNode.setNext(new Node<>(key, value));
            }
        }
    }

    V get(K key) {

        int index = key.hashCode() % buckets.length;
        Node<K, V> node = buckets[index];
        while (node != null) {
            if (node.getKey() == key) {
                return node.getValue();
            } else {
                node = node.getNext();
            }
        }
        return null;

    }
}
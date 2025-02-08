public class Node<K, V> {

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    private final K key;

    public K getKey() {
        return key;
    }

    private V value;

    public void setValue(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    private Node next;

    public void setNext(Node next) {
        this.next = next;
    }
}

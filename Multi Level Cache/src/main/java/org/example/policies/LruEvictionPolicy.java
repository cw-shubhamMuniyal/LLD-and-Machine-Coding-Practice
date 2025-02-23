package org.example.policies;

import lombok.NonNull;
import org.example.model.Node;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Objects;

public class LruEvictionPolicy<Key> implements EvictionPolicy<Key>{

    private final Deque<Node<Key>> doublyLinkedList = new ArrayDeque<>();
    private final HashMap<Key, Node<Key>> mapper = new HashMap<>();

    @Override
    public void keyAccessed(@NonNull Key key) {

        Node<Key> node = mapper.get(key);
        if (Objects.nonNull(node)) {
            doublyLinkedList.remove(node);
        }
        else {
            node = new Node<Key>(key);
            mapper.put(key, node);
        }
        doublyLinkedList.addLast(node);
    }

    @Override
    public Key evictKey() {

        Node<Key> node = doublyLinkedList.removeFirst();
        mapper.remove(node.getValue());
        return node.getValue();
    }
}

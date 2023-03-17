package model;
import java.util.ArrayList;

public class HashTable<K, V> implements IHashTable<K, V>{
    private ArrayList<HNode<K, V>> table;
    private int size;
    private HNode<K,V> deleted;
    // Constructor
    public HashTable(int capacity) {
        this.size = 0;
        this.table = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            table.add(null);
        }
    }

    // Función de hash
    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.size();
    }

    // Método de búsqueda
    public V search(K key) {
        int index = hash(key);
        HNode<K, V> node = table.get(index);
        while (node != null) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
            node = node.getNext();
        }
        return null;
    }

    // Método de inserción
    public void insert(K key, V value) {
        int index = hash(key);
        HNode<K, V> newNode = new HNode<K, V>(key, value);
        newNode.setNext(table.get(index));
        if (newNode.getNext() != null) {
            newNode.getNext().setPrev(newNode);
        }
        table.set(index, newNode);
        size++;
    }

    // Método de eliminación
    public void delete(K key) {
        int index = hash(key);
        HNode<K, V> node = table.get(index);
        while (node != null) {
            if (node.getKey().equals(key)) {
                if (node.getPrev() == null) {
                    table.set(index, node.getNext());
                } else {
                    node.getPrev().setNext(node.getNext());
                }
                if (node.getNext() != null) {
                    node.getNext().setPrev(node.getPrev());
                }
                size--;
                return;
            }
            node = node.getNext();
        }
    }
}
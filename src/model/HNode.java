package model;

public class HNode<K,V> {
    private V value;
    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    private K key;
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    private HNode<K, V> next;
    public HNode<K, V> getNext() {
        return next;
    }

    public void setNext(HNode<K, V> next) {
        this.next = next;
    }

    private HNode<K, V> prev;

    public HNode<K, V> getPrev() {
        return prev;
    }

    public void setPrev(HNode<K, V> prev) {
        this.prev = prev;
    }

    public HNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
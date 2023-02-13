package chap10;

import java.util.Comparator;

public class BinTree {
    static class Node<K,V> {
        private K key;
        private V data;
        private Node<K,V> left;
        private Node<K,V> right;

        Node(K key, V data, Node<K, V> left, Node<K,V> right) {
            this.key = key;
            this.data = data;
            this.left  = left;
            this.right = right;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return data;
        }

        void print() {
            System.out.println(data);
        }

        private Node<K,V> root;
        private Comparator<? super K> comparator = null;
    }

}

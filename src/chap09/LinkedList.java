package chap09;

import java.util.Comparator;

public class LinkedList<E> {
    class Node<E>{
        private E data;
        private Node<E> next;


        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> crnt;

    public LinkedList() {
        head = crnt = null;
    }

    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head;

        while(ptr != null) {
            if(c.compare(obj, ptr.data) == 0){
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null;
    }
}

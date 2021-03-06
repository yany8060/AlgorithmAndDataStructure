package com.yany.datastructures.list;


public class SimpleLinkedList<T> {

    private Node<T> root = null;
    private Node<T> current = null;

    public SimpleLinkedList() {
        this.root = new Node<>(null, null);
        this.current = root;
    }


    public void add(Node<T> node) {
        current.setNext(node);
        current = node;
    }

    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

}

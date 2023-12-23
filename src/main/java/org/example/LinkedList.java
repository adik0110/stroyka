package org.example;

public class LinkedList {
    Node root;

    public void add(Stage stage) {
        Node node = new Node(stage);
        if (root == null) {
            root = node;
        } else {
            Node temp = root;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next=node;
            node.prev=temp;
        }
    }
}

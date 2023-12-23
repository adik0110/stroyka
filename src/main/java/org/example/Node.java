package org.example;

public class Node {
    private Stage stage;
    public Node next;
    public Node prev;

    public Stage getStage() {
        return stage;
    }

    public Node(Stage stage) {
        this.stage = stage;
    }
}

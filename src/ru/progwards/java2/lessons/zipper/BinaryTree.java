package ru.progwards.java2.lessons.zipper;

import java.util.HashMap;

public class BinaryTree {

    private Node root;
    private HashMap<Character, Byte> encodeTable;

    public BinaryTree() {
        root = new Node();

    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public int getFrequence() {
        return root.getFrequence();
    }

    public Node getRoot() {
        return root;
    }
}

package com.markos.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class SinglyLinkedList {

    private Node start;

    public SinglyLinkedList(int value) {
        this.start = new Node(value);
    }

    public boolean insert(int value) {
        Node current = start;

        while(current.getNext() != null) {
            current = current.getNext();
        }

        Node newNode = new Node(value);
        current.setNext(newNode);

        return true;
    }

    public boolean search(int value) {
        Node current = start;

        while (current != null) {
            if (current.getValue() == value)
                return true;

            current = current.getNext();
        }

        return false;
    }

    public List<Integer> toArrayList() {
        List<Integer> list = new ArrayList<>();
        Node current = start;

        while(current != null) {
            list.add(current.getValue());
            current = current.getNext();
        }

        return list;
    }

    public boolean delete(int value) {
        Node current = start;

        if(current.getValue() == value) {
            start = current.getNext();
            return true;
        }

        while(current.getNext() != null) {
            if(current.getNext().getValue() == value) {
                current.setNext(current.getNext().getNext());
                return true;
            }

            current = current.getNext();
        }

        return false;
    }
}


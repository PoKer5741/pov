/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author poker
 */
public class CircularLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addProcedure(Procedure procedure) {
        Node newNode = new Node(procedure);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.setNext(head);
        } else {
            tail.setNext(newNode);
            newNode.setNext(head);
            tail = newNode;
        }
        size++;
    }

    public Procedure getProcedureAt(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getProcedure();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void displayProcedures() {
        if (head == null) {
            return;
        }
        Node current = head;
        int index = 0;
        do {
            System.out.println(index + ": " + current.getProcedure().getName());
            current = current.getNext();
            index++;
        } while (current != head);
    }
}

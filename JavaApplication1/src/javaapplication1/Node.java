/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author poker
 */
public class Node {
    private Procedure procedure;
    private Node next;

    public Node(Procedure procedure) {
        this.procedure = procedure;
        this.next = null;
    }

    public Procedure getProcedure() {
        return procedure;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

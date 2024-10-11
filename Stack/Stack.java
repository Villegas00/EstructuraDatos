/* A01329696 Rodrigo Emmanuel Oliveros Vazquez 
    A01625055 Sergio Ivan Villegas Arenas*/

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Stack<Item> {
    private int n;          
    private Node first;     

    private class Node {
        private Item item;
        private Node next;
    }


    public Stack() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }


    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;
        first = first.next;     
        n--;
        return item;                  
    }

}
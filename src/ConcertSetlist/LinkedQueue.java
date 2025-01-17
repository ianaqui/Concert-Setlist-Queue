package ConcertSetlist;

// Basic queue implementation using linked nodes
public class LinkedQueue<T> implements QueueInterface<T> {
    protected class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    protected Node first;
    protected Node last;

    public LinkedQueue() {
        first = null;
        last = null;
    }

    public void enqueue(T entry) {
        Node newNode = new Node(entry);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    public T dequeue() {
        if (isEmpty()) return null;
        T data = first.data;
        first = first.next;
        if (first == null) last = null;
        return data;
    }

    public T getFront() {
        if (isEmpty()) return null;
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void clear() {
        first = null;
        last = null;
    }

    public void display() {
        for (Node p = first; p != null; p = p.next) {
            System.out.println(p.data);
        }
    }
}
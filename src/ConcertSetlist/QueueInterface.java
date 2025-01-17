package ConcertSetlist;

// Basic queue operations interface
public interface QueueInterface<T> {
    void enqueue(T entry);
    T dequeue();
    T getFront();
    boolean isEmpty();
    void clear();
}
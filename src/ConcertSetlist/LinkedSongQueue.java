package ConcertSetlist;

// Extended queue for songs with remove by title feature
public class LinkedSongQueue extends LinkedQueue<Song> {

    // Remove song by title
    public boolean remove(String title) {
        if (isEmpty()) return false;

        if (first.data.getTitle().equals(title)) {
            dequeue();
            return true;
        }

        Node current = first;
        while (current.next != null) {
            if (current.next.data.getTitle().equals(title)) {
                current.next = current.next.next;
                if (current.next == null) last = current;

                // Update start times
                Node p = current.next;
                int newStart = current.data.getStartTime() +
                        current.data.getDuration();
                while (p != null) {
                    p.data.setStartTime(newStart);
                    newStart += p.data.getDuration();
                    p = p.next;
                }
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
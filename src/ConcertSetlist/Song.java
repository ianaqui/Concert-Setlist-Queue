package ConcertSetlist;

// Song class to store title, duration, and start time
public class Song {
    String title;
    int duration;
    int startTime;

    public Song(String title, int duration, int startTime) {
        this.title = title;
        this.duration = duration;
        this.startTime = startTime;
    }

    public Song(String title, int duration) {
        this(title, duration, 0);
    }

    String getTitle() { return title; }
    void setTitle(String title) { this.title = title; }
    int getDuration() { return duration; }
    void setDuration(int duration) { this.duration = duration; }
    int getStartTime() { return startTime; }
    void setStartTime(int startTime) { this.startTime = startTime; }

    public String toString() {
        return title + " " + duration + " " + startTime;
    }
}
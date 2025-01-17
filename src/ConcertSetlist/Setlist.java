package ConcertSetlist;

import java.util.Scanner;

public class Setlist {
    public static void main(String[] args) {
        // initialize song database
        Song[] songDb = new Song[10];
        initSongDb(songDb);

        // create setlist using queue
        LinkedSongQueue setList = new LinkedSongQueue();
        Scanner in = new Scanner(System.in);

        // add songs to queue
        System.out.print("Enter song IDs to add to setlist\n(<0 to quit): ");
        while (true) {
            int id = in.nextInt();
            if (id < 0) break;
            if (id < songDb.length) {
                Song dbSong = songDb[id];
                Song newSong = new Song(dbSong.getTitle(), dbSong.getDuration(), 0);
                setList.enqueue(newSong);
            }
        }

        // update start times
        int startTime = 0;
        for (LinkedQueue<Song>.Node p = setList.first; p != null; p = p.next) {
            Song song = p.data;
            song.setStartTime(startTime);
            startTime += song.getDuration();
        }

        // display setlist
        System.out.println("Setlist:");
        setList.display();

        // remove song by title
        System.out.print("Enter song title to remove from setlist: ");
        in.nextLine();
        String removeTitle = in.nextLine();
        if (setList.remove(removeTitle)) {
            System.out.println("Updated setlist:");
            setList.display();
        }

        // start concert at time = 0
        System.out.println("Starting concert at time = 0 minutes!");
        int currentTime = 0;

        // get next timestamp
        while (!setList.isEmpty()) {
            System.out.print("Enter next timestamp (in minutes): ");
            int nextTime = in.nextInt();

            if (nextTime < currentTime) continue;
            currentTime = nextTime;

            // process setlist
            while (!setList.isEmpty()) {
                Song current = setList.getFront();
                int endTime = current.getStartTime() + current.getDuration();

                // remove and display finished songs
                if (currentTime >= endTime) {
                    setList.dequeue();
                    System.out.println(current.getTitle() + " finished");
                }
                // display song in progress
                else if (currentTime >= current.getStartTime()) {
                    System.out.println(current.getTitle() + " playing");
                    break;
                } else break;
            }

            // check if setlist is empty
            if (setList.isEmpty()) {
                System.out.println("Setlist complete");
                break;
            }
        }

        System.out.println("Concert finished!");
        in.close();
    }

    // initialize song database
    public static void initSongDb(Song[] sl) {
        sl[0] = new Song("Fancy", 4);
        sl[1] = new Song("Feel Special", 3);
        sl[2] = new Song("TT", 3);
        sl[3] = new Song("Cheer Up", 4);
        sl[4] = new Song("What is Love", 3);
        sl[5] = new Song("Yes or Yes", 4);
        sl[6] = new Song("More & More", 3);
        sl[7] = new Song("I Can't Stop Me", 3);
        sl[8] = new Song("Alcohol-Free", 3);
        sl[9] = new Song("Talk That Talk", 3);
        System.out.println("TWICE songs in database:");
        for (int i = 0; i < sl.length; i++) {
            System.out.println(i + " " + sl[i].getTitle() + " " + sl[i].getDuration());
        }
    }
}
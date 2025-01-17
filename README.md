# 🎵 Concert Setlist Tracker

## 🎯 Intro:
A Java-based program for managing concert setlists using a queue data structure. This program helps track song order, timing, and playback status during a simulated concert performance.

## 🛠️ Tech Stack:
* Java
* Scanner for user input
* Command line interface
* Queue data structure with linked implementation

## 💫 Features:
* Song management:
    * Add songs to queue
    * Remove songs by title
    * Auto-update start times
    * Track performance progress

* Concert simulation:
    * Real-time song tracking
    * Performance status updates
    * Automatic song transitions
    * Duration management

* Queue operations:
    * Enqueue new songs
    * Dequeue finished songs
    * Remove by title
    * Front element access

## 🗂️ Project Files:
* `Setlist.java` - Main program with user interface
* `Song.java` - Song data structure
* `QueueInterface.java` - Queue ADT interface
* `LinkedQueue.java` - Generic queue implementation
* `LinkedSongQueue.java` - Extended queue for songs

## 🚀 Running the Project:
1. Compile all files:
```bash
javac ConcertSetlist/*.java
```
2. Run the program:
```bash
java ConcertSetlist.Setlist
```
3. Follow prompts to:
    - Add songs by ID number
    - Remove songs by title
    - Enter timestamps to simulate concert

## 🖼️ Sample Output:
```bash
TWICE songs in database:
0 Fancy 4
1 Feel Special 3
2 TT 3
...

Enter song IDs to add to setlist
(<0 to quit): 0
Setlist:
Fancy 4 0

Starting concert at time = 0 minutes!
Enter next timestamp (in minutes): 2
Fancy playing
```
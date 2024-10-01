interface Playable {
    // Abstract methods
    void play();

    void pause();

    void stop();

    default void displayInfo() {
        System.out.println("Playing media...");
    }
}

class Audio implements Playable {
    private String title;

    public Audio(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println("Playing audio: " + title);
    }

    @Override
    public void pause() {
        System.out.println("Pausing audio: " + title);
    }

    @Override
    public void stop() {
        System.out.println("Stopping audio: " + title);
    }
}

class Video implements Playable {
    private String title;

    public Video(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println("Playing video: " + title);
    }

    @Override
    public void pause() {
        System.out.println("Pausing video: " + title);
    }

    @Override
    public void stop() {
        System.out.println("Stopping video: " + title);
    }
}

public class InterfaceMain {
    public static void main(String[] args) {
        Playable myAudio = new Audio("Greatest Hits");
        Playable myVideo = new Video("Documentary");

        System.out.println("Audio:");
        myAudio.play();
        myAudio.displayInfo(); // Using default method
        myAudio.pause();
        myAudio.stop();

        System.out.println("\nVideo:");
        myVideo.play();
        myVideo.displayInfo();
        myVideo.pause();
        myVideo.stop();
    }
}

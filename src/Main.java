class TV {
    public void turnOn() {
        System.out.println("TV is turned on.");
    }

    public void turnOff() {
        System.out.println("TV is turned off.");
    }

    public void setChannel(int channel) {
        System.out.println("TV channel set to " + channel);
    }
}

class AudioSystem {
    public void turnOn() {
        System.out.println("Audio system is turned on.");
    }

    public void turnOff() {
        System.out.println("Audio system is turned off.");
    }

    public void setVolume(int level) {
        System.out.println("Audio system volume set to " + level);
    }
}

class DVDPlayer {
    public void play() {
        System.out.println("DVD player is playing.");
    }

    public void pause() {
        System.out.println("DVD player is paused.");
    }

    public void stop() {
        System.out.println("DVD player is stopped.");
    }
}

class GameConsole {
    public void turnOn() {
        System.out.println("Game console is turned on.");
    }

    public void startGame() {
        System.out.println("Game is started on the console.");
    }
}

class HomeTheaterFacade {
    private TV tv;
    private AudioSystem audioSystem;
    private DVDPlayer dvdPlayer;
    private GameConsole gameConsole;

    public HomeTheaterFacade(TV tv, AudioSystem audioSystem, DVDPlayer dvdPlayer, GameConsole gameConsole) {
        this.tv = tv;
        this.audioSystem = audioSystem;
        this.dvdPlayer = dvdPlayer;
        this.gameConsole = gameConsole;
    }

    public void watchMovie() {
        System.out.println("Setting up to watch a movie...");
        tv.turnOn();
        audioSystem.turnOn();
        dvdPlayer.play();
    }

    public void endMovie() {
        System.out.println("Shutting down movie mode...");
        dvdPlayer.stop();
        audioSystem.turnOff();
        tv.turnOff();
    }

    public void playGame() {
        System.out.println("Setting up to play a game...");
        tv.turnOn();
        audioSystem.turnOn();
        gameConsole.turnOn();
        gameConsole.startGame();
    }

    public void listenToMusic() {
        System.out.println("Setting up to listen to music...");
        tv.turnOn();
        audioSystem.turnOn();
        audioSystem.setVolume(5);
    }
}

public class Main {
    public static void main(String[] args) {
        TV tv = new TV();
        AudioSystem audioSystem = new AudioSystem();
        DVDPlayer dvdPlayer = new DVDPlayer();
        GameConsole gameConsole = new GameConsole();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(tv, audioSystem, dvdPlayer, gameConsole);

        homeTheater.watchMovie();

        homeTheater.endMovie();

        homeTheater.playGame();

        homeTheater.listenToMusic();
    }
}

import Core.*;
import IO.*;

public class Main {

    public static void main(String[] args) {
        UserInput userInputService = new ConsoleInputService();
        KeyPegsGeneration keyPegsGenerator = new KeyPegsGenerator();
        Mastermind traditionalMastermind = new TraditionalMastermind(80,keyPegsGenerator,userInputService);
        traditionalMastermind.start();
    }
}
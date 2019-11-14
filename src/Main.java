import Core.Mastermind;
import Core.TraditionalMastermind;
import IO.KeyPegsGeneration;
import IO.KeyPegsGenerator;
import IO.UserInputService;

public class Main {

    public static void main(String[] args) {
        UserInputService userInputService = new UserInputService();
        KeyPegsGeneration resultsFromUserPegs = new KeyPegsGenerator();
        Mastermind traditionalMastermind = new TraditionalMastermind(80,resultsFromUserPegs,userInputService);
        traditionalMastermind.start();
    }
}
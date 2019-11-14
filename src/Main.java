public class Main {

    public static void main(String[] args) {
        UserInputService userInputService = new UserInputService();
        KeyPegsService resultsFromUserPegs = new KeyUsersPegsService();
        Mastermind traditionalMastermind = new TraditionalMastermind(80,resultsFromUserPegs,userInputService);
        traditionalMastermind.start();
    }
}
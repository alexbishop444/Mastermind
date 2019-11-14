public class Main {

    public static void main(String[] args) {
        UserInputService userInputService = new UserInputService();
        ResultsFromPegs resultsFromUserPegs = new ResultsFromUsersPegs();
        Mastermind traditionalMastermind = new TraditionalMastermind(80,resultsFromUserPegs,userInputService);
        traditionalMastermind.start();
    }
}
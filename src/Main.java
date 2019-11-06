public class Main {

    public static void main(String[] args) {
        UserInput consoleUserInput = new ConsoleUserInput();
        ValidateInput traditionalInputValidation = new TraditionalInputValidation();
        ResultsFromPegs resultsFromUserPegs = new ResultsFromUsersPegs();
        ConvertInputToPegs convertInputToTraditionalPegs = new ConvertInputToTraditionalPegs();
        Mastermind traditionalMastermind = new TraditionalMastermind(80,convertInputToTraditionalPegs,resultsFromUserPegs,consoleUserInput,traditionalInputValidation);
        traditionalMastermind.start();
    }
}

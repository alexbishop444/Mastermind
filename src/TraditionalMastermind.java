import Models.CodePeg;
import Models.CodePegColour;
import Models.KeyPeg;
import Models.Result;

import java.util.ArrayList;

public class TraditionalMastermind implements Mastermind {

    int amountOfTurns;
    ResultsFromPegs resultsFromPegs;
    UserInput userInput;

    public TraditionalMastermind(int amountOfTurns, ResultsFromPegs resultsFromPegs, UserInput userInput) {
        this.amountOfTurns = amountOfTurns;
        this.resultsFromPegs = resultsFromPegs;
        this.userInput = userInput;
    }

    public Result start() {
        Result gameResult = Result.PLAYING;
        // new array = randomize()
        // loop that is reliant on turns set in constructor
        //
        ArrayList<CodePeg> userPegs = new ArrayList<>();
        ArrayList<CodePeg> computerPegs = randomizeComputersPegs();
        System.out.println(computerPegs.toString());
        do {
            String consoleInput = userInput.takeInput();
            if (userInput.isValidColour(consoleInput) && userInput.isValidLength(consoleInput)) {
                userPegs = userInput.convertInput(consoleInput);
            }

            //validation error messages here

            if (resultsFromPegs.getGameResult(userPegs, computerPegs) == Result.WIN) {
                System.out.println("WINNER");
            }

            ArrayList<KeyPeg> values = resultsFromPegs.getAndShuffleKeyPegsUsingCodePegs(userPegs,computerPegs);
            System.out.println(values);
            System.out.println(computerPegs);
            amountOfTurns -= 1;

        } while (amountOfTurns > 0);

        return gameResult;
    }

    private ArrayList<CodePeg> randomizeComputersPegs() {
        int max = 4;
        int min = 0;
        int range = max - min + 1;
        ArrayList<CodePeg> computerPegs = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int rand = (int) (Math.random() * range) + min;
            computerPegs.add(new CodePeg(CodePegColour.valueOf(rand)));
        }
        return computerPegs;

    }
}
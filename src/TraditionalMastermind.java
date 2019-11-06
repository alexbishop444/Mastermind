import Models.Peg;
import Models.Result;
import Models.UserPlacedPegValues;

import java.util.ArrayList;

public class TraditionalMastermind implements Mastermind {

    int amountOfTurns;
    ConvertInputToPegs convertInputToPegs;
    ResultsFromPegs resultsFromPegs;
    UserInput userInput;
    ValidateInput validateInput;

    public TraditionalMastermind(int amountOfTurns, ConvertInputToPegs convertInputToPegs, ResultsFromPegs resultsFromPegs, UserInput userInput, ValidateInput validateInput) {
        this.amountOfTurns = amountOfTurns;
        this.convertInputToPegs = convertInputToPegs;
        this.resultsFromPegs = resultsFromPegs;
        this.userInput = userInput;
        this.validateInput = validateInput;
    }

    public void start() {
        // new array = randomize()
        // loop that is reliant on turns set in constructor
        //
        ArrayList<Peg> userPegs = new ArrayList<>();
        ArrayList<Peg> computerPegs = randomizeComputersPegs();
        System.out.println(computerPegs.toString());
        do {
            String consoleInput = userInput.takeInput();
            if (validateInput.validate(consoleInput)) {
                userPegs = convertInputToPegs.convertInput(consoleInput);
            }

            //validation error messages here

            if (resultsFromPegs.getGameResult(userPegs, computerPegs) == Result.WIN) {
                System.out.println("WINNER");
            }

//            ArrayList<UserPlacedPegValues> values = resultsFromPegs.returnPlacedPegValues();
//            System.out.println(values);
            amountOfTurns -= 1;

        } while (amountOfTurns > 0);
    }

    private ArrayList<Peg> randomizeComputersPegs() {
        int max = 5;
        int min = 0;
        int range = max - min + 1;
        ArrayList<Peg> computerPegs = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int rand = (int) (Math.random() * range) + min;
            computerPegs.add(Peg.valueOf(rand));
        }
        return computerPegs;

    }
}
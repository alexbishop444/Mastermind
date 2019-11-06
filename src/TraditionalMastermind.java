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
        do {
            String consoleInput = userInput.takeInput();
            if(validateInput.validate(consoleInput)) {
                userPegs = convertInputToPegs.convertInput(consoleInput);
            }

            //validation error messages here

            if(resultsFromPegs.getGameResult(userPegs,computerpegs) == Result.WIN) {
                System.out.println("WINNER");
            }

            ArrayList<UserPlacedPegValues> values = resultsFromPegs.returnPlacedPegValues();
            System.out.println(values);
            amountOfTurns -= 1;

        }while(amountOfTurns > 0);
    }

    public ArrayList<Peg> randomizeComputersPegs() {
        return new ArrayList<Peg>();
    }
}

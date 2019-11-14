import Models.CodePeg;
import Models.CodePegColour;
import Models.KeyPeg;
import Models.Result;

import java.util.ArrayList;

public class TraditionalMastermind implements Mastermind {

    int amountOfTurns;
    KeyPegsService keyPegsService;
    UserInput userInput;

    public TraditionalMastermind(int amountOfTurns, KeyPegsService keyPegsService, UserInput userInput) {
        this.amountOfTurns = amountOfTurns;
        this.keyPegsService = keyPegsService;
        this.userInput = userInput;
    }

    public Result start() {
        Result gameResult = Result.PLAYING;
        ArrayList<CodePeg> userPegs = new ArrayList<>();
        ArrayList<CodePeg> computerPegs = randomizeComputersPegs();
        System.out.println(computerPegs.toString());
        do {
            String consoleInput = userInput.takeInput();
            if (userInput.isValidColour(consoleInput) && userInput.isValidLength(consoleInput)) {
                userPegs = userInput.convertInput(consoleInput);
            }

            if (getGameResult(userPegs, computerPegs) == Result.WIN) {
                System.out.println("WINNER");
                amountOfTurns = 0;
                gameResult = Result.WIN;
            }

            ArrayList<KeyPeg> values = keyPegsService.getAndShuffleKeyPegs(userPegs,computerPegs);
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

        for (int i = 0; i < max; i++) {
            int rand = (int) (Math.random() * range) + min;
            computerPegs.add(new CodePeg(CodePegColour.valueOf(rand)));
        }
        return computerPegs;

    }

    public Result getGameResult(ArrayList<CodePeg> userCodePegs, ArrayList<CodePeg> computersCodePegs) {
        if(userCodePegs.toString().equals(computersCodePegs.toString())) {
            return Result.WIN;
        }
        return Result.PLAYING;
    }
}
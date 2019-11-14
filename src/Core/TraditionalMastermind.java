package Core;

import IO.*;
import Models.*;


import java.util.ArrayList;

public class TraditionalMastermind implements Mastermind {

    private int amountOfTurns;
    private KeyPegsGeneration keyPegsGenerator;
    private UserInput userInput;
    private ArrayList<CodePeg> computerPegs = new ArrayList<>();
    private ArrayList<CodePeg> userPegs = new ArrayList<>();


    public TraditionalMastermind(int amountOfTurns, KeyPegsGeneration keyPegsGenerator, UserInput userInput) {
        this.amountOfTurns = amountOfTurns;
        this.keyPegsGenerator = keyPegsGenerator;
        this.userInput = userInput;
    }

    public Result start() {
        randomizeComputersPegs();
        Result gameResult = Result.PLAYING;
//        System.out.println(computerPegs.toString());
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

            ArrayList<KeyPeg> values = keyPegsGenerator.generateAndShuffleKeyPegs(userPegs,computerPegs);
            System.out.println(values);
            System.out.println(computerPegs);
            amountOfTurns -= 1;

        } while (amountOfTurns > 0);

        if(amountOfTurns == 0) {
            System.out.println("You have ran out of turns! The correct combination is " + computerPegs.toString());
            gameResult = Result.LOSS;
        }

        return gameResult;
    }

    private void randomizeComputersPegs() {
        int max = 4;
        int min = 0;
        int range = max - min + 1;

        for (int i = 0; i < max; i++) {
            int rand = (int) (Math.random() * range) + min;
            computerPegs.add(new CodePeg(CodePegColour.valueOf(rand)));
        }

    }

    private Result getGameResult(ArrayList<CodePeg> userCodePegs, ArrayList<CodePeg> computersCodePegs) {
        if(userCodePegs.toString().equals(computersCodePegs.toString())) {
            return Result.WIN;
        }
        return Result.PLAYING;
    }
}
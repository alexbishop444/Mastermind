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

    public void start() {
        randomizeComputersPegs();
        Result gameResult = Result.PLAYING;
//        System.out.println(computerPegs.toString());
        do {
            System.out.println(computerPegs);
            inputService();
            gameResult = getGameResult(userPegs,computerPegs);
            if(gameResult == Result.PLAYING) {
                getKeyPegs();
            }
        } while (gameResult == Result.PLAYING);
    }

    public Result getGameResult(ArrayList<CodePeg> userCodePegs, ArrayList<CodePeg> computersCodePegs) {
        if(userCodePegs.toString().equals(computersCodePegs.toString())) {
            System.out.println("WINNER");
            amountOfTurns = 0;
            return Result.WIN;
        } else if(amountOfTurns == 0) {
            System.out.println("You have ran out of turns! The correct combination is " + computerPegs.toString());
            return Result.LOSS;
        }
        return Result.PLAYING;
    }

    private void inputService() {
        String consoleInput = userInput.takeInput();
        if (userInput.isValidColour(consoleInput) && userInput.isValidLength(consoleInput)) {
            userPegs = userInput.convertInput(consoleInput);
            amountOfTurns -= 1;
        }
    }

    private void getKeyPegs() {
        ArrayList<KeyPeg> keyPegs = keyPegsGenerator.generateAndShuffleKeyPegs(userPegs,computerPegs);
        if(keyPegs.size() == 0) {
            System.out.println("You have no Key Pegs!");
        } else {
            System.out.println(keyPegs);
        }
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
}
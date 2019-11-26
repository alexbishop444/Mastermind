package Core;

import IO.*;
import Models.*;


import java.util.ArrayList;

public class TraditionalMastermind implements Mastermind {

    private int amountOfTurns;
    private KeyPegsGeneration keyPegsGenerator;
    private UserInput consoleInputService;


    public TraditionalMastermind(int amountOfTurns, KeyPegsGeneration keyPegsGenerator, UserInput consoleInputService) {
        this.amountOfTurns = amountOfTurns;
        this.keyPegsGenerator = keyPegsGenerator;
        this.consoleInputService = consoleInputService;
    }

    public void start() {
        ArrayList<CodePeg> computerPegs = randomizeComputersPegs();
        Result gameResult = Result.PLAYING;
        System.out.println(computerPegs.toString());
        do {
            String consoleInput = consoleInputService.takeInput();
            gameResult = playerTurn(consoleInput,computerPegs);
        } while (gameResult == Result.PLAYING);
    }

    public Result playerTurn(String userInput, ArrayList<CodePeg> computerPegs) {
        Result gameResult = Result.PLAYING;
        ArrayList<CodePeg> userPegs = new ArrayList<>();

        if (consoleInputService.isValidColour(userInput) && consoleInputService.isValidLength(userInput)) {
            userPegs = consoleInputService.convertInput(userInput);
            amountOfTurns -= 1;
        }

        gameResult = getGameResult(userPegs,computerPegs);

        if(gameResult == Result.PLAYING) {
            getKeyPegs(userPegs, computerPegs);
        }

        return gameResult;
    }

    public Result getGameResult(ArrayList<CodePeg> userCodePegs, ArrayList<CodePeg> computersCodePegs) {
        if(userCodePegs.toString().equals(computersCodePegs.toString())) {
            System.out.println("WINNER");
            amountOfTurns = 0;
            return Result.WIN;
        } else if(amountOfTurns == 0) {
            System.out.println("You have ran out of turns! The correct combination is " + computersCodePegs.toString());
            return Result.LOSS;
        }
        return Result.PLAYING;
    }

    private void getKeyPegs(ArrayList<CodePeg> userPegs, ArrayList<CodePeg> computerPegs) {
        ArrayList<KeyPeg> keyPegs = keyPegsGenerator.generateKeyPegs(userPegs,computerPegs);
        keyPegsGenerator.shuffleKeyPegs(keyPegs);
        if(keyPegs.size() == 0) {
            System.out.println("You have no Key Pegs!");
        } else {
            System.out.println(keyPegs);
        }
    }

    private ArrayList<CodePeg> randomizeComputersPegs() {
        ArrayList<CodePeg> computerPegs = new ArrayList<>();
        int max = 4;
        int min = 0;
        int range = max - min + 1;

        for (int i = 0; i < max; i++) {
            int rand = (int) (Math.random() * range) + min;
            computerPegs.add(new CodePeg(CodePegColour.valueOf(rand)));
        }
        return computerPegs;
    }
}
//import Models.CodePegColour;
//import Models.Result;
//
//import java.util.ArrayList;
//
//public class TraditionalMastermind implements Mastermind {
//
//    int amountOfTurns;
//    ConvertInputToPegs convertInputToPegs;
//    ResultsFromPegs resultsFromPegs;
//    UserInput userInput;
//    InputValidator inputValidator;
//
//    public TraditionalMastermind(int amountOfTurns, ConvertInputToPegs convertInputToPegs, ResultsFromPegs resultsFromPegs, UserInput userInput, InputValidator inputValidator) {
//        this.amountOfTurns = amountOfTurns;
//        this.convertInputToPegs = convertInputToPegs;
//        this.resultsFromPegs = resultsFromPegs;
//        this.userInput = userInput;
//        this.inputValidator = inputValidator;
//    }
//
//    public Result start() {
//        Result gameResult = Result.PLAYING;
//        // new array = randomize()
//        // loop that is reliant on turns set in constructor
//        //
//        ArrayList<CodePegColour> userPegs = new ArrayList<>();
//        ArrayList<CodePegColour> computerPegs = randomizeComputersPegs();
//        System.out.println(computerPegs.toString());
//        do {
//            String consoleInput = userInput.takeInput();
//            if (inputValidator.validate(consoleInput)) {
//                userPegs = convertInputToPegs.convertInput(consoleInput);
//            }
//
//            //validation error messages here
//
//            if (resultsFromPegs.getGameResult(userPegs, computerPegs) == Result.WIN) {
//                System.out.println("WINNER");
//            }
//
////            ArrayList<KeyPegColour> values = resultsFromPegs.returnPlacedPegValues();
////            System.out.println(values);
//            amountOfTurns -= 1;
//
//        } while (amountOfTurns > 0);
//
//        return gameResult;
//    }
//
//    private ArrayList<CodePegColour> randomizeComputersPegs() {
//        int max = 5;
//        int min = 0;
//        int range = max - min + 1;
//        ArrayList<CodePegColour> computerPegs = new ArrayList<>();
//
//        for (int i = 0; i < 5; i++) {
//            int rand = (int) (Math.random() * range) + min;
//            computerPegs.add(CodePegColour.valueOf(rand));
//        }
//        return computerPegs;
//
//    }
//}
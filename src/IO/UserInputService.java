package IO;

import Models.CodePeg;
import Models.CodePegColour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
@SuppressWarnings("Duplicates")

public class UserInputService implements UserInput {
    private Scanner scanner = new Scanner(System.in);
    private Map codePegMap = new HashMap<String,Integer>();

    public String takeInput() {
        ArrayList<String> pegs = new ArrayList<>();

        for (int i = 0; i < CodePegColour.values().length; i++) {
            pegs.add(CodePegColour.valueOf(i).toString());
        }

        System.out.println("Choose Four Pegs from " + pegs.toString().replace("[","").replace("]",""));

        return scanner.nextLine();
    }

    public Boolean isValidColour(String userInput) {
        String[] userPegs = userInput.toUpperCase().replace(" ","").split(",");
        for (int i = 0; i < CodePegColour.values().length; i++) {
            codePegMap.put(CodePegColour.valueOf(i).toString(), i);
        }

        for (String userChosenPeg:userPegs) {
//            System.out.println("CodePegColour: " + userChosenPeg + " | codePegMap: " + codePegMap.toString());  //FOR DEBUGGING
            if (!codePegMap.containsKey(userChosenPeg)) {
                System.out.println("Error: you have given an invalid colour!");
                return false;
            }
        }

        return true;
    }


    public Boolean isValidLength(String userInput) {
        String[] userPegs = userInput.toUpperCase().replace(" ","").split(",");
        if (userPegs.length != 4) {
            System.out.println("Error: you must pass Four colours!");
            return false;
        }
        return true;
    }

    public ArrayList<CodePeg> convertInput(String userInput) {
        ArrayList<CodePeg> convertedInputToCodePegs = new ArrayList<>();
        String[] userPegsInput = userInput.replace(" ","").split(",");
//        System.out.println(userPegsInput);
        for (int i = 0; i < CodePegColour.values().length; i++) {
            codePegMap.put(CodePegColour.valueOf(i).toString(), i);
        }
        for (String peg:userPegsInput) {
            if (!codePegMap.containsKey(peg)) {
                convertedInputToCodePegs.add(new CodePeg(CodePegColour.valueOf(peg.toUpperCase())));
            }
        }
        return convertedInputToCodePegs;
    }


}

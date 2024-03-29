package IO;

import Models.CodePeg;
import Models.CodePegColour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleInputService implements UserInput {
    private Scanner scanner = new Scanner(System.in);
    private Map codePegColourMap = new HashMap<String,Integer>();

    public String takeInput() {
        updateCodePegColoursMap();

        System.out.println("Choose four pegs from " + codePegColourMap.keySet());

        return scanner.nextLine();
    }

    public Boolean isValidColour(String userInput) {
        updateCodePegColoursMap();
        String[] userPegs = userInputStringToStringArray(userInput);

        for (String userChosenPeg:userPegs) {
//            System.out.println("CodePegColour: " + userChosenPeg + " | codePegColourMap: " + codePegColourMap.toString());  //FOR DEBUGGING
            if (!codePegColourMap.containsKey(userChosenPeg)) {
                System.out.println("Error: You have given an invalid colour!");
                return false;
            }
        }

        return true;
    }


    public Boolean isValidLength(String userInput) {
        String[] userPegs = userInputStringToStringArray(userInput);
        if (userPegs.length != 4) {
            System.out.println("Error: You must pass four colours!");
            return false;
        }
        return true;
    }

    private String[] userInputStringToStringArray(String userInput) {
        return userInput.toUpperCase().replace(" ","").split(",");
    }

    public ArrayList<CodePeg> convertInput(String userInput) {
        updateCodePegColoursMap();
        ArrayList<CodePeg> inputConvertedToCodePegs = new ArrayList<>();
        String[] userPegsInput = userInput.replace(" ","").split(",");

        for (String peg:userPegsInput) {
            if (!codePegColourMap.containsKey(peg)) {
                inputConvertedToCodePegs.add(new CodePeg(CodePegColour.valueOf(peg.toUpperCase())));
            }
        }

        return inputConvertedToCodePegs;
    }

    private void updateCodePegColoursMap() {
        for (int i = 0; i < CodePegColour.values().length; i++) {
            codePegColourMap.put(CodePegColour.valueOf(i).toString(), i);
        }
    }


}

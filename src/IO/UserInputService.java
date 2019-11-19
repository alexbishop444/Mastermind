package IO;

import Models.CodePeg;
import Models.CodePegColour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInputService implements UserInput {
    private Scanner scanner = new Scanner(System.in);
    private Map codePegColourMap = new HashMap<String,Integer>();

    public String takeInput() {
        updateCodePegColoursMap();

        System.out.println("Choose four pegs from " + codePegColourMap.keySet());

        return scanner.nextLine();
    }

    public Boolean isValidColour(String userInput) {
        String[] userPegs = userInput.toUpperCase().replace(" ","").split(",");
        updateCodePegColoursMap();

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
        String[] userPegs = userInput.toUpperCase().replace(" ","").split(",");
        if (userPegs.length != 4) {
            System.out.println("Error: You must pass four colours!");
            return false;
        }
        return true;
    }

    public ArrayList<CodePeg> convertInput(String userInput) {
        ArrayList<CodePeg> convertedInputToCodePegs = new ArrayList<>();
        String[] userPegsInput = userInput.replace(" ","").split(",");
        updateCodePegColoursMap();
        for (String peg:userPegsInput) {
            if (!codePegColourMap.containsKey(peg)) {
                convertedInputToCodePegs.add(new CodePeg(CodePegColour.valueOf(peg.toUpperCase())));
            }
        }
        return convertedInputToCodePegs;
    }

    private void updateCodePegColoursMap() {
        for (int i = 0; i < CodePegColour.values().length; i++) {
            codePegColourMap.put(CodePegColour.valueOf(i).toString(), i);
        }
    }


}

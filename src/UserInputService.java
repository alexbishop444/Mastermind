import Models.CodePegColour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
@SuppressWarnings("Duplicates")

public class UserInputService {
    private Scanner scanner = new Scanner(System.in);
    Map pegMap = new HashMap<String,Integer>();

    public String takeInput() {
        ArrayList<String> pegs = new ArrayList<>();

        for (int i = 0; i < CodePegColour.values().length; i++) {
            pegs.add(CodePegColour.valueOf(i).toString());
        }

        System.out.println("Choose five Pegs from " + pegs.toString().replace("[","").replace("]",""));

        return scanner.nextLine();
    }

    public Boolean isValidColour(String userInput) {
        String[] userPegs = userInput.toUpperCase().replace(" ","").split(",");
        for (int i = 0; i < CodePegColour.values().length; i++) {
            pegMap.put(CodePegColour.valueOf(i).toString(), i);
        }

        for (String userChosenPeg:userPegs) {
//            System.out.println("CodePegColour: " + userChosenPeg + " | pegMap: " + pegMap.toString());  //FOR DEBUGGING
            if (!pegMap.containsKey(userChosenPeg)) {
                System.out.println("Error: you have given an invalid colour!");
                return false;
            }
        }

        return true;
    }


    public Boolean isValidLength(String userInput) {
        String[] userPegs = userInput.toUpperCase().replace(" ","").split(",");
        if (userPegs.length != 4) {
            System.out.println("Error: you must pass 4 colours!");
            return false;
        }
        return true;
    }

    public ArrayList<CodePegColour> convertInput(String userInput) {
        ArrayList<CodePegColour> convertedInputToCodePegColours = new ArrayList<>();
        String[] userPegsInput = userInput.replace(" ","").split(",");
        System.out.println(userPegsInput);
        for (int i = 0; i < CodePegColour.values().length; i++) {
            pegMap.put(CodePegColour.valueOf(i).toString(), i);
        }
        for (String peg:userPegsInput) {
            if (!pegMap.containsKey(peg)) {
                convertedInputToCodePegColours.add(CodePegColour.valueOf(peg.toUpperCase()));
            }
        }
        return convertedInputToCodePegColours;
    }


}

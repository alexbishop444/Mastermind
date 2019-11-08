import Models.Peg;

import java.util.*;

public class TraditionalInputValidation implements ValidateInput {

    public Boolean validate(String userInput) {

        String[] userPegs = userInput.toUpperCase().replace(" ","").split(",");

        if (isValidColour(userPegs) && isValidLength(userPegs)) {
            return true;
        }

        return false;
    }
    private Boolean isValidColour(String[] userPegs) {

        Map pegMap = new HashMap<String,Integer>();
        for (int i = 0; i < Peg.values().length; i++) {
            pegMap.put(Peg.valueOf(i).toString(), i);
        }

        for (String userChosenPeg:userPegs) {
//            System.out.println("Peg: " + userChosenPeg + " | pegMap: " + pegMap.toString());  //FOR DEBUGGING
            if (!pegMap.containsKey(userChosenPeg)) {
                System.out.println("Error: you have given an invalid colour!");
                return false;
            }
        }

        return true;
    }


    private Boolean isValidLength(String[] userPegs) {
        if (userPegs.length > 5) {
            System.out.println("Error: you must pass 4 colours!");
            return false;
        }
        return true;
    }
}

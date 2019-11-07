import Models.Peg;

import java.lang.reflect.Array;
import java.util.*;

public class TraditionalInputValidation implements ValidateInput {

    public Boolean validate(String userInput) {
        return false;
    }
    public Boolean isValidColour(String userInput) {
        ArrayList<String> userPegsArray = new ArrayList<>();
        String[] userPegs = userInput.toUpperCase().split(",");
        for (String peg: userPegs) {
            userPegsArray.add(peg);
        }

        Map pegMap = new HashMap<String,Integer>();
        for (int i = 0; i < Peg.values().length; i++) {
            pegMap.put(Peg.valueOf(i).toString(), i);
        }

        for (String peg:userPegs) {
            System.out.println("Peg: " + peg + " | pegMap: " + pegMap.toString());
            if (pegMap.containsKey(peg)) {
                System.out.println("ayyyayay");
                return true;
            }
        }
        return false;
    }

//    public Boolean isValidColour(String userInput) {
//        List<String> userPegsArray = Arrays.asList(userInput.toUpperCase().split(","));
//        ArrayList<String> pegs = new ArrayList<>();
//
//        for (int i = 0; i < Peg.values().length; i++) {
//            pegs.add(Peg.valueOf(i).toString());
//        }
//        System.out.println(pegs);
//        System.out.println(userPegsArray);
//        return pegs.containsAll(userPegsArray);
//    }
    public Boolean isValidLength(String userInput) {
        String[] userPegs = userInput.toUpperCase().split(",");
        if(userPegs.length > 5) {
            return false;
        }
        return true;
    }
}

import Models.Peg;

import java.util.ArrayList;

public class ConvertInputToTraditionalPegs implements ConvertInputToPegs {

    public ArrayList<Peg> convertInput(String userInput) {
        ArrayList<Peg> userPegs = new ArrayList<>();
        String[] userPegs1 = userInput.split(",");
        System.out.println(userPegs1);
        for (String peg:userPegs1) {
            switch (peg) {
                case "Red":
                    userPegs.add(Peg.RED);
                    break;
                case "Blue":
                    userPegs.add(Peg.BLUE);
                    break;
                case "Green":
                    userPegs.add(Peg.GREEN);
                    break;
                case "Orange":
                    userPegs.add(Peg.ORANGE);
                    break;
                case "Purple":
                    userPegs.add(Peg.PURPLE);
                    break;
                case "Yellow":
                    userPegs.add(Peg.YELLOW);
                    break;
            }
        }
        return userPegs;
    }
}

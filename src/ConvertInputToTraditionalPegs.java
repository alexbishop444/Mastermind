import Models.Peg;

import java.util.ArrayList;

public class ConvertInputToTraditionalPegs implements ConvertInputToPegs {

    public ArrayList<Peg> convertInput(String userInput) {
        ArrayList<Peg> convertedInputToPegs = new ArrayList<>();
        String[] userPegsInput = userInput.replace(" ","").split(",");
        System.out.println(userPegsInput);
        for (String peg:userPegsInput) {
            switch (peg) {
                case "Red":
                    convertedInputToPegs.add(Peg.RED);
                    break;
                case "Blue":
                    convertedInputToPegs.add(Peg.BLUE);
                    break;
                case "Green":
                    convertedInputToPegs.add(Peg.GREEN);
                    break;
                case "Orange":
                    convertedInputToPegs.add(Peg.ORANGE);
                    break;
                case "Purple":
                    convertedInputToPegs.add(Peg.PURPLE);
                    break;
                case "Yellow":
                    convertedInputToPegs.add(Peg.YELLOW);
                    break;
            }
        }
        return convertedInputToPegs;
    }
}

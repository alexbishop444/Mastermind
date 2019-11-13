import Models.CodePegColour;
import Models.KeyPegColour;
import Models.Result;

import java.util.ArrayList;

public class ResultsFromUsersPegs implements ResultsFromPegs {
    public Result getGameResult(ArrayList<CodePegColour> codePegColours, ArrayList<CodePegColour> computersCodePegColours) {
        if(codePegColours.equals(computersCodePegColours)) {
            return Result.WIN;
        }
        return Result.PLAYING;
    }

    public ArrayList<KeyPegColour> returnPlacedPegValues(ArrayList<CodePegColour> usersCodePegColours, ArrayList<CodePegColour> computersCodePegColours) {

        ArrayList<KeyPegColour> blackValues = new ArrayList<>();
        ArrayList<KeyPegColour> whiteValues = new ArrayList<>();
        ArrayList<CodePegColour> remainingUserCodePegColours = new ArrayList<>();
        ArrayList<CodePegColour> remainingComputerCodePegColours = new ArrayList<>();

        for (int i = 0; i < usersCodePegColours.size(); i++) {
            if (usersCodePegColours.get(i) == computersCodePegColours.get(i)) {
                blackValues.add(KeyPegColour.BLACK);
            } else {
                remainingUserCodePegColours.add(usersCodePegColours.get(i));
                remainingComputerCodePegColours.add(computersCodePegColours.get(i));
            }
        }

        for (CodePegColour userCodePegColour : remainingUserCodePegColours) {
            for (CodePegColour remainingCodePegColour : remainingComputerCodePegColours) {
                if (userCodePegColour.equals(remainingCodePegColour)) {
                    whiteValues.add(KeyPegColour.WHITE);
                    break;
                }
            }
        }

        System.out.println("users is " + remainingUserCodePegColours);
        System.out.println("computers is " + remainingComputerCodePegColours);
        System.out.println(blackValues);
        System.out.println(whiteValues);

        return blackValues;
    }

    public ArrayList<KeyPegColour> shuffleResult(ArrayList<KeyPegColour> resultsWhite, ArrayList<KeyPegColour> resultsBlack) {

        return new ArrayList<KeyPegColour>();
    }
}

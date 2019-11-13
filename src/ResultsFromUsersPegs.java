import Models.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ResultsFromUsersPegs implements ResultsFromPegs {
    public Result getGameResult(ArrayList<CodePegColour> codePegColours, ArrayList<CodePegColour> computersCodePegColours) {
        if(codePegColours.equals(computersCodePegColours)) {
            return Result.WIN;
        }
        return Result.PLAYING;
    }

    public ArrayList<KeyPeg> returnPlacedPegValues(ArrayList<CodePeg> usersCodePegs, ArrayList<CodePeg> computersCodePegs) {

        ArrayList<KeyPeg> blackValues = new ArrayList<>();
        ArrayList<KeyPeg> whiteValues = new ArrayList<>();
        ArrayList<CodePeg> remainingUserCodePegs = new ArrayList<>();
        ArrayList<CodePeg> remainingComputerCodePegs = new ArrayList<>();

        for (int i = 0; i < usersCodePegs.size(); i++) {
            if (usersCodePegs.get(i).getCodePegColour() == computersCodePegs.get(i).getCodePegColour()) {
                blackValues.add(new KeyPeg(KeyPegColour.BLACK));
            } else {
                remainingUserCodePegs.add(usersCodePegs.get(i));
                remainingComputerCodePegs.add(computersCodePegs.get(i));
            }
        }

        for (CodePeg userCodePeg : remainingUserCodePegs) {
            for (CodePeg remainingCodePegColour : remainingComputerCodePegs) {
                if (userCodePeg.getCodePegColour().equals(remainingCodePegColour.getCodePegColour())) {
                    whiteValues.add(new KeyPeg(KeyPegColour.WHITE));
                    break;
                }
            }
        }

        System.out.println("users is " + remainingUserCodePegs);
        System.out.println("computers is " + remainingComputerCodePegs);
        System.out.println(blackValues);
        System.out.println(whiteValues);

        return blackValues;
    }

    public ArrayList<KeyPegColour> shuffleResult(ArrayList<KeyPegColour> resultsWhite, ArrayList<KeyPegColour> resultsBlack) {

        return new ArrayList<KeyPegColour>();
    }
}

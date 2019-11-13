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

    public ArrayList<KeyPeg> getKeyPegs(ArrayList<CodePeg> usersCodePegs, ArrayList<CodePeg> computersCodePegs) {

        ArrayList<KeyPeg> blackKeyPegs = new ArrayList<>();
        ArrayList<KeyPeg> whiteKeyPegs = new ArrayList<>();
        ArrayList<KeyPeg> keyPegs = new ArrayList<>();
        ArrayList<CodePeg> remainingUserCodePegs = new ArrayList<>();
        ArrayList<CodePeg> remainingComputerCodePegs = new ArrayList<>();

        for (int i = 0; i < usersCodePegs.size(); i++) {
            if (usersCodePegs.get(i).getCodePegColour() == computersCodePegs.get(i).getCodePegColour()) {
                blackKeyPegs.add(new KeyPeg(KeyPegColour.BLACK));
            } else {
                remainingUserCodePegs.add(usersCodePegs.get(i));
                remainingComputerCodePegs.add(computersCodePegs.get(i));
            }
        }

        for (CodePeg userCodePeg : remainingUserCodePegs) {
            for (CodePeg remainingComputerCodePeg : remainingComputerCodePegs) {
                if (userCodePeg.getCodePegColour().equals(remainingComputerCodePeg.getCodePegColour())) {
                    whiteKeyPegs.add(new KeyPeg(KeyPegColour.WHITE));
                    break;
                }
            }
        }

        System.out.println("users is " + remainingUserCodePegs);
        System.out.println("computers is " + remainingComputerCodePegs);
        System.out.println(blackKeyPegs);
        System.out.println(whiteKeyPegs);

        keyPegs.addAll(0,blackKeyPegs);
        keyPegs.addAll(0,whiteKeyPegs);

        return keyPegs;
    }

    public ArrayList<KeyPegColour> shuffleResult(ArrayList<KeyPegColour> resultsWhite, ArrayList<KeyPegColour> resultsBlack) {

        return new ArrayList<KeyPegColour>();
    }
}

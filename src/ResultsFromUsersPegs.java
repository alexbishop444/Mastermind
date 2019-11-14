import Models.*;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ResultsFromUsersPegs implements ResultsFromPegs {
    public Result getGameResult(ArrayList<CodePegColour> codePegColours, ArrayList<CodePegColour> computersCodePegColours) {
        if(codePegColours.equals(computersCodePegColours)) {
            return Result.WIN;
        }
        return Result.PLAYING;
    }

    public ArrayList<KeyPeg> getAndShuffleKeyPegsUsingCodePegs(ArrayList<CodePeg> usersCodePegs, ArrayList<CodePeg> computersCodePegs) {

        ArrayList<KeyPeg> keyPegs = new ArrayList<>();
        ArrayList<KeyPeg> blackKeyPegs = new ArrayList<>();
        ArrayList<KeyPeg> whiteKeyPegs = new ArrayList<>();
        ArrayList<CodePeg> userCodePegsRemainingAfterBlackKeyPegsFound = new ArrayList<>();
        ArrayList<CodePeg> ComputerCodePegsRemainingAfterBlackKeyPegsFound = new ArrayList<>();

        for (int i = 0; i < usersCodePegs.size(); i++) {
            if (usersCodePegs.get(i).getCodePegColour() == computersCodePegs.get(i).getCodePegColour()) {
                blackKeyPegs.add(new KeyPeg(KeyPegColour.BLACK));
            } else {
                userCodePegsRemainingAfterBlackKeyPegsFound.add(usersCodePegs.get(i));
                ComputerCodePegsRemainingAfterBlackKeyPegsFound.add(computersCodePegs.get(i));
            }
        }

        for (CodePeg userCodePeg : userCodePegsRemainingAfterBlackKeyPegsFound) {
            for (CodePeg remainingComputerCodePeg : ComputerCodePegsRemainingAfterBlackKeyPegsFound) {
                if (userCodePeg.getCodePegColour().equals(remainingComputerCodePeg.getCodePegColour())) {
                    whiteKeyPegs.add(new KeyPeg(KeyPegColour.WHITE));
                    break;
                }
            }
        }

        keyPegs.addAll(0,blackKeyPegs);
        keyPegs.addAll(0,whiteKeyPegs);
        Collections.shuffle(keyPegs);
        return keyPegs;
    }
}

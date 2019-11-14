import Models.*;

import java.util.ArrayList;
import java.util.Collections;

public class KeyUsersPegsService implements KeyPegsService {

    private ArrayList<KeyPeg> keyPegs = new ArrayList<>();
    private ArrayList<CodePeg> userCodePegsLeftAfterBlackPegsAdded = new ArrayList<>();
    private ArrayList<CodePeg> computerCodePegsLeftAfterBlackPegsAdded = new ArrayList<>();

    public ArrayList<KeyPeg> getAndShuffleKeyPegs(ArrayList<CodePeg> usersCodePegs, ArrayList<CodePeg> computersCodePegs) {

        addBlackKeyPegs(usersCodePegs, computersCodePegs);
        addWhiteKeyPegs();

        Collections.shuffle(keyPegs);
        return keyPegs;
    }


    private void addBlackKeyPegs(ArrayList<CodePeg> usersCodePegs, ArrayList<CodePeg> computersCodePegs) {
        for (int i = 0; i < usersCodePegs.size(); i++) {
            if (usersCodePegs.get(i).getCodePegColour() == computersCodePegs.get(i).getCodePegColour()) {
                keyPegs.add(new KeyPeg(KeyPegColour.BLACK));
            } else {
                userCodePegsLeftAfterBlackPegsAdded.add(usersCodePegs.get(i));
                computerCodePegsLeftAfterBlackPegsAdded.add(computersCodePegs.get(i));
            }
        }
    }

    private void addWhiteKeyPegs() {
        for (CodePeg userCodePeg : userCodePegsLeftAfterBlackPegsAdded) {
            for (CodePeg remainingComputerCodePeg : computerCodePegsLeftAfterBlackPegsAdded) {
                if (userCodePeg.getCodePegColour().equals(remainingComputerCodePeg.getCodePegColour())) {
                    computerCodePegsLeftAfterBlackPegsAdded.remove(remainingComputerCodePeg);
                    keyPegs.add(new KeyPeg(KeyPegColour.WHITE));
                    break;
                }
            }
        }
    }

}

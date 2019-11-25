package IO;

import Models.*;

import java.util.ArrayList;
import java.util.Collections;

public class KeyPegsGenerator implements KeyPegsGeneration {
    //pull out what i can here
    private ArrayList<KeyPeg> keyPegs = new ArrayList<>();
    private ArrayList<CodePeg> userCodePegsLeftAfterBlackPegsAdded = new ArrayList<>();
    private ArrayList<CodePeg> computerCodePegsLeftAfterBlackPegsAdded = new ArrayList<>();

    public ArrayList<KeyPeg> generateAndShuffleKeyPegs(ArrayList<CodePeg> usersCodePegs, ArrayList<CodePeg> computersCodePegs) {
        //take in computerpegs in constructor
        keyPegs.clear();
        generateBlackKeyPegs(usersCodePegs, computersCodePegs);
        generateWhiteKeyPegs();
        //seperate out for tests

        Collections.shuffle(keyPegs);
        userCodePegsLeftAfterBlackPegsAdded.clear();
        computerCodePegsLeftAfterBlackPegsAdded.clear();

        return keyPegs;
    }

   //put arrays in method
    private void generateBlackKeyPegs(ArrayList<CodePeg> usersCodePegs, ArrayList<CodePeg> computersCodePegs) {
        for (int i = 0; i < usersCodePegs.size(); i++) {
            if (usersCodePegs.get(i).getCodePegColour() == computersCodePegs.get(i).getCodePegColour()) {
                keyPegs.add(new KeyPeg(KeyPegColour.BLACK));
            } else {
                userCodePegsLeftAfterBlackPegsAdded.add(usersCodePegs.get(i));
                computerCodePegsLeftAfterBlackPegsAdded.add(computersCodePegs.get(i));
            }
        }
    }

    private void generateWhiteKeyPegs() {
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

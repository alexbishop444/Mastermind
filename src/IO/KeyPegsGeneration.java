package IO;

import Models.*;

import java.util.ArrayList;
import java.util.Collections;

public interface KeyPegsGeneration {
    ArrayList<KeyPeg> generateKeyPegs(ArrayList<CodePeg> usersCodePeg, ArrayList<CodePeg> computersCodePegColours);
    void shuffleKeyPegs(ArrayList<KeyPeg> keyPegs);
}
package IO;

import Models.*;

import java.util.ArrayList;

public interface KeyPegsGeneration {
    ArrayList<KeyPeg> generateAndShuffleKeyPegs(ArrayList<CodePeg> usersCodePeg, ArrayList<CodePeg> computersCodePegColours);
}
import Models.*;

import java.util.ArrayList;

public interface KeyPegsService {
    ArrayList<KeyPeg> getAndShuffleKeyPegs(ArrayList<CodePeg> usersCodePeg, ArrayList<CodePeg> computersCodePegColours);
}

//This interface needs to be changed, not sure about the return result one.
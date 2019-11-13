import Models.*;

import java.util.ArrayList;

public interface ResultsFromPegs {
    Result getGameResult(ArrayList<CodePegColour> codePegColours, ArrayList<CodePegColour> computersCodePegColours);
    ArrayList<KeyPeg> getKeyPegs(ArrayList<CodePeg> usersCodePeg, ArrayList<CodePeg> computersCodePegColours);
}

//This interface needs to be changed, not sure about the return result one.
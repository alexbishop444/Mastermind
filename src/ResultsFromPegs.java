import Models.CodePegColour;
import Models.KeyPegColour;
import Models.Result;

import java.util.ArrayList;

public interface ResultsFromPegs {
    Result getGameResult(ArrayList<CodePegColour> codePegColours, ArrayList<CodePegColour> computersCodePegColours);
    ArrayList<KeyPegColour> returnPlacedPegValues(ArrayList<CodePegColour> usersCodePegColours, ArrayList<CodePegColour> computersCodePegColours);
}

//This interface needs to be changed, not sure about the return result one.
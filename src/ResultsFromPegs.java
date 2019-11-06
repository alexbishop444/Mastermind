import Models.Peg;
import Models.Result;
import Models.UserPlacedPegValues;

import java.util.ArrayList;

public interface ResultsFromPegs {
    Result getGameResult(ArrayList<Peg> pegs, ArrayList<Peg> computersPegs);
    ArrayList<UserPlacedPegValues> returnPlacedPegValues(ArrayList<Peg> usersPegs, ArrayList<Peg> computersPegs);
}

//This interface needs to be changed, not sure about the return result one.
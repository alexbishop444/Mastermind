import Models.Peg;
import Models.UserPlacedPegValues;
import Models.Result;

import java.util.ArrayList;

public class ResultsFromUsersPegs implements ResultsFromPegs {
    public Result getGameResult(ArrayList<Peg> pegs, ArrayList<Peg> computersPegs) {
        return Result.PLAYING;
    }

    public ArrayList<UserPlacedPegValues> returnPlacedPegValues(ArrayList<Peg> usersPegs, ArrayList<Peg> computersPegs) {

        return new ArrayList<UserPlacedPegValues>();
    }

    public ArrayList<UserPlacedPegValues> returnEachCorrectlyChosenColouredPegsResultAsWhite(ArrayList<Peg> pegs) {

        return new ArrayList<UserPlacedPegValues>();

    }

    public ArrayList<UserPlacedPegValues> returnEachCorrectlyPlacedPegsResultAsBlack(ArrayList<Peg> pegs) {

        return new ArrayList<UserPlacedPegValues>();
    }

    public ArrayList<UserPlacedPegValues> shuffleResult(ArrayList<Result> resultsWhite, ArrayList<Result> resultsBlack) {

        return new ArrayList<UserPlacedPegValues>();
    }
}

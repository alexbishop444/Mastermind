import Models.Peg;
import Models.UserPlacedPegValues;
import Models.Result;

import java.util.ArrayList;

public class ResultsFromUsersPegs implements ResultsFromPegs {
    public Result getGameResult(ArrayList<Peg> pegs, ArrayList<Peg> computersPegs) {
        if(pegs.equals(computersPegs)) {
            return Result.WIN;
        }
        return Result.PLAYING;
    }

    public ArrayList<UserPlacedPegValues> returnPlacedPegValues(ArrayList<Peg> usersPegs, ArrayList<Peg> computersPegs) {

        return new ArrayList<UserPlacedPegValues>();
    }

    public ArrayList<UserPlacedPegValues> returnEachCorrectlyChosenColouredPegsResultAsWhite(ArrayList<Peg> usersPegs, ArrayList<Peg> computersPegs) {
        ArrayList<UserPlacedPegValues> whiteValues = new ArrayList<>();
        for (int i = 0; i < usersPegs.size() ; i++) {
            for (int j = 1; j < usersPegs.size() ; j++) {
                if(usersPegs.get(i) == computersPegs.get(j)) {
                    whiteValues.add(UserPlacedPegValues.WHITE);
                }
            }
        }

        return whiteValues;

    }

    public ArrayList<UserPlacedPegValues> returnEachCorrectlyPlacedPegsResultAsBlack(ArrayList<Peg> usersPegs, ArrayList<Peg> computersPegs) {
        ArrayList<UserPlacedPegValues> blackValues = new ArrayList<>();
        for (int i = 0; i <usersPegs.size() ; i++) {
                if(usersPegs.get(i) == computersPegs.get(i)) {
                    blackValues.add(UserPlacedPegValues.BLACK);
                }
        }
        System.out.println(blackValues);
        return blackValues;
    }

    public ArrayList<UserPlacedPegValues> shuffleResult(ArrayList<UserPlacedPegValues> resultsWhite, ArrayList<UserPlacedPegValues> resultsBlack) {

        return new ArrayList<UserPlacedPegValues>();
    }
}

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

        ArrayList<UserPlacedPegValues> blackValues = new ArrayList<>();
        ArrayList<UserPlacedPegValues> whiteValues = new ArrayList<>();
        ArrayList<Peg> remainingUserPegs = new ArrayList<>();
        ArrayList<Peg> remainingComputerPegs = new ArrayList<>();

        for (int i = 0; i < usersPegs.size(); i++) {
            if (usersPegs.get(i) == computersPegs.get(i)) {
                blackValues.add(UserPlacedPegValues.BLACK);
            } else {
                remainingUserPegs.add(usersPegs.get(i));
                remainingComputerPegs.add(computersPegs.get(i));
            }
        }

        for (Peg userPeg : remainingUserPegs) {
            for (Peg remainingPeg : remainingComputerPegs) {
                if (userPeg.equals(remainingPeg)) {
                    whiteValues.add(UserPlacedPegValues.WHITE);
                    break;
                }
            }
        }

        System.out.println("users is " + remainingUserPegs);
        System.out.println("computers is " + remainingComputerPegs);
        System.out.println(blackValues);
        System.out.println(whiteValues);

        return blackValues;
    }

    public ArrayList<UserPlacedPegValues> shuffleResult(ArrayList<UserPlacedPegValues> resultsWhite, ArrayList<UserPlacedPegValues> resultsBlack) {

        return new ArrayList<UserPlacedPegValues>();
    }
}

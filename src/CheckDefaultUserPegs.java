import java.util.ArrayList;

public class CheckDefaultUserPegs implements CheckUserPegs {
    public Boolean isWin(ArrayList<Peg> pegs) {
        return false;
    }

    public ArrayList<Result> ReturnResult(ArrayList<Peg> pegs) {
        return new ArrayList<Result>();
    }
}

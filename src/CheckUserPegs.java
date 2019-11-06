import java.util.ArrayList;

public interface CheckUserPegs {
    Boolean isWin(ArrayList<Peg> pegs);
    ArrayList<Result> returnResult(ArrayList<Peg> pegs);
}

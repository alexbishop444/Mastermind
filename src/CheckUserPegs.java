import java.util.ArrayList;

public interface CheckUserPegs {
    Boolean isWin(ArrayList<Peg> pegs);
    ArrayList<Result> ReturnResult(ArrayList<Peg> pegs);
}

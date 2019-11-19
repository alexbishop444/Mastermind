package Core;

import Models.CodePeg;
import Models.Result;

import java.util.ArrayList;

public interface Mastermind {
    void start();
    Result getGameResult(ArrayList<CodePeg> userCodePegs, ArrayList<CodePeg> computersCodePegs);
}

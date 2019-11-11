import Models.Peg;
import Models.UserPlacedPegValues;
import Models.Result;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ResultsFromPegsTests {

    private ResultsFromUsersPegs check = new ResultsFromUsersPegs();

    @Test
    public void returnResultOfOneBlackAndTwoWhite() {
        ArrayList<Peg> userPegs = new ArrayList<>();
        userPegs.add(Peg.BLUE);
        userPegs.add(Peg.ORANGE);
        userPegs.add(Peg.YELLOW);
        userPegs.add(Peg.RED);
        userPegs.add(Peg.BLUE);
        ArrayList<Peg> computerPegs = new ArrayList<>();
        computerPegs.add(Peg.BLUE);
        computerPegs.add(Peg.YELLOW);
        computerPegs.add(Peg.PURPLE);
        computerPegs.add(Peg.PURPLE);
        computerPegs.add(Peg.RED);
        ArrayList<UserPlacedPegValues> actual = check.returnPlacedPegValues(userPegs, computerPegs);
        ArrayList<UserPlacedPegValues> expected = new ArrayList<>();
        expected.add(UserPlacedPegValues.BLACK);
        expected.add(UserPlacedPegValues.WHITE);
        expected.add(UserPlacedPegValues.WHITE);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void returnWin() {
        ArrayList<Peg> userPegs = new ArrayList<>();
        userPegs.add(Peg.BLUE);
        userPegs.add(Peg.ORANGE);
        userPegs.add(Peg.YELLOW);
        userPegs.add(Peg.RED);
        userPegs.add(Peg.BLUE);
        ArrayList<Peg> computerPegs = new ArrayList<>();
        computerPegs.add(Peg.BLUE);
        computerPegs.add(Peg.ORANGE);
        computerPegs.add(Peg.YELLOW);
        computerPegs.add(Peg.RED);
        computerPegs.add(Peg.BLUE);
        Result actual = check.getGameResult(userPegs, computerPegs);
        Assert.assertEquals(Result.WIN,actual);
    }

    @Test
    public void TETSTSTSTTST() {
        ArrayList<Peg> userPegs = new ArrayList<>();
        userPegs.add(Peg.RED);
        userPegs.add(Peg.ORANGE);
        userPegs.add(Peg.BLUE);
        userPegs.add(Peg.RED);
        ArrayList<Peg> computerPegs = new ArrayList<>();
        computerPegs.add(Peg.BLUE);
        computerPegs.add(Peg.ORANGE);
        computerPegs.add(Peg.YELLOW);
        computerPegs.add(Peg.RED);
        ArrayList actual = check.returnEachCorrectlyPlacedPegsResultAsBlack(userPegs, computerPegs);
        System.out.println(actual);
    }
}

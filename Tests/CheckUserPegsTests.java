import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CheckUserPegsTests {

    CheckDefaultUserPegs check = new CheckDefaultUserPegs();

    @Test
    public void ReturnResultOfOneBlackAndTwoWhite() {
        ArrayList<Peg> pegs = new ArrayList<>();
        pegs.add(Peg.BLUE);
        pegs.add(Peg.ORANGE);
        pegs.add(Peg.YELLOW);
        pegs.add(Peg.RED);
        pegs.add(Peg.BLUE);
        ArrayList<Result> actual = check.ReturnResult(pegs);
        ArrayList<Result> expected = new ArrayList<>();
        expected.add(Result.BLACK);
        expected.add(Result.WHITE);
        expected.add(Result.WHITE);
        Assert.assertEquals(expected,actual);
    }
}

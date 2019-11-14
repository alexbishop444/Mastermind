import Models.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;

public class MastermindTests {
        @Test
    public void winResultReturnedTest() {
        ArrayList<CodePeg> userCodePegColours = new ArrayList<>();
        userCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        userCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        userCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        userCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        ArrayList<CodePeg> computerCodePegColours = new ArrayList<>();
        computerCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        computerCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        computerCodePegColours.add(new CodePeg(CodePegColour.BLUE));
//        computerCodePegColours.add(new CodePeg(CodePegColour.BLUE));
//        Result actual = check.getGameResult(userCodePegColours,computerCodePegColours);
//        Result expected = Result.WIN;
//        Assert.assertEquals(expected,actual);
    }
}

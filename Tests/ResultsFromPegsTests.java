import Models.CodePegColour;
import Models.KeyPegColour;
import Models.Result;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ResultsFromPegsTests {

    private ResultsFromUsersPegs check = new ResultsFromUsersPegs();

    @Test
    public void returnResultOfOneBlackAndTwoWhite() {
        ArrayList<CodePegColour> userCodePegColours = new ArrayList<>();
        userCodePegColours.add(CodePegColour.BLUE);
        userCodePegColours.add(CodePegColour.ORANGE);
        userCodePegColours.add(CodePegColour.YELLOW);
        userCodePegColours.add(CodePegColour.RED);
        userCodePegColours.add(CodePegColour.BLUE);
        ArrayList<CodePegColour> computerCodePegColours = new ArrayList<>();
        computerCodePegColours.add(CodePegColour.BLUE);
        computerCodePegColours.add(CodePegColour.YELLOW);
        computerCodePegColours.add(CodePegColour.PURPLE);
        computerCodePegColours.add(CodePegColour.PURPLE);
        computerCodePegColours.add(CodePegColour.RED);
        ArrayList<KeyPegColour> actual = check.returnPlacedPegValues(userCodePegColours, computerCodePegColours);
        ArrayList<KeyPegColour> expected = new ArrayList<>();
        expected.add(KeyPegColour.BLACK);
        expected.add(KeyPegColour.WHITE);
        expected.add(KeyPegColour.WHITE);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void returnWin() {
        ArrayList<CodePegColour> userCodePegColours = new ArrayList<>();
        userCodePegColours.add(CodePegColour.BLUE);
        userCodePegColours.add(CodePegColour.ORANGE);
        userCodePegColours.add(CodePegColour.YELLOW);
        userCodePegColours.add(CodePegColour.RED);
        userCodePegColours.add(CodePegColour.BLUE);
        ArrayList<CodePegColour> computerCodePegColours = new ArrayList<>();
        computerCodePegColours.add(CodePegColour.BLUE);
        computerCodePegColours.add(CodePegColour.ORANGE);
        computerCodePegColours.add(CodePegColour.YELLOW);
        computerCodePegColours.add(CodePegColour.RED);
        computerCodePegColours.add(CodePegColour.BLUE);
        Result actual = check.getGameResult(userCodePegColours, computerCodePegColours);
        Assert.assertEquals(Result.WIN,actual);
    }

    @Test
    public void TETSTSTSTTST() {
        ArrayList<CodePegColour> userCodePegColours = new ArrayList<>();
        userCodePegColours.add(CodePegColour.RED);
        userCodePegColours.add(CodePegColour.ORANGE);
        userCodePegColours.add(CodePegColour.BLUE);
        userCodePegColours.add(CodePegColour.RED);
        ArrayList<CodePegColour> computerCodePegColours = new ArrayList<>();
        computerCodePegColours.add(CodePegColour.BLUE);
        computerCodePegColours.add(CodePegColour.ORANGE);
        computerCodePegColours.add(CodePegColour.YELLOW);
        computerCodePegColours.add(CodePegColour.RED);
        ArrayList actual = check.returnPlacedPegValues(userCodePegColours, computerCodePegColours);
    }
    @Test
    public void TETSTSTSTTSrf() {
        ArrayList<CodePegColour> userCodePegColours = new ArrayList<>();
        userCodePegColours.add(CodePegColour.RED);
        userCodePegColours.add(CodePegColour.RED);
        userCodePegColours.add(CodePegColour.GREEN);
        userCodePegColours.add(CodePegColour.RED);
        ArrayList<CodePegColour> computerCodePegColours = new ArrayList<>();
        computerCodePegColours.add(CodePegColour.GREEN);
        computerCodePegColours.add(CodePegColour.RED);
        computerCodePegColours.add(CodePegColour.RED);
        computerCodePegColours.add(CodePegColour.RED);
        ArrayList actual = check.returnPlacedPegValues(userCodePegColours, computerCodePegColours);
    }
}

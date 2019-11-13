import Models.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ResultsFromPegsTests {

    private ResultsFromUsersPegs check = new ResultsFromUsersPegs();

    @Test
    public void returnResultOfOneBlackAndTwoWhite() {
        ArrayList<CodePeg> userCodePegColours = new ArrayList<>();
        userCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        userCodePegColours.add(new CodePeg(CodePegColour.ORANGE));
        userCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        userCodePegColours.add(new CodePeg(CodePegColour.RED));
        ArrayList<CodePeg> computerCodePegColours = new ArrayList<>();
        computerCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        computerCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        computerCodePegColours.add(new CodePeg(CodePegColour.RED));
        computerCodePegColours.add(new CodePeg(CodePegColour.RED));
        String actual = check.getKeyPegs(userCodePegColours, computerCodePegColours).toString();
        ArrayList<KeyPeg> expected = new ArrayList<>();
        expected.add(new KeyPeg(KeyPegColour.WHITE));
        expected.add(new KeyPeg(KeyPegColour.BLACK));
        expected.add(new KeyPeg(KeyPegColour.BLACK));
        String expectedString = expected.toString();
        Assert.assertEquals(expectedString,actual);
    }
//
//    @Test
//    public void returnWin() {
//        ArrayList<CodePegColour> userCodePegColours = new ArrayList<>();
//        userCodePegColours.add(CodePegColour.BLUE);
//        userCodePegColours.add(CodePegColour.ORANGE);
//        userCodePegColours.add(CodePegColour.YELLOW);
//        userCodePegColours.add(CodePegColour.RED);
//        userCodePegColours.add(CodePegColour.BLUE);
//        ArrayList<CodePegColour> computerCodePegColours = new ArrayList<>();
//        computerCodePegColours.add(CodePegColour.BLUE);
//        computerCodePegColours.add(CodePegColour.ORANGE);
//        computerCodePegColours.add(CodePegColour.YELLOW);
//        computerCodePegColours.add(CodePegColour.RED);
//        computerCodePegColours.add(CodePegColour.BLUE);
//        Result actual = check.getGameResult(userCodePegColours, computerCodePegColours);
//        Assert.assertEquals(Result.WIN,actual);
//    }
//
//    @Test
//    public void TETSTSTSTTST() {
//        ArrayList<CodePegColour> userCodePegColours = new ArrayList<>();
//        userCodePegColours.add(CodePegColour.RED);
//        userCodePegColours.add(CodePegColour.ORANGE);
//        userCodePegColours.add(CodePegColour.BLUE);
//        userCodePegColours.add(CodePegColour.RED);
//        ArrayList<CodePegColour> computerCodePegColours = new ArrayList<>();
//        computerCodePegColours.add(CodePegColour.BLUE);
//        computerCodePegColours.add(CodePegColour.ORANGE);
//        computerCodePegColours.add(CodePegColour.YELLOW);
//        computerCodePegColours.add(CodePegColour.RED);
//        ArrayList actual = check.getKeyPegs(userCodePegColours, computerCodePegColours);
//    }
//    @Test
//    public void TETSTSTSTTSrf() {
//        ArrayList<CodePegColour> userCodePegColours = new ArrayList<>();
//        userCodePegColours.add(CodePegColour.RED);
//        userCodePegColours.add(CodePegColour.RED);
//        userCodePegColours.add(CodePegColour.GREEN);
//        userCodePegColours.add(CodePegColour.RED);
//        ArrayList<CodePegColour> computerCodePegColours = new ArrayList<>();
//        computerCodePegColours.add(CodePegColour.GREEN);
//        computerCodePegColours.add(CodePegColour.RED);
//        computerCodePegColours.add(CodePegColour.RED);
//        computerCodePegColours.add(CodePegColour.RED);
//        ArrayList actual = check.getKeyPegs(userCodePegColours, computerCodePegColours);
//    }
}

import Models.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ResultsFromPegsTests {

    private ResultsFromUsersPegs check = new ResultsFromUsersPegs();

    @Test
    public void returnTrueAsKeyPegsContainBlackAndWhite() {
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
        String actual = check.getAndShuffleKeyPegsUsingCodePegs(userCodePegColours, computerCodePegColours).toString();
        boolean actualResult = false;
        if(actual.contains("keyPegColour=WHITE") && actual.contains("keyPegColour=BLACK")) { actualResult = true; }
        System.out.println(actual);
        Assert.assertTrue(actualResult);
    }
    @Test
    public void returnTrueAsKeyPegsDontContainWhite() {
        ArrayList<CodePeg> userCodePegColours = new ArrayList<>();
        userCodePegColours.add(new CodePeg(CodePegColour.RED));
        userCodePegColours.add(new CodePeg(CodePegColour.RED));
        userCodePegColours.add(new CodePeg(CodePegColour.RED));
        userCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        ArrayList<CodePeg> computerCodePegColours = new ArrayList<>();
        computerCodePegColours.add(new CodePeg(CodePegColour.RED));
        computerCodePegColours.add(new CodePeg(CodePegColour.RED));
        computerCodePegColours.add(new CodePeg(CodePegColour.RED));
        computerCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        String actual = check.getAndShuffleKeyPegsUsingCodePegs(userCodePegColours, computerCodePegColours).toString();
        boolean actualResult = false;
        if(!actual.contains("keyPegColour=WHITE") && actual.contains("keyPegColour=BLACK")) { actualResult = true; }
        System.out.println(actual);
        Assert.assertTrue(actualResult);
    }
    @Test
    public void returnTrueAsKeyPegsAreEmpty() {
        ArrayList<CodePeg> userCodePegColours = new ArrayList<>();
        userCodePegColours.add(new CodePeg(CodePegColour.RED));
        userCodePegColours.add(new CodePeg(CodePegColour.RED));
        userCodePegColours.add(new CodePeg(CodePegColour.RED));
        userCodePegColours.add(new CodePeg(CodePegColour.RED));
        ArrayList<CodePeg> computerCodePegColours = new ArrayList<>();
        computerCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        computerCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        computerCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        computerCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        String actual = check.getAndShuffleKeyPegsUsingCodePegs(userCodePegColours, computerCodePegColours).toString();
        boolean actualResult = false;
        if(!actual.contains("keyPegColour=WHITE") && !actual.contains("keyPegColour=BLACK")) { actualResult = true; }
        System.out.println(actual);
        Assert.assertTrue(actualResult);
    }
    @Test
    public void returnTrueAspepf() {
        ArrayList<CodePeg> userCodePegColours = new ArrayList<>();
        userCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        userCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        userCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        userCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        ArrayList<CodePeg> computerCodePegColours = new ArrayList<>();
        computerCodePegColours.add(new CodePeg(CodePegColour.RED));
        computerCodePegColours.add(new CodePeg(CodePegColour.RED));
        computerCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        computerCodePegColours.add(new CodePeg(CodePegColour.RED));
        String actual = check.getAndShuffleKeyPegsUsingCodePegs(userCodePegColours, computerCodePegColours).toString();
        boolean actualResult = false;
        if(!actual.contains("keyPegColour=WHITE") && !actual.contains("keyPegColour=BLACK")) { actualResult = true; }
        System.out.println(actual);
        Assert.assertTrue(actualResult);
    }
}

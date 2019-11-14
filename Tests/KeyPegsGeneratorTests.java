import IO.KeyPegsGenerator;
import Models.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class KeyPegsGeneratorTests {

    private KeyPegsGenerator check = new KeyPegsGenerator();

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
        String actual = check.generateAndShuffleKeyPegs(userCodePegColours, computerCodePegColours).toString();
        boolean actualResult = false;
        if(actual.contains("keyPegColour=WHITE") && actual.contains("keyPegColour=BLACK")) { actualResult = true; }
        System.out.println(actual);
        Assert.assertTrue(actualResult);
    }
    @Test
    public void returnTrueAsKeyPegsDontContainAWhitePeg() {
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
        String actual = check.generateAndShuffleKeyPegs(userCodePegColours, computerCodePegColours).toString();
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
        String actual = check.generateAndShuffleKeyPegs(userCodePegColours, computerCodePegColours).toString();
        boolean actualResult = false;
        if(!actual.contains("keyPegColour=WHITE") && !actual.contains("keyPegColour=BLACK")) { actualResult = true; }
        System.out.println(actual);
        Assert.assertTrue(actualResult);
    }
    @Test
    public void returnOneWhitePeg() {
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
        String actual = check.generateAndShuffleKeyPegs(userCodePegColours, computerCodePegColours).toString();
        String expected = "[KeyPeg{keyPegColour=WHITE}]";
        System.out.println(actual);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void returnTwoWhitePegs() {
        ArrayList<CodePeg> userCodePegColours = new ArrayList<>();
        userCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        userCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        userCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        userCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        ArrayList<CodePeg> computerCodePegColours = new ArrayList<>();
        computerCodePegColours.add(new CodePeg(CodePegColour.RED));
        computerCodePegColours.add(new CodePeg(CodePegColour.RED));
        computerCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        computerCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        String actual = check.generateAndShuffleKeyPegs(userCodePegColours, computerCodePegColours).toString();
        String expected = "[KeyPeg{keyPegColour=WHITE}, KeyPeg{keyPegColour=WHITE}]";
        System.out.println(actual);
        Assert.assertEquals(expected,actual);
    }
}

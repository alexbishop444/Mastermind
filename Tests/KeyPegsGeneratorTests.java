import IO.KeyPegsGenerator;
import Models.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


public class KeyPegsGeneratorTests {

    private KeyPegsGenerator keyPegsGenerator = new KeyPegsGenerator();

    @Test
    public void whiteAndBlackKeyPegsReturnedAsRightColourSelectionAndPlacement() {
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
        String actual = keyPegsGenerator.generateKeyPegs(userCodePegColours, computerCodePegColours).toString();
        ArrayList<KeyPeg> expectedPegs = new ArrayList<>();
        expectedPegs.add(new KeyPeg(KeyPegColour.BLACK));
        expectedPegs.add(new KeyPeg(KeyPegColour.BLACK));
        expectedPegs.add(new KeyPeg(KeyPegColour.WHITE));
        String expected = expectedPegs.toString();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void correctColourPlacementReturnsThreeBlackKeyPegs() {
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
        String actual = keyPegsGenerator.generateKeyPegs(userCodePegColours, computerCodePegColours).toString();
        ArrayList<KeyPeg> expectedPegs = new ArrayList<>();
        expectedPegs.add(new KeyPeg(KeyPegColour.BLACK));
        expectedPegs.add(new KeyPeg(KeyPegColour.BLACK));
        expectedPegs.add(new KeyPeg(KeyPegColour.BLACK));
        String expected = expectedPegs.toString();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void noKeyPegsReturnedAsColoursChosenAreAllIncorrect() {
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
        ArrayList<KeyPeg> actual = keyPegsGenerator.generateKeyPegs(userCodePegColours, computerCodePegColours);
        ArrayList<KeyPeg> expected = new ArrayList<>();
        Assert.assertEquals(expected,actual);
    }
}

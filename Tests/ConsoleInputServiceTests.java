import IO.ConsoleInputService;
import Models.CodePeg;
import Models.CodePegColour;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ConsoleInputServiceTests {

    private ConsoleInputService consoleInputService = new ConsoleInputService();
    @Test
    public void validateCorrectColours() {
        Boolean actual = consoleInputService.isValidColour("Red,Green,Green,Blue");
        System.out.println(actual);
        Assert.assertTrue(actual);
    }
    @Test
    public void validateCorrectLength() {
        Boolean actual = consoleInputService.isValidLength("Blue, Red, Green, Blue");
        Assert.assertTrue(actual);
    }

    @Test
    public void validateCorrectColoursWithSpaces() {
        Boolean actual = consoleInputService.isValidColour("Blue,    Red,Green,Blue");
        Assert.assertTrue(actual);
    }

    @Test
    public void invalidateWrongColours() {
        Boolean actual = consoleInputService.isValidColour("Red,Red,Red,Black");
        Assert.assertFalse(actual);
    }
    @Test
    public void invalidateLengthAsAboveFourColours() {
        Boolean actual = consoleInputService.isValidLength("Blue, Red, Green, Blue, Orange, Blue");
        Assert.assertFalse(actual);
    }

    @Test
    public void invalidateLengthAsUnderFourColours() {
        Boolean actual = consoleInputService.isValidLength("Blue, Red, Green");
        Assert.assertFalse(actual);
    }

    @Test
    public void convertInput() {
        String actualCodePegColours = consoleInputService.convertInput("Blue,Red,Green,Blue").toString();
        ArrayList<CodePeg> expectedCodePegColours = new ArrayList<>();
        expectedCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        expectedCodePegColours.add(new CodePeg(CodePegColour.RED));
        expectedCodePegColours.add(new CodePeg(CodePegColour.GREEN));
        expectedCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        String expected = expectedCodePegColours.toString();
        Assert.assertEquals(expected, actualCodePegColours);
    }
    @Test
    public void convertInputWithSpaces() {
        String actualCodePegColours = consoleInputService.convertInput("Blue,     Red,Green,     Blue").toString();
        ArrayList<CodePeg> expectedCodePegColours = new ArrayList<>();
        expectedCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        expectedCodePegColours.add(new CodePeg(CodePegColour.RED));
        expectedCodePegColours.add(new CodePeg(CodePegColour.GREEN));
        expectedCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        String expected = expectedCodePegColours.toString();
        Assert.assertEquals(expected, actualCodePegColours);
    }

}

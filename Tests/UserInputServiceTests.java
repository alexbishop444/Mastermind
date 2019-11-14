import IO.UserInputService;
import Models.CodePeg;
import Models.CodePegColour;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class UserInputServiceTests {

    private UserInputService userInputService = new UserInputService();

    @Test
    public void correctInputColourTestWillReturnTrue() {
        Boolean actual = userInputService.isValidColour("Red,Green,Green,Blue");
        System.out.println(actual);
        Assert.assertTrue(actual);
    }
    @Test
    public void correctInputLengthTestWillReturnTrue() {
        Boolean actual = userInputService.isValidColour("Blue, Red, Green, Blue");
        Assert.assertTrue(actual);
    }

    @Test
    public void correctInputTestWithSpacesWillReturnTrue() {
        Boolean actual = userInputService.isValidColour("Blue,    Red,Green,Blue");
        Assert.assertTrue(actual);
    }

    @Test
    public void incorrectInputColourTestWillReturnFalse() {
        Boolean actual = userInputService.isValidColour("Red,Red,Red,Black");
        Assert.assertFalse(actual);
    }
    @Test
    public void incorrectInputLengthOverFourTestWillReturnFalse() {
        Boolean actual = userInputService.isValidLength("Blue, Red, Green, Blue, Orange, Blue");
        Assert.assertFalse(actual);
    }

    @Test
    public void incorrectInputLengthUnderFiveTestWillReturnFalse() {
        Boolean actual = userInputService.isValidLength("Blue, Red, Green");
        Assert.assertFalse(actual);
    }

    @Test
    public void convertInputTest() {
        String actualCodePegColours = userInputService.convertInput("Blue,Red,Green,Blue").toString();
        ArrayList<CodePeg> expectedCodePegColours = new ArrayList<>();
        expectedCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        expectedCodePegColours.add(new CodePeg(CodePegColour.RED));
        expectedCodePegColours.add(new CodePeg(CodePegColour.GREEN));
        expectedCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        String expected = expectedCodePegColours.toString();
        Assert.assertEquals(expected, actualCodePegColours);
    }
    @Test
    public void convertInputWithSpacesTest() {
        String actualCodePegColours = userInputService.convertInput("Blue,     Red,Green,     Blue").toString();
        ArrayList<CodePeg> expectedCodePegColours = new ArrayList<>();
        expectedCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        expectedCodePegColours.add(new CodePeg(CodePegColour.RED));
        expectedCodePegColours.add(new CodePeg(CodePegColour.GREEN));
        expectedCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        String expected = expectedCodePegColours.toString();
        Assert.assertEquals(expected, actualCodePegColours);
    }

}

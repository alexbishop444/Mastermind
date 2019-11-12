import Models.Peg;
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
        ArrayList<Peg> actualPegs = userInputService.convertInput("Blue,Red,Green,Blue");
        ArrayList<Peg> expectedPegs = new ArrayList<>();
        expectedPegs.add(Peg.BLUE);
        expectedPegs.add(Peg.RED);
        expectedPegs.add(Peg.GREEN);
        expectedPegs.add(Peg.BLUE);
        Assert.assertEquals(expectedPegs,actualPegs);
    }
    @Test
    public void convertInputWithSpacesTest() {
        ArrayList<Peg> actualPegs = userInputService.convertInput("Blue,     Red,Green,     Blue");
        ArrayList<Peg> expectedPegs = new ArrayList<>();
        expectedPegs.add(Peg.BLUE);
        expectedPegs.add(Peg.RED);
        expectedPegs.add(Peg.GREEN);
        expectedPegs.add(Peg.BLUE);
        Assert.assertEquals(expectedPegs,actualPegs);
    }

}

import Models.Peg;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ConvertInputToPegsTests {

    private ConvertInputToTraditionalPegs convert = new ConvertInputToTraditionalPegs();

    @Test
    public void convertInputTest() {
        ArrayList<Peg> actualPegs = convert.convertInput("Blue,Red,Green,Blue");
        ArrayList<Peg> expectedPegs = new ArrayList<>();
        expectedPegs.add(Peg.BLUE);
        expectedPegs.add(Peg.RED);
        expectedPegs.add(Peg.GREEN);
        expectedPegs.add(Peg.BLUE);
        Assert.assertEquals(expectedPegs,actualPegs);
    }
    @Test
    public void convertInputWithSpacesTest() {
        ArrayList<Peg> actualPegs = convert.convertInput("Blue,     Red,Green,     Blue");
        ArrayList<Peg> expectedPegs = new ArrayList<>();
        expectedPegs.add(Peg.BLUE);
        expectedPegs.add(Peg.RED);
        expectedPegs.add(Peg.GREEN);
        expectedPegs.add(Peg.BLUE);
        Assert.assertEquals(expectedPegs,actualPegs);
    }
}

import Models.Peg;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ConvertInputToPegsTests {

    private ConvertInputToTraditionalPegs convert = new ConvertInputToTraditionalPegs();

    @Test
    public void convertInputTest() {
        ArrayList<Peg> userPegs = convert.convertInput("Blue,Red,Green,Blue,Orange");
        ArrayList<Peg> computerPegs = new ArrayList<>();
        computerPegs.add(Peg.BLUE);
        computerPegs.add(Peg.RED);
        computerPegs.add(Peg.GREEN);
        computerPegs.add(Peg.BLUE);
        computerPegs.add(Peg.ORANGE);
        Assert.assertEquals(computerPegs,userPegs);
    }
}

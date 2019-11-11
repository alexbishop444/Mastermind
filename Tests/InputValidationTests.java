import org.junit.Assert;
import org.junit.Test;

public class InputValidationTests {

    private TraditionalInputValidation validate = new TraditionalInputValidation();

    @Test
    public void correctInputColourTestWillReturnTrue() {
        Boolean actual = validate.validate("Red,Green,Green,Blue");
        System.out.println(actual);
        Assert.assertTrue(actual);
    }
    @Test
    public void correctInputLengthTestWillReturnTrue() {
        Boolean actual = validate.validate("Blue, Red, Green, Blue");
        Assert.assertTrue(actual);
    }

    @Test
    public void correctInputTestWithSpacesWillReturnTrue() {
        Boolean actual = validate.validate("Blue,    Red,Green,Blue");
        Assert.assertTrue(actual);
    }

    @Test
    public void incorrectInputColourTestWillReturnFalse() {
        Boolean actual = validate.validate("Red,Red,Red,Black");
        Assert.assertFalse(actual);
    }
    @Test
    public void incorrectInputLengthOverFourTestWillReturnFalse() {
        Boolean actual = validate.validate("Blue, Red, Green, Blue, Orange, Blue");
        Assert.assertFalse(actual);
    }

    @Test
    public void incorrectInputLengthUnderFiveTestWillReturnFalse() {
        Boolean actual = validate.validate("Blue, Red, Green");
        Assert.assertFalse(actual);
    }

}

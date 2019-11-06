import org.junit.Assert;
import org.junit.Test;

public class InputValidationTests {

    TraditionalInputValidation validate = new TraditionalInputValidation();

    @Test
    public void CorrectInputColourTestWillReturnTrue() {
        Boolean actual = validate.IsValidColour("Blue, Red, Green, Blue, Orange");
        Assert.assertTrue(actual);
    }
    @Test
    public void CorrectInputLengthTestWillReturnTrue() {
        Boolean actual = validate.IsValidLength("Blue, Red, Green, Blue, Orange");
        Assert.assertTrue(actual);
    }

    @Test
    public void CorrectInputTestWillReturnTrue() {
        Boolean actual = validate.Validate("Blue, Red, Green, Blue, Orange");
        Assert.assertTrue(actual);
    }

    @Test
    public void IncorrectInputColourTestWillReturnFalse() {
        Boolean actual = validate.IsValidColour("Black, Red, Green, Blue, Orange");
        Assert.assertFalse(actual);
    }
    @Test
    public void IncorrectInputLengthTestWillReturnFalse() {
        Boolean actual = validate.IsValidLength("Blue, Red, Green, Blue, Orange, Blue");
        Assert.assertFalse(actual);
    }

    @Test
    public void IncorrectInputTestWillReturnFalse() {
        Boolean actual = validate.Validate("Blue, Red, Green, Blue, Black");
        Assert.assertFalse(actual);
    }

}

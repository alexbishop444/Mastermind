import org.junit.Assert;
import org.junit.Test;

public class InputValidationTests {

    TraditionalInputValidation validate = new TraditionalInputValidation();

    @Test
    public void correctInputColourTestWillReturnTrue() {
        Boolean actual = validate.validate("Red,Green,Green,Blue,Orange");
        System.out.println(actual);
        Assert.assertTrue(actual);
    }
    @Test
    public void correctInputLengthTestWillReturnTrue() {
        Boolean actual = validate.validate("Blue, Red, Green, Blue, Orange");
        Assert.assertTrue(actual);
    }

    @Test
    public void correctInputTestWillReturnTrue() {
        Boolean actual = validate.validate("Blue,    Red,Green,Blue,Orange");
        Assert.assertTrue(actual);
    }

    @Test
    public void correctInputTestWithSpacesWillReturnTrue() {
        Boolean actual = validate.validate("Blue,Red,Green,Blue,Orange");
        Assert.assertTrue(actual);
    }

    @Test
    public void incorrectInputColourTestWillReturnFalse() {
        Boolean actual = validate.validate("Red,Red,Red,Black,Blue");
        Assert.assertFalse(actual);
    }
    @Test
    public void incorrectInputLengthTestWillReturnFalse() {
        Boolean actual = validate.validate("Blue, Red, Green, Blue, Orange, Blue");
        Assert.assertFalse(actual);
    }

    @Test
    public void incorrectInputTestWillReturnFalse() {
        Boolean actual = validate.validate("Blue,Red,Green,Black,Blue");
        Assert.assertFalse(actual);
    }

}

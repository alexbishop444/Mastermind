import Core.Mastermind;
import Core.TraditionalMastermind;
import IO.KeyPegsGeneration;
import IO.KeyPegsGenerator;
import IO.UserInput;
import IO.UserInputService;
import Models.CodePeg;
import Models.CodePegColour;
import Models.Result;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class MastermindTests {
    private UserInput userInputService = new UserInputService();
    private KeyPegsGeneration keyPegsGenerator = new KeyPegsGenerator();
    private Mastermind traditionalMastermind = new TraditionalMastermind(80,keyPegsGenerator,userInputService);
    @Test
    public void winResultReturnedTest() {
        ArrayList<CodePeg> userCodePegColours = new ArrayList<>();
        userCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        userCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        userCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        userCodePegColours.add(new CodePeg(CodePegColour.RED));
        ArrayList<CodePeg> computerCodePegColours = new ArrayList<>();
        computerCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        computerCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        computerCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        computerCodePegColours.add(new CodePeg(CodePegColour.RED));
        Result actual = traditionalMastermind.getGameResult(userCodePegColours,computerCodePegColours);
        Result expected = Result.WIN;
        Assert.assertEquals(expected,actual);

    }
    @Test
    public void playingResultReturnedTest() {
        ArrayList<CodePeg> userCodePegColours = new ArrayList<>();
        userCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        userCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        userCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        userCodePegColours.add(new CodePeg(CodePegColour.RED));
        ArrayList<CodePeg> computerCodePegColours = new ArrayList<>();
        computerCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        computerCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        computerCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        computerCodePegColours.add(new CodePeg(CodePegColour.RED));
        Result actual = traditionalMastermind.getGameResult(userCodePegColours,computerCodePegColours);
        Result expected = Result.PLAYING;
        Assert.assertEquals(expected,actual);

    }
    @Test
    public void lossResultReturnedTest() {
        TraditionalMastermind traditionalMastermindWith0Turns = new TraditionalMastermind(0,keyPegsGenerator,userInputService);
        ArrayList<CodePeg> userCodePegColours = new ArrayList<>();
        userCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        userCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        userCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        userCodePegColours.add(new CodePeg(CodePegColour.RED));
        ArrayList<CodePeg> computerCodePegColours = new ArrayList<>();
        computerCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        computerCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        computerCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        computerCodePegColours.add(new CodePeg(CodePegColour.RED));
        Result actual = traditionalMastermindWith0Turns.getGameResult(userCodePegColours,computerCodePegColours);
        Result expected = Result.LOSS;
        Assert.assertEquals(expected,actual);

    }
}

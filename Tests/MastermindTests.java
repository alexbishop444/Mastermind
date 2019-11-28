import Core.Mastermind;
import Core.TraditionalMastermind;
import IO.KeyPegsGeneration;
import IO.KeyPegsGenerator;
import IO.UserInput;
import IO.ConsoleInputService;
import Models.CodePeg;
import Models.CodePegColour;
import Models.Result;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class MastermindTests {
    private UserInput userInputService = new ConsoleInputService();
    private KeyPegsGeneration keyPegsGenerator = new KeyPegsGenerator();
    private Mastermind traditionalMastermind = new TraditionalMastermind(80,keyPegsGenerator,userInputService);

    @Test
    public void usersInputNotCorrectComboToWinWithTurnsRemaining() {
        ArrayList<CodePeg> computerCodePegColours = new ArrayList<>();
        computerCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        computerCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        computerCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        computerCodePegColours.add(new CodePeg(CodePegColour.RED));
        Result actual = traditionalMastermind.playerTurn("blue,green,green,green",computerCodePegColours);
        Result expected = Result.PLAYING;
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void usersInputCorrectComboToWin() {
        ArrayList<CodePeg> computerCodePegColours = new ArrayList<>();
        computerCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        computerCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        computerCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        computerCodePegColours.add(new CodePeg(CodePegColour.RED));
        Result actual = traditionalMastermind.playerTurn("Yellow,Blue,Yellow,Red",computerCodePegColours);
        Result expected = Result.WIN;
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void amountOfTurnsIsZeroSoGameIsOver() {
        UserInput userInputService = new ConsoleInputService();
        KeyPegsGeneration keyPegsGenerator = new KeyPegsGenerator();
        TraditionalMastermind traditionalMastermind = new TraditionalMastermind(1,keyPegsGenerator,userInputService);
        ArrayList<CodePeg> computerCodePegColours = new ArrayList<>();
        computerCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        computerCodePegColours.add(new CodePeg(CodePegColour.BLUE));
        computerCodePegColours.add(new CodePeg(CodePegColour.YELLOW));
        computerCodePegColours.add(new CodePeg(CodePegColour.RED));
        Result actual = traditionalMastermind.playerTurn("Red,Blue,Yellow,Red",computerCodePegColours);
        Result expected = Result.LOSS;
        Assert.assertEquals(expected,actual);
    }
}
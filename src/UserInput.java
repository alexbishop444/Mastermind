import Models.CodePeg;

import java.util.ArrayList;

public interface UserInput {
    String takeInput();
    public Boolean isValidColour(String userInput);
    Boolean isValidLength(String userInput);
    ArrayList<CodePeg> convertInput(String userInput);
}
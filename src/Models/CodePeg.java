package Models;

public class CodePeg {
    private CodePegColour codePegColour;

    public CodePeg(CodePegColour codePegColour) {
        this.codePegColour = codePegColour;
    }

    public CodePegColour getCodePegColour() {
        return codePegColour;
    }

    @Override
    public String toString() {
        return "CodePeg{" +
                "codePegColour=" + codePegColour +
                '}';
    }
}

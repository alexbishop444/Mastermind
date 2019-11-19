package Models;

public class KeyPeg {
    private KeyPegColour keyPegColour;

    @Override
    public String toString() {
        return "KeyPeg{" +
                "keyPegColour=" + keyPegColour +
                '}';
    }

    public KeyPeg(KeyPegColour keyPegColour) {
        this.keyPegColour = keyPegColour;
    }
}

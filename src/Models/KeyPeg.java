package Models;

public class KeyPeg {
    public KeyPegColour keyPegColour;

    @Override
    public String toString() {
        return "KeyPeg{" +
                "keyPegColour=" + keyPegColour +
                '}';
    }

    public KeyPeg(KeyPegColour keyPegColour) {
        this.keyPegColour = keyPegColour;
    }

    public KeyPegColour getKeyPegColour() {
        return keyPegColour;
    }
}

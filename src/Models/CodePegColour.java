package Models;

import java.util.HashMap;
import java.util.Map;

public enum CodePegColour {
    RED(0),
    BLUE(1),
    GREEN(2),
    ORANGE(3),
    PURPLE(4),
    YELLOW(5);

    private int value;

    private static Map map = new HashMap<>();

    static {
        for (CodePegColour codePegColour : CodePegColour.values()) {
            map.put(codePegColour.value, codePegColour);
        }
    }

    public static CodePegColour valueOf(int peg) {
        return (CodePegColour) map.get(peg);
    }



    CodePegColour(int value) {
        this.value = value;
    }


}

package Models;

import java.util.HashMap;
import java.util.Map;

public enum Peg {
    RED(0),
    BLUE(1),
    GREEN(2),
    ORANGE(3),
    PURPLE(4),
    YELLOW(5);

    private int value;

    private static Map map = new HashMap<>();

    static {
        for (Peg peg : Peg.values()) {
            map.put(peg.value, peg);
        }
    }

    public static Peg valueOf(int peg) {
        return (Peg) map.get(peg);
    }



    Peg(int value) {
        this.value = value;
    }


}

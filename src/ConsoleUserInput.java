import Models.Peg;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUserInput implements UserInput {
    private Scanner scanner = new Scanner(System.in);
    public String takeInput() {
        ArrayList<String> pegs = new ArrayList<>();

        for (int i = 0; i < Peg.values().length; i++) {
            pegs.add(Peg.valueOf(i).toString());
        }

        System.out.println("Choose five Pegs from " + pegs.toString().replace("[","").replace("]",""));

        return scanner.nextLine();
    }
}
package input;

import java.util.Scanner;

/**
 * This class provide the input data from command line.
 */
public class CommandLineInput implements Input {
    private Scanner input = new Scanner(System.in);

    @Override
    public String input() {
        return input.nextLine();
    }
}

package output;

/**
 * This is realisation of output for command line
 */
public class CommandLineOutput implements Output {
    @Override
    public void show(String data) {
        System.out.print(data);
    }
}

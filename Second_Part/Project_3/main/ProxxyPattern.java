import java.util.ArrayList;
import java.util.Scanner;

public class ProxxyPattern implements Command {
    @Override
    public void execute(Double x, Double y, Double height, Double width) throws Exception {
        new Controller().execute(x < 5 ? 1 : x, y < 5 ? 1 : y, height < 5 ? 1 : height, width < 5 ? 1 : width);
    }
}

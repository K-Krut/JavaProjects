import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Release {
    List<Command> list = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);


    void AddCommand(Command newCommand) {
        list.add(newCommand);
    }

    void RunCommand() {

        System.out.println("Enter data:");

        list.forEach(command -> {
            try {
                command.execute(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

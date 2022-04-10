import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        Release release = new Release();
        release.AddCommand(new Controller());
        release.RunCommand();

        new ProxxyPattern().execute(
                scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble()
        );
    }

    static class Release {

        List <Command> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        void AddCommand(Command newCommand) {
            list.add(newCommand);
        }

        void RunCommand() {
            System.out.println("Enter data (1, 1, 3, 4): ");
            list.forEach(command -> {
                try {
                    command.execute(
                            scanner.nextDouble(),scanner.nextDouble(),scanner.nextDouble(),scanner.nextDouble()
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}

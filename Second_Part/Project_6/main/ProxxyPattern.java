public class ProxxyPattern implements Command {

    Command command;

    public ProxxyPattern(Controller controller) {
        command = controller;
    }

    @Override
    public void execute(Double x, Double y, Double height, Double width) throws Exception {
        command.execute(x < 5 ? 1 : x, y < 5 ? 1 : y, height < 5 ? 1 : height, width < 5 ? 1 : width);
    }
}

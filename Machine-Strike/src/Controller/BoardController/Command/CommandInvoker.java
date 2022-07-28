package Controller.BoardController.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandInvoker {

    private final List<Commando> instant = new ArrayList<>();
    private final List<Commando> pool = new ArrayList<>();
    private final List<Commando> done = new ArrayList<>();
    private static CommandInvoker commandInvoker;

    public static CommandInvoker getCommandInvoker() {
        if(commandInvoker == null)
            commandInvoker = new CommandInvoker();
        return commandInvoker;
    }

    public void add(Commando commando) {
        instant.add(commando);
    }

    public void execute() throws Exception {
        for (Commando commando: instant) {
            commando.execute();
            pool.add(commando);
        }
        instant.clear();
    }

    public void undo() throws Exception {
        Commando commando = pool.remove(pool.size()-1);
        commando.undo();
        done.add(commando);
    }

    public void redo() throws Exception {
        Commando commando = done.remove(done.size()-1);
        commando.redo();
        pool.add(commando);
    }
}

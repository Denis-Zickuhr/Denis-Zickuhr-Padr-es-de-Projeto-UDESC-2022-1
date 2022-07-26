package Controller.BoardController.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandInvoker {

    private final List<Commando> instant = new ArrayList<>();
    private final List<Commando> pool = new ArrayList<>();
    private final List<Commando> done = new ArrayList<>();

    public void add(Commando commando) {
        instant.add(commando);
    }

    public void execute(int[] destiny) throws Exception {
        for (Commando commando: instant) {
            commando.execute(destiny);
            pool.add(commando);
        }
        instant.clear();
    }

    public void undo(int[] origin) throws Exception {
        Commando commando = pool.remove(pool.size()-1);
        commando.undo(origin);
        done.add(commando);
    }

    public void redo(int[] destiny) throws Exception {
        Commando commando = done.remove(done.size()-1);
        commando.redo(destiny);
        pool.add(commando);
    }
}

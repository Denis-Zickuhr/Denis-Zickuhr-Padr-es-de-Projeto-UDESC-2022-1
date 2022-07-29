package Controller.BoardController.Command.Commands;

import Controller.BoardController.BoardController;
import Controller.BoardController.Command.AbstractCommandoBuilder;
import Controller.BoardController.Command.BoardControllerCommander;

public class Attack extends BoardControllerCommander {


    public Attack(CommandoBuilder commandoBuilder) {
        super(commandoBuilder);
    }

    @Override
    public void execute() throws Exception {
        BoardController.getInstance().attackMachine(origin, destiny, 1);
    }

    @Override
    public void undo() throws Exception {
        BoardController.getInstance().attackMachine(origin, destiny, -1);
    }

    @Override
    public void redo() throws Exception {
        BoardController.getInstance().attackMachine(origin, destiny, 1);
    }

    public static class CommandoBuilder extends AbstractCommandoBuilder {

        @Override
        public Controller.BoardController.Command.Commando build(){
            return new Attack(this);
        }

    }
}

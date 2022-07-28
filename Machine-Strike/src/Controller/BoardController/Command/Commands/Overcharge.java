package Controller.BoardController.Command.Commands;

import Controller.BoardController.BoardController;
import Controller.BoardController.Command.AbstractCommandoBuilder;
import Controller.BoardController.Command.BoardControllerCommander;

public class Overcharge extends BoardControllerCommander {


    public Overcharge(CommandoBuilder commandoBuilder) {
        super(commandoBuilder);
    }

    @Override
    public void execute() throws Exception {
        BoardController.getInstance().overCharge(origin,1);
    }

    @Override
    public void undo() throws Exception {
        BoardController.getInstance().overCharge(origin,-1);
    }

    @Override
    public void redo() throws Exception {
        BoardController.getInstance().overCharge(origin,1);
    }

    public static class CommandoBuilder extends AbstractCommandoBuilder {

        @Override
        public boolean isExecutable() {
            return true;
        }

        @Override
        public Controller.BoardController.Command.Commando build(){
            return new Overcharge(this);
        }

    }
}

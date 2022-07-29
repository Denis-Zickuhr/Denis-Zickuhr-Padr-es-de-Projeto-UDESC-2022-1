package Controller.BoardController.Command.Commands;

import Controller.BoardController.BoardController;
import Controller.BoardController.Command.AbstractCommandoBuilder;
import Controller.BoardController.Command.BoardControllerCommander;

public class SpecialMove extends BoardControllerCommander {


    public SpecialMove(CommandoBuilder commandoBuilder) {
        super(commandoBuilder);
    }

    @Override
    public void execute() throws Exception {
        BoardController.getInstance().specialMove(origin, false);
    }

    @Override
    public void undo() throws Exception {
        BoardController.getInstance().specialMove(origin,true);
    }

    @Override
    public void redo() throws Exception {
        BoardController.getInstance().specialMove(origin,false);
    }

    public static class CommandoBuilder extends AbstractCommandoBuilder {

        @Override
        public boolean isExecutable() {
            return true;
        }

        @Override
        public Controller.BoardController.Command.Commando build(){
            return new SpecialMove(this);
        }

    }
}

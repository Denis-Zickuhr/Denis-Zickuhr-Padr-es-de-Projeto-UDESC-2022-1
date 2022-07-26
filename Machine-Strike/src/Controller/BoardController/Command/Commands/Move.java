package Controller.BoardController.Command.Commands;

import Controller.BoardController.BoardController;
import Controller.BoardController.Command.AbstractCommandoBuilder;
import Controller.BoardController.Command.BoardControllerCommander;

public class Move extends BoardControllerCommander {


    public Move(CommandoBuilder commandoBuilder) {
        super(commandoBuilder);
    }

    @Override
    public void execute() throws Exception {
        BoardController.getInstance().swapPiece(origin, destiny, true);
    }

    @Override
    public void undo() throws Exception {
        BoardController.getInstance().swapPiece(destiny, origin, true);
    }

    @Override
    public void redo() throws Exception {
        BoardController.getInstance().swapPiece(origin, destiny, true);
    }

    public static class CommandoBuilder extends AbstractCommandoBuilder {

        @Override
        public Controller.BoardController.Command.Commando build(){
            return new Move(this);
        }

    }

}

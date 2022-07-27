package Controller.BoardController.Command.Commands;

import Controller.BoardController.BoardController;
import Controller.BoardController.Command.BoardControllerCommander;
import Model.Board;

public class Overcharge extends BoardControllerCommander {

    public Overcharge() {
        super(BoardController.getInstance());
    }

    @Override
    public void execute(int[] destiny) throws Exception {
        BoardController.getInstance().overCharge(destiny, 1);
    }

    @Override
    public void undo(int[] destiny) throws Exception {
        BoardController.getInstance().overCharge(destiny, -1);
    }

    @Override
    public void redo(int[] destiny) throws Exception {
        BoardController.getInstance().overCharge(destiny, 1);
    }
}

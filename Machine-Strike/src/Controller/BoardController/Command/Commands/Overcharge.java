package Controller.BoardController.Command.Commands;

import Controller.BoardController.BoardController;
import Controller.BoardController.Command.BoardControllerCommander;
import Model.Board;

public class Overcharge extends BoardControllerCommander {

    public Overcharge(BoardController boardController) {
        super(boardController);
    }

    @Override
    public void execute(int[] destiny) {

    }

    @Override
    public void undo(int[] destiny) {

    }

    @Override
    public void redo(int[] destiny) {

    }
}

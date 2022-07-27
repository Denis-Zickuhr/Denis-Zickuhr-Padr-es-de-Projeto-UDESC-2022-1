package Controller.BoardController.Command.Commands;

import Controller.BoardController.BoardController;
import Controller.BoardController.Command.BoardControllerCommander;
import Model.Board;

public class Attack extends BoardControllerCommander {

    public Attack() {
        super(BoardController.getInstance());
    }

    @Override
    public void execute(int[] destiny) throws Exception {
        BoardController.getInstance().attackMachine(BoardController.getInstance().getTerrain().getCords(), destiny, 1);
    }

    @Override
    public void undo(int[] destiny) throws Exception {
        BoardController.getInstance().attackMachine(BoardController.getInstance().getTerrain().getCords(), destiny, -1);
    }

    @Override
    public void redo(int[] destiny) throws Exception {
        BoardController.getInstance().attackMachine(BoardController.getInstance().getTerrain().getCords(), destiny, 1);
    }
}

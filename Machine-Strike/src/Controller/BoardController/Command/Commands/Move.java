package Controller.BoardController.Command.Commands;

import Controller.BoardController.BoardController;
import Controller.BoardController.Command.BoardControllerCommander;

public class Move extends BoardControllerCommander {


    public Move() {
        super(BoardController.getInstance());
    }

    @Override
    public void execute(int[] destiny) throws Exception {
        BoardController.getInstance().swapPiece(BoardController.getInstance().getTerrain().getCords(), destiny);
    }

    @Override
    public void undo(int[] destiny) throws Exception {
        BoardController.getInstance().swapPiece(destiny, BoardController.getInstance().getTerrain().getCords());
    }

    @Override
    public void redo(int[] destiny) throws Exception {
        BoardController.getInstance().swapPiece(BoardController.getInstance().getTerrain().getCords(),destiny);
    }
}

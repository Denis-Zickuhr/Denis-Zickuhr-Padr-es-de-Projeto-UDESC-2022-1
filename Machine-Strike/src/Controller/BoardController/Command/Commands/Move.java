package Controller.BoardController.Command.Commands;

import Controller.BoardController.BoardController;
import Controller.BoardController.Command.BoardControllerCommander;

public class Move extends BoardControllerCommander {


    public Move(BoardController boardController) {
        super(boardController);
    }

    @Override
    public void execute(int[] destiny) throws Exception {
        this.boardController.swapPiece(boardController.getTerrain().getCords(), destiny);
    }

    @Override
    public void undo(int[] destiny) throws Exception {
        this.boardController.swapPiece(destiny, boardController.getTerrain().getCords());
    }

    @Override
    public void redo(int[] destiny) throws Exception {
        this.boardController.swapPiece(boardController.getTerrain().getCords(),destiny);
    }
}

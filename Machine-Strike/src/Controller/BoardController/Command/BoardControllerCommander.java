package Controller.BoardController.Command;

import Controller.BoardController.BoardController;
import Model.Board;

public abstract class BoardControllerCommander implements Commando {

    protected BoardController boardController;

    public BoardControllerCommander(BoardController board) {
        this.boardController = board;
    }
}

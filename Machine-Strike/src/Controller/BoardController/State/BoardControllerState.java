package Controller.BoardController.State;

import Controller.BoardController.BoardController;

public abstract class BoardControllerState {

    BoardController controller;

    public BoardControllerState(BoardController boardController) {
        this.controller = boardController;
    }

    public abstract void terrainClicked(int[] cords) throws Exception;
}

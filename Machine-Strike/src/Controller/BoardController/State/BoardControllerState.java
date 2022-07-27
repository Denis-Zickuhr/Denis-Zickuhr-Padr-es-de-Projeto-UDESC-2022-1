package Controller.BoardController.State;

import Controller.BoardController.BoardController;

public abstract class BoardControllerState {
    public abstract void terrainClicked(int[] cords) throws Exception;
}

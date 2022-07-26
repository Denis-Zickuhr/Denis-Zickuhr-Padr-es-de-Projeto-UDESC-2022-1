package Controller.BoardController.State;

import Controller.BoardController.BoardController;

public class BoardControllerWaitingActionState extends BoardControllerState{

    public BoardControllerWaitingActionState(BoardController boardController) {
        super(boardController);
    }

    @Override
    public void terrainClicked(int[] cords) throws Exception {
        System.out.println("executou");
        this.controller.execute(cords);
        this.controller.setState(new BoardControllerWaitingPieceState(this.controller));
    }
}

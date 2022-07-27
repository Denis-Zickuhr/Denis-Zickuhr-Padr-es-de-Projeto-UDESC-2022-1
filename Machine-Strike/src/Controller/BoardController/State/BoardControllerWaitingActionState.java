package Controller.BoardController.State;

import Controller.BoardController.BoardController;

public class BoardControllerWaitingActionState extends BoardControllerState{

    @Override
    public void terrainClicked(int[] cords) throws Exception {
//        if(BoardController.getInstance().getTurn().inTurn(BoardController.getInstance().getBoard().getTerrain(cords).getMachine())){
//
//        }
        BoardController.getInstance().execute(cords);
        BoardController.getInstance().setState(new BoardControllerWaitingPieceState());
    }

}

package Controller.BoardController.State;

import Controller.BoardController.BoardController;
import Model.AbstractModel.AbstractMachine.Machine;

import java.util.Arrays;

public class BoardControllerWaitingPieceState extends BoardControllerState{


    public void terrainClicked(int[] cords){
        System.out.println("selecionou");

        int aux = Integer.parseInt(Integer.toString(Integer.parseInt(Arrays.toString(cords).replaceAll(" ", "").
                        replaceAll("\\[", "").
                        replaceAll("\\]", "").
                        replaceAll(",", ""), 8), 10));

        BoardController.getInstance().setTerrain(BoardController.getInstance().getBoard().getTerrains().get(aux));
        Machine temp = BoardController.getInstance().getTerrain().getMachine();
        if(temp != null & BoardController.getInstance().getTurn().inTurn(temp)){
            BoardController.getInstance().setState(new BoardControllerWaitingActionState());
            BoardController.getInstance().toggleButtons();
        }
    }
}

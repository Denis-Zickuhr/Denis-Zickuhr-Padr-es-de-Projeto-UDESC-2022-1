package Controller.BoardController.State;

import Controller.BoardController.BoardController;

import java.util.Arrays;

public class BoardControllerWaitingPieceState extends BoardControllerState{

    public BoardControllerWaitingPieceState(BoardController boardController) {
        super(boardController);
    }

    public void terrainClicked(int[] cords){
        System.out.println("selecionou");
        int aux = Integer.parseInt(Integer.toString(Integer.parseInt(Arrays.toString(cords).replaceAll(" ", "").
                        replaceAll("\\[", "").
                        replaceAll("\\]", "").
                        replaceAll(",", ""), 8), 10));

        this.controller.setTerrain(this.controller.getBoard().getTerrains().get(aux));
        this.controller.setState(new BoardControllerWaitingActionState(this.controller));
        this.controller.toggleButton();
    }
}

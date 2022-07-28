package Controller.BoardController.State;

import Controller.BoardController.BoardController;
import Model.AbstractModel.AbstractMachine.Machine;
import Model.Player;
import Model.Terrain.Terrain;

import java.util.Arrays;

public class BoardControllerWaitingPieceState extends BoardControllerState{


    public void terrainClicked(int[] cords) throws Exception {

        int formattedCords = formatCords(cords);

        Terrain terrain = BoardController.getInstance().getBoard().getTerrains().get(formattedCords);
        Machine machine = (BoardController.getInstance().getBoard().getTerrains().get(formattedCords).getMachine());
        Player player = BoardController.getInstance().getTurn();

        if(player.inTurn(machine)){
            BoardController.getInstance().setTerrain(terrain);
            BoardController.getInstance().setState(new BoardControllerWaitingActionState());
            BoardController.getInstance().toggleButtons();
        }
    }

    public int formatCords(int[] cords){
        return Integer.parseInt(Integer.toString(Integer.parseInt(Arrays.toString(cords).replaceAll(" ", "").
                replaceAll("\\[", "").
                replaceAll("\\]", "").
                replaceAll(",", ""), 8), 10));
    }
}

package Controller.BoardController.State;

import Controller.BoardController.BoardController;
import Controller.BoardController.Command.CommandInvoker;

import static Controller.BoardController.Command.CommandInvoker.getCommandInvoker;

public class BoardControllerWaitingActionState extends BoardControllerState{

    @Override
    public void terrainClicked(int[] cords) throws Exception {
        BoardController.getCommandoBuilder().addDestiny(cords);
        CommandInvoker.getCommandInvoker().add(BoardController.getCommandoBuilder().build());
        CommandInvoker.getCommandInvoker().execute();
    }

}

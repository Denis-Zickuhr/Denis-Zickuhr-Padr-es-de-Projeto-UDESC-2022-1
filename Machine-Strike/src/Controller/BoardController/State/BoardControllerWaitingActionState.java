package Controller.BoardController.State;

import Controller.BoardController.BoardController;
import Controller.BoardController.Command.CommandInvoker;
import Controller.BoardController.Command.Commands.Attack;
import Controller.BoardController.Command.Commands.AttackDistance;
import Controller.BoardController.Command.Commands.Move;
import Model.AbstractModel.Machine;

public class BoardControllerWaitingActionState extends BoardControllerState{

    @Override
    public void terrainClicked(int[] cords) throws Exception {

        BoardController.getCommandoBuilder().addDestiny(cords);

        int[] cordsOrigin = BoardController.getCommandoBuilder().getOrigin();
        int[] cordsDestiny = BoardController.getCommandoBuilder().getDestiny();
        int distance = Math.max(Math.abs(cordsOrigin[0] - cordsDestiny[0]), Math.abs(cordsOrigin[1] - cordsDestiny[1]));

        Machine originMachine = BoardController.getInstance().getBoard().getTerrain(cordsOrigin).getMachine();
        if(BoardController.getCommandoBuilder().getClass() == Attack.CommandoBuilder.class){
            if(distance <= originMachine.getAttackDistance()) {
                CommandInvoker.getCommandInvoker().add(BoardController.getCommandoBuilder().build());
                CommandInvoker.getCommandInvoker().execute();
            }else{
                System.out.println("Muito longe para atacar, cancele o comando ou tente atacar outra peça");
            }
        }
        if(BoardController.getCommandoBuilder().getClass() == Move.CommandoBuilder.class){
            if(distance <= originMachine.getMoveSpan()) {
                CommandInvoker.getCommandInvoker().add(BoardController.getCommandoBuilder().build());
                CommandInvoker.getCommandInvoker().execute();
            }else{
                System.out.println("Muito longe para mover, cancele o comando ou tente mover para outro lugar peça");
            }
        }
        if(BoardController.getCommandoBuilder().getClass() == AttackDistance.CommandoBuilder.class){
            CommandInvoker.getCommandInvoker().add(BoardController.getCommandoBuilder().build());
            CommandInvoker.getCommandInvoker().execute();
        }


//        BoardController.getInstance().getTerrain().getMachine()
//
//
//        if(BoardController.getInstance().getTerrain().getMachine().getMoveSpan() )

        //if(BoardController.getInstance().getBoard().getTerrain(cordsDestiny).getMachine().getPoints() > 0)


    }

}

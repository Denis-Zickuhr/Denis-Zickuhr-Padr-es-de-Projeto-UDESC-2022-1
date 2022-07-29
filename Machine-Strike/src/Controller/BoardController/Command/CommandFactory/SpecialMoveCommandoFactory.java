package Controller.BoardController.Command.CommandFactory;

import Controller.BoardController.Command.Commands.Overcharge;
import Controller.BoardController.Command.Commands.SpecialMove;

public class SpecialMoveCommandoFactory implements AbstractCommandoFactory<SpecialMove.CommandoBuilder>{

    @Override
    public SpecialMove.CommandoBuilder createCommandBuilder() {
        return new SpecialMove.CommandoBuilder();
    }
}

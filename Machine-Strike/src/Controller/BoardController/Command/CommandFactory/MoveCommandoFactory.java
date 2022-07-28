package Controller.BoardController.Command.CommandFactory;

import Controller.BoardController.Command.AbstractCommandoBuilder;
import Controller.BoardController.Command.Commands.Attack;
import Controller.BoardController.Command.Commands.Move;

public class MoveCommandoFactory implements AbstractCommandoFactory<Move.CommandoBuilder>{

    @Override
    public Move.CommandoBuilder createCommandBuilder() {
        return new Move.CommandoBuilder();
    }
}

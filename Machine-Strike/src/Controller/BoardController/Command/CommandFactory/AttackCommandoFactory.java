package Controller.BoardController.Command.CommandFactory;

import Controller.BoardController.Command.AbstractCommandoBuilder;
import Controller.BoardController.Command.Commands.Attack;
import Controller.BoardController.Command.Commands.Move;

public class AttackCommandoFactory implements AbstractCommandoFactory<Attack.CommandoBuilder>{

    @Override
    public Attack.CommandoBuilder createCommandBuilder() {
        return new Attack.CommandoBuilder();
    }
}

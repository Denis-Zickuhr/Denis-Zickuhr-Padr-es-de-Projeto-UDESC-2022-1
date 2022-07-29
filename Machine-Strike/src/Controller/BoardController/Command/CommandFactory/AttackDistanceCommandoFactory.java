package Controller.BoardController.Command.CommandFactory;

import Controller.BoardController.Command.Commands.Attack;
import Controller.BoardController.Command.Commands.AttackDistance;

public class AttackDistanceCommandoFactory implements AbstractCommandoFactory<AttackDistance.CommandoBuilder>{

    @Override
    public AttackDistance.CommandoBuilder createCommandBuilder() {
        return new AttackDistance.CommandoBuilder();
    }
}

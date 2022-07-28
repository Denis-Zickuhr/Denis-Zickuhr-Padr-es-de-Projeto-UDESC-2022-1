package Controller.BoardController.Command.CommandFactory;

import Controller.BoardController.Command.Commands.Overcharge;

public class OverchargeCommandoFactory implements AbstractCommandoFactory<Overcharge.CommandoBuilder>{

    @Override
    public Overcharge.CommandoBuilder createCommandBuilder() {
        return new Overcharge.CommandoBuilder();
    }
}

package Controller.BoardController.Command.CommandFactory;

import Controller.BoardController.Command.AbstractCommandoBuilder;

public interface AbstractCommandoFactory<T extends AbstractCommandoBuilder> {

      T createCommandBuilder();

}

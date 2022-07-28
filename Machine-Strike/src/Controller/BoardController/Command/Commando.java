package Controller.BoardController.Command;

public interface Commando {

     void execute() throws Exception;
     void undo() throws Exception;
     void redo() throws Exception;

}

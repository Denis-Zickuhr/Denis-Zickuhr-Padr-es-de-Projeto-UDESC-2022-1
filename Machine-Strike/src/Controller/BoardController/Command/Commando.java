package Controller.BoardController.Command;

public interface Commando {

    void execute(int[] destiny) throws Exception;
    void undo(int[] origin) throws Exception;
    void redo(int[] destiny) throws Exception;

}

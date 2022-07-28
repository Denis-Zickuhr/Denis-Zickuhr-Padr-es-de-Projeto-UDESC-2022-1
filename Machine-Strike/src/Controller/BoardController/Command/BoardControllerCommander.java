package Controller.BoardController.Command;

public abstract class BoardControllerCommander implements Controller.BoardController.Command.Commando {

    protected final int[] destiny;
    protected final int[] origin;
    protected boolean executable;
    public BoardControllerCommander(AbstractCommandoBuilder commandoBuilder) {
        this.origin = commandoBuilder.getOrigin();
        this.destiny = commandoBuilder.getDestiny();
        this.executable = commandoBuilder.isExecutable();
    }
}

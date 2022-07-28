package Controller.BoardController.Command;

public abstract class AbstractCommandoBuilder {

    private int[] origin;
    private int[] destiny;


    public AbstractCommandoBuilder addOrigin(int[] origin){
        this.origin = origin;
        return this;
    }

    public AbstractCommandoBuilder addDestiny(int[] destiny){
        this.destiny = destiny;
        return this;
    }

    public boolean isExecutable() {
        return false;
    }

    public int[] getOrigin() {
        return origin;
    }

    public int[] getDestiny() {
        return destiny;
    }

    public void reset(){
        this.origin = null;
        this.destiny = null;
    }

    abstract public Commando build();

}

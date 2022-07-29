package Model.AbstractModel;

public abstract class AbstractStrategy {

    public AbstractStrategy(String description) {
        this.description = description;
    }

    private final String description;

    @Override
    public String toString(){
        return this.description;
    }

    public abstract MachineSoldierEntity build();

    public abstract MachineSoldierEntity buildRadio() throws Exception;

}

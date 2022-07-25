package Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.AbstractStrategy;

import Model.AbstractModel.AbstractMachine.AbstractProduct.SoldierMachine.MachineSoldierEntity;

public abstract class AbstractStrategy {

    public AbstractStrategy(String description) {
        this.description = description;
    }

    private String description;

    @Override
    public String toString(){
        return this.description;
    }

    public abstract MachineSoldierEntity build();

    public abstract MachineSoldierEntity buildRadio() throws Exception;

}
